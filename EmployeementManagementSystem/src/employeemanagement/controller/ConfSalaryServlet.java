package employeemanagement.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import employeemanagement.Hr_EmployeeDBOperations;
import employeemanagement.DBOperations.ConfSalaryDBOperations;
import employeemanagement.model.SalaryConf;


@WebServlet("/ConfSalaryServlet")
public class ConfSalaryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		double basicPay = Double.parseDouble(request.getParameter("basicPay"));
		double specialPay = Double.parseDouble(request.getParameter("specialPay"));
		double professionalPay = Double.parseDouble(request.getParameter("professionalTaxPay"));
		double drPay = Double.parseDouble(request.getParameter("drPay"));
		double incomeTaxPay = Double.parseDouble(request.getParameter("incomeTaxPay"));
		double lopPay = Double.parseDouble(request.getParameter("lopPay"));
		double paPay = Double.parseDouble(request.getParameter("paPay"));
		double otherAllowancesPay = Double.parseDouble(request.getParameter("otherAllowancesPay"));
		double otherDeductionsPay = Double.parseDouble(request.getParameter("otherDeductionsPay"));
		int empId = Integer.parseInt(request.getParameter("empId"));
		
		SalaryConf conf = new SalaryConf();
		conf.setBasicPay(basicPay);
        conf.setDrPay(drPay);
        conf.setEmpId(empId);
        conf.setIncomeTaxPay(incomeTaxPay);
        conf.setLopPay(lopPay);
        conf.setOtherAllowancesPay(otherAllowancesPay);
        conf.setOtherDeductionsPay(otherDeductionsPay);
        conf.setPaPay(paPay);
        conf.setProfessionalPay(professionalPay);
        conf.setSpecialPay(specialPay);
        
        int j = Hr_EmployeeDBOperations.updateSalConf(empId);
        int i = ConfSalaryDBOperations.saveConfSal(conf);
        
        if(i>0)
        {
        	request.setAttribute("msg", "Salary Configured successfully for ID "+empId);
        	request.getServletContext().getRequestDispatcher("/adminhome.jsp").forward(request, response);
        }
        else
        {
        	
        	request.setAttribute("msg", "Something went wrong");
        	request.getServletContext().getRequestDispatcher("/adminhome.jsp").forward(request, response);
        	
        }
        
  	}

}
