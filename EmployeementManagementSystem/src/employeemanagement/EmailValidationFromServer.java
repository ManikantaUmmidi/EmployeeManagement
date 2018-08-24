package employeemanagement;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/EmailValidationFromServer")
public class EmailValidationFromServer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      
		response.setContentType("text/plain;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String email = request.getParameter("email");
		System.out.println(email);
		
		
		if(NetworkConnectOrNot.isNetworkAvailble())
		{
		
		if(EmailValidatorHelper.isAddressValid(email))
		{
			out.println("VALID");
		}
		else
		{
			out.println("NOT VALID");
		}
		}
		else
		{
			out.println("NET WORK IS NOT AVAILBALE");
		}
	 
	}

}
