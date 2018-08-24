package employeemanagement.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import employeemanagement.DBOperations.AttendanceDbOperation;
import employeemanagement.DBOperations.HrDBOperation;
import employeemanagement.model.Hr_EmpModel;


@WebServlet("/HRLoginServlet")
public class HRLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String username =  request.getParameter("username");
		String password  = request.getParameter("password");
		
		Hr_EmpModel hr = HrDBOperation.hrlogin(username, password);
		
		if(hr.getId()!=0)
		{
			
			 boolean status = AttendanceDbOperation.checkAttendance(hr.getId());
			 if(!status)
			 {
			 AttendanceDbOperation.saveattance(hr.getId());
			 }
            request.getSession().setAttribute("name", hr.getName());
            request.getSession().setAttribute("userId", hr.getId());
            request.getSession().setAttribute("hr", hr.getHr());
			request.getServletContext().getRequestDispatcher("/hrhome.jsp").forward(request, response);
		}
		else
		{
			request.setAttribute("msg", "username or password wrong");
			request.getServletContext().getRequestDispatcher("/hrlogin.jsp").forward(request, response);
			
		}
	}

	
}
