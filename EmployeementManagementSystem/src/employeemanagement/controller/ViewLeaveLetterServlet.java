package employeemanagement.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import employeemanagement.GetUserFromSession;
import employeemanagement.DBOperations.LeaveStatusDBOperation;
import employeemanagement.model.ApplyLeave;


@WebServlet("/ViewLeaveLetterServlet")
public class ViewLeaveLetterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		String pagename=request.getParameter("pagename");
		System.out.println("lettter id "+id);
		
		LeaveStatusDBOperation.updateLeaveStatusById(id);
		
		
		ApplyLeave leave = LeaveStatusDBOperation.getAllLeaveLetterById(id);
		
		request.setAttribute("leave", leave);
		request.getServletContext().getRequestDispatcher(pagename).forward(request, response);
		
		
		
	}

	

}
