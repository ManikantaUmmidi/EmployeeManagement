package employeemanagement.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import employeemanagement.Hr_EmployeeDBOperations;
import employeemanagement.model.Hr_EmpModel;


@WebServlet("/ViewAllEmps_HrsServlet")
public class ViewAllEmps_HrsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String pagename = request.getParameter("pagename");
		List<Hr_EmpModel> empList =  Hr_EmployeeDBOperations.getAllHr_Emps();
		
		if(pagename == null)
		{
		if(empList.size()!=0)
		{
			request.setAttribute("empList",empList);
			request.getServletContext().getRequestDispatcher("/viewallemployees.jsp").forward(request, response);
		}
		}
		else
		{
			request.setAttribute("empList",empList);
			request.getServletContext().getRequestDispatcher("/"+pagename).forward(request, response);
		}
		
		
		
		
		
	}

}
