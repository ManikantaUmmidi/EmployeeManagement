package employeemanagement.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import employeemanagement.DBOperations.LeaveStatusDBOperation;


@WebServlet("/RejectLeaveServlet")
public class RejectLeaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int empId = Integer.parseInt(request.getParameter("empId"));
		  LeaveStatusDBOperation.updateLeaveStatusToReject(empId);
		  
		 String pagename = request.getParameter("pagename");
		  
		  request.setAttribute("msg", "leave latter has been rejected.");
		  request.getServletContext().getRequestDispatcher(pagename).forward(request, response);
		
		
	
	
	}
}