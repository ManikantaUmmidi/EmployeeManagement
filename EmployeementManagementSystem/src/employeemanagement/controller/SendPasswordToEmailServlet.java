package employeemanagement.controller;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import employeemanagement.EmailValidatorHelper;
import employeemanagement.Hr_EmployeeDBOperations;
import employeemanagement.NetworkConnectOrNot;
import employeemanagement.model.Hr_EmpModel;

@WebServlet("/SendPasswordToEmailServlet")
public class SendPasswordToEmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");

		if (NetworkConnectOrNot.isNetworkAvailble()) {

			if (EmailValidatorHelper.isAddressValid(email)) {
				  
				
				Hr_EmpModel emp = Hr_EmployeeDBOperations.getHr_EmpByEmail(email);
				System.out.println(emp.getPassowrd());
				if(emp.getId()==0)
				{
					
					request.setAttribute("msg", "No Record is available with this :"+email);
					request.getServletContext().getRequestDispatcher("/forgotpassword.jsp").forward(request, response);
					
				}
				else
				{
				
				final String username = "ummidimanikanta484@gmail.com";
				final String password = "Manikanta@484";

				Properties props = new Properties();
				props.put("mail.smtp.auth", "true");
				props.put("mail.smtp.starttls.enable", "true");
				props.put("mail.smtp.host", "smtp.gmail.com");
				props.put("mail.smtp.port", "587");

				Session session = Session.getInstance(props, new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
					}
				});

				try {

					Message message = new MimeMessage(session);
					message.setFrom(new InternetAddress(username));
					message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
					message.setSubject("Your Password");
					message.setText("Please do not share this password to others..password is :"+emp.getPassowrd());

					Transport.send(message);

					System.out.println("Done");
               
				} catch (MessagingException e) {
					throw new RuntimeException(e);
				}
 
				request.setAttribute("msg", "password has been sent to email :"+email);
				request.getServletContext().getRequestDispatcher("/forgotpassword.jsp").forward(request, response);
				}

			} else {

				request.setAttribute("msg", email+" is not valid..");
				request.getServletContext().getRequestDispatcher("/forgotpassword.jsp").forward(request, response);
			}
		} else {

			
			request.setAttribute("msg", "Internet Connection is not availbale..");
			request.getServletContext().getRequestDispatcher("/forgotpassword.jsp").forward(request, response);
		}

		}

}
