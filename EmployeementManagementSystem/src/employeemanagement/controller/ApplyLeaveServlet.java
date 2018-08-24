package employeemanagement.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import employeemanagement.GetUserFromSession;
import employeemanagement.DBOperations.LeaveStatusDBOperation;
import employeemanagement.model.ApplyLeave;


@WebServlet("/ApplyLeaveServlet")
public class ApplyLeaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
		
			String pagename = request.getParameter("pagename");
			  int hr = GetUserFromSession.getHrNameFromSession(request);
			
			  if(hr > 0)
			  {
			
		 int empId = GetUserFromSession.getIdFromSession(request);
		 
		 
		 
		
		  String fromDate = request.getParameter("fromDate");
		  String toDate = request.getParameter("toDate");
		  String reason = request.getParameter("reason");
		  String typeofLeave = request.getParameter("typeofLeave");
		  
		  
		  SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		  Date fromdate = format.parse(fromDate);
		  Date todate = format.parse(toDate);
		  
		  ApplyLeave apply = new ApplyLeave();
		  apply.setEmpId(empId);
		  apply.setFromDate(fromdate);
		  apply.setLetter("unread");
		  
		  Calendar cal = Calendar.getInstance();
		  String month = new SimpleDateFormat("MMM").format(cal.getTime());
		  
		  apply.setMonth(month);
		  apply.setReason(reason);
		  apply.setStatus("pending");
		  apply.setToDate(todate);
		  apply.setTypeofLeave(typeofLeave);
		  
		  int i = 0;
		  if(!LeaveStatusDBOperation.getLeaveStatus(empId))
		  {
			
			  
		  i = LeaveStatusDBOperation.saveLeaveStatus(apply,hr);
		  
		  }
		  if(i == -1)
		  {
			  request.setAttribute("msg", "You have taken enough leave for this month or please decrease values of <br> number of leaves or leave atleast  1 day");
	          request.getServletContext().getRequestDispatcher(pagename).forward(request, response);
		  }
		  else if(i == 0){
			  request.setAttribute("msg", "your previous leave not yet approved please contact to admin");
	          request.getServletContext().getRequestDispatcher(pagename).forward(request, response);
		    
			  
		  }
		  else{
			  request.setAttribute("msg", "application for leave is successful");
	          request.getServletContext().getRequestDispatcher(pagename).forward(request, response);
		    
		  }
		  
			  }
			  else{
				  request.setAttribute("msg", "hr have not been assigned, please contact admin");
		          request.getServletContext().getRequestDispatcher(pagename).forward(request, response);
			  }
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		  
		
		
		
		
		
	}

}
