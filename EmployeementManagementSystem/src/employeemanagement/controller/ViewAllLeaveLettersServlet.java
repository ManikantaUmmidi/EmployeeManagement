package employeemanagement.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import employeemanagement.GetUserFromSession;
import employeemanagement.DBOperations.LeaveStatusDBOperation;
import employeemanagement.model.ApplyLeave;


@WebServlet("/ViewAllLeaveLettersServlet")
public class ViewAllLeaveLettersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String pagename = request.getParameter("pagename");
	    System.out.println("pagename "+pagename);
		int hrname=GetUserFromSession.getIdFromSession(request);
		List<ApplyLeave> appList = LeaveStatusDBOperation.getAllLeaveLetters(hrname);
		
		if(appList.size()>0)
		{
		request.setAttribute("letterList", appList);
		request.getServletContext().getRequestDispatcher(pagename).forward(request, response);
		}
		else
		{
			request.setAttribute("msg", "No Data Availble");
			request.getServletContext().getRequestDispatcher(pagename).forward(request, response);
		}
	}

	

}
