package employeemanagement.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import employeemanagement.Hr_EmployeeDBOperations;
import employeemanagement.DBOperations.LeavesDBOperation;
import employeemanagement.model.Hr_EmpModel;
import employeemanagement.model.Leaves;


@WebServlet("/SaveLeavesServlet")
public class SaveLeavesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   		int i=0;
	   	Calendar cal = Calendar.getInstance();
		String currentYear = new SimpleDateFormat("yyyy").format(cal.getTime());
   		int casualleaves = Integer.parseInt(request.getParameter("casualleaves"));
   		int medicalleaves = Integer.parseInt(request.getParameter("medicalleaves"));
   		int earnedleaves = Integer.parseInt(request.getParameter("earnedleaves"));
   		
   		Leaves leaves = new Leaves();
   		leaves.setCasualleaves(casualleaves);
   		leaves.setMedicalleaves(medicalleaves);
   		leaves.setEarnedleaves(earnedleaves);
   		leaves.setYear(Integer.parseInt(currentYear));
   		
   		List<Hr_EmpModel> empList = Hr_EmployeeDBOperations.getAllHr_Emps();
   		for(int j=0;j<empList.size();j++)
   		{
   		leaves.setEmpId(empList.get(j).getId());
   	    i = LeavesDBOperation.saveLeaves(leaves);
   		}
   	    if(i==-1)
   	    {
   	    	request.setAttribute("msg", "configuration already done for year of "+leaves.getYear());
   	    	request.getServletContext().getRequestDispatcher("/adminhome.jsp").forward(request, response);
   	    }
   	    else if(i==0)
   	    {
   	    	request.setAttribute("msg", "something went wrong please provide proper values in text boxes");
   	    	request.getServletContext().getRequestDispatcher("/adminhome.jsp").forward(request, response);
   	    	
   	    }
   	    else
   	    {
   	    	request.setAttribute("msg", "successfully configured for month of "+leaves.getYear());
   	    	request.getServletContext().getRequestDispatcher("/adminhome.jsp").forward(request, response);
   	    }
   	
   	}

}
