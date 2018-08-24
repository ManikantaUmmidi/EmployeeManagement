package employeemanagement.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import employeemanagement.DbConnection;
import employeemanagement.EmailValidatorHelper;
import employeemanagement.NetworkConnectOrNot;


@WebServlet("/RegistrationServlet")
@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
maxFileSize=1024*1024*10,      // 10MB
maxRequestSize=1024*1024*50)   // 50MB
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");

		if (NetworkConnectOrNot.isNetworkAvailble()) {

			if (EmailValidatorHelper.isAddressValid(email)) {
				
				
				PrintWriter out = response.getWriter();
				out.println("inside registration servlet");
				String name = request.getParameter("name");
				String dob = request.getParameter("dob");
		             out.println(dob);
				String designation = request.getParameter("designation");
				String address = request.getParameter("address");
				String contact = request.getParameter("contact");
				String password = request.getParameter("password");
				String empType = request.getParameter("empType");
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				
				try {
					
					Part filePart = request.getPart("profilepic");
					
					Date date = format.parse(dob);
					java.sql.Date sqlDate =new  java.sql.Date(date.getTime());
					System.out.println(sqlDate);
					Connection conn = DbConnection.getConnection();
					
					PreparedStatement ps = conn.prepareStatement("insert into hr_emp (name,email,designation,contact,dob,address,password,empType,profilepic,salConf) values(?,?,?,?,?,?,?,?,?,?)");
					ps.setString(1, name);
					ps.setString(2, email);
					ps.setString(3, designation);
					ps.setString(4, contact);
					ps.setDate(5, sqlDate);
					ps.setString(6, address);
					ps.setString(7, password);
					ps.setString(8, empType);
					ps.setBlob(9, filePart.getInputStream());
					ps.setString(10, "notconfigured");
					
					int i = ps.executeUpdate();
					
					if(i > 0 )
					{
						request.setAttribute("msg", name+" is added successfully.");
						request.getServletContext().getRequestDispatcher("/employeelogin.jsp").forward(request, response);
					}
					
					
				} catch (ParseException | SQLException e) {
					e.printStackTrace();
				}
				
				
			}
			else{
				
				
				request.setAttribute("msg", email+" is not valid email ID, please try again..");
				request.getServletContext().getRequestDispatcher("/employeeReg.jsp").forward(request, response);
			}
		}
		else
		{
			request.setAttribute("msg", "Internet Connection is not availble please try again..");
			request.getServletContext().getRequestDispatcher("/employeeReg.jsp").forward(request, response);
			
		}
		
		
	}

}
