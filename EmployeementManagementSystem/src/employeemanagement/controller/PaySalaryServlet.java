package employeemanagement.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import employeemanagement.DBOperations.ConfSalaryDBOperations;
import employeemanagement.DBOperations.PaySalaryDBOperation;
import employeemanagement.model.PaySalary;
import employeemanagement.model.SalaryConf;


@WebServlet("/PaySalaryServlet")
public class PaySalaryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          

		Calendar cal = Calendar.getInstance();
		String currentMonth = new SimpleDateFormat("MMM").format(cal.getTime());
    	String currentYear = new SimpleDateFormat("yyyy").format(cal.getTime());
         
    	String[] id = request.getParameterValues("empIdList");	   
           for(String ids :id)
           {
        	   System.out.println(ids);
        	   int empId = Integer.parseInt(ids);
        	   
        	   SalaryConf conf =  ConfSalaryDBOperations.getSalConById(empId);
        	   PaySalary sal =   PaySalaryDBOperation.getSalByMonthYearId(conf.getEmpId(), currentMonth, Integer.parseInt(currentYear));
        	   
        	   if(sal.getId()==0)
        	   {
        	   PaySalaryDBOperation.saveEmpSalary(conf);
        	   }
        	   else
        	   {
        		   System.out.println("already paid");
        	   }
            }
           
           request.setAttribute("msg", "Done..");
           request.getServletContext().getRequestDispatcher("/adminhome.jsp").forward(request, response);
	
	
	}


}
