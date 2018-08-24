package employeemanagement.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import employeemanagement.DBOperations.LeaveStatusDBOperation;
import employeemanagement.model.ApplyLeave;


@WebServlet("/ApproveLeave")
public class ApproveLeaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		String pagename = request.getParameter("pagename");
		int empId = Integer.parseInt(request.getParameter("empId"));
		LeaveStatusDBOperation.updateLeaveStatusToApprove(empId);
		ApplyLeave leave = LeaveStatusDBOperation.getAllLeaveLetterByEmpId(empId);
		LeaveStatusDBOperation.saveLeaveTakenData(leave);
		LeaveStatusDBOperation.updateActualLeave(leave);
		
		request.setAttribute("msg", "leave has been approve for employee "+empId);
		request.getServletContext().getRequestDispatcher(pagename).forward(request, response);
	}

	

}
