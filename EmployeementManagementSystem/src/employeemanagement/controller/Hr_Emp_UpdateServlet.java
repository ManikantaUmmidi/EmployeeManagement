package employeemanagement.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import employeemanagement.Hr_EmployeeDBOperations;
import employeemanagement.model.Hr_EmpModel;

@WebServlet("/Hr_Emp_UpdateServlet")
public class Hr_Emp_UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	  
		String pagename = request.getParameter("pagename");
	    int id = Integer.parseInt(request.getParameter("id"));
		String dob = request.getParameter("dob");
		String designation = request.getParameter("designation");
		String address = request.getParameter("address");
		String contact = request.getParameter("contact");
		int hr = Integer.parseInt(request.getParameter("hr"));
		String dept = request.getParameter("dept");
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = format.parse(dob);
			java.sql.Date sqlDate =new  java.sql.Date(date.getTime());
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		
		Hr_EmpModel hr_emp = new Hr_EmpModel();
		hr_emp.setId(id);
		hr_emp.setDob(date);
		hr_emp.setContact(contact);
		
		hr_emp.setDesignation(designation);
		hr_emp.setAddress(address);
		hr_emp.setHr(hr);
		hr_emp.setDepartment(dept);
		int i = Hr_EmployeeDBOperations.updateHr_Emp(hr_emp);
		
		
	    if(i>0)
	    {
	    	request.getServletContext().getRequestDispatcher(pagename+"?msg=updated successfully").forward(request,response);
	    }
	    else
	    {
	    	request.getServletContext().getRequestDispatcher(pagename+"?msg=please provide proper information").forward(request,response);
	    }
		
	}

}
