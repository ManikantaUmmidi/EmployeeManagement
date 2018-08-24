package employeemanagement.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import employeemanagement.DBOperations.MessDBOperations;
import employeemanagement.model.Message;

@WebServlet("/SendMessageServlet")
public class SendMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		String pagename=request.getParameter("pagename");
		String heading = request.getParameter("heading");
		String description = request.getParameter("description");
		String status = request.getParameter("status");
		 
		int empId = Integer.parseInt(request.getParameter("empId"));
		int senderId = Integer.parseInt(request.getParameter("senderId"));
		
		Message mes = new Message();
		mes.setDescription(description);
		mes.setEmpId(empId);
		mes.setHeading(heading);
		mes.setSendDate(new Date());
		mes.setSenderId(senderId);
		mes.setStatus("unread");
		
		int row = MessDBOperations.saveMessage(mes);
		
		if(row>0)
		{
			request.setAttribute("msg", "message sent successfully");
			request.getServletContext().getRequestDispatcher(pagename).forward(request, response);
		}
		
			
		
		
		
		
		
	}

}
