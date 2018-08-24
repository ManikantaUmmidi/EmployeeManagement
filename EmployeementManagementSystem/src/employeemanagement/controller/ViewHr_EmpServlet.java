package employeemanagement.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import employeemanagement.Hr_EmployeeDBOperations;
import employeemanagement.model.Hr_EmpModel;


@WebServlet("/ViewHr_EmpServlet")
public class ViewHr_EmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  
		  String pagename = request.getParameter("pagename");
		  
		
		  System.out.println("pagename "+pagename);
		  int id = Integer.parseInt(request.getParameter("id"));
		  
		 Hr_EmpModel hr_emp =  Hr_EmployeeDBOperations.getHr_Emp(id);
		 System.out.println(hr_emp.getProfilepic());
		 PrintWriter out = response.getWriter();
		 request.setAttribute("model", hr_emp);
		 request.getServletContext().getRequestDispatcher("/"+pagename).forward(request, response);
		 
		
		 
/*		  }
		  else
		  {
			 int id1 = Integer.parseInt(request.getParameter("id"));
			 Hr_EmpModel hr_emp =  Hr_EmployeeDBOperations.getHr_Emp(id1);
			 PrintWriter out = response.getWriter();
			 request.setAttribute("model", hr_emp);
			 
			 if(pagename==null)
			 {
				 System.out.println("inside if");
			 request.getServletContext().getRequestDispatcher("/employeeview_admin.jsp").forward(request, response);
			 }
			 else
			 {
				 System.out.println("inside else");
				 request.getServletContext().getRequestDispatcher(pagename).forward(request, response);
			 } 
		  }*/
		
		
		
	}

}
