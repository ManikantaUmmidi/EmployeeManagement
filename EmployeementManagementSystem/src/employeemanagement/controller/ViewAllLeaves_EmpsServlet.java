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


@WebServlet("/ViewAllLeaves_EmpsServlet")
public class ViewAllLeaves_EmpsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int empId = GetUserFromSession.getIdFromSession(request);
		
		String pagename1 = request.getParameter("pagename1");
		String pagename2 = request.getParameter("pagename2");
		
		List<ApplyLeave> leaveList = LeaveStatusDBOperation.getAllLeaveLetterListByEmpId(empId);
		
		if(leaveList.size()>0)
		{
		request.setAttribute("letterList", leaveList);
		request.getServletContext().getRequestDispatcher(pagename1).forward(request, response);
		}
		else
		{
			request.setAttribute("msg", "no leaves heave been applied, so leave letter not available");
			request.getServletContext().getRequestDispatcher(pagename2).forward(request, response);
		}
		
		
		
		
	}

	
}
