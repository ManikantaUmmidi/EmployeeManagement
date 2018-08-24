package employeemanagement.DBOperations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import employeemanagement.DbConnection;
import employeemanagement.model.PaySalary;
import employeemanagement.model.SalaryConf;

public class PaySalaryDBOperation {
	static Connection conn = DbConnection.getConnection();
	
	public static int saveEmpSalary(SalaryConf conf){
		int i = 0;
		
		Calendar cal = Calendar.getInstance();
		String currentMonth = new SimpleDateFormat("MMM").format(cal.getTime());
		
	
	String currentYear = new SimpleDateFormat("yyyy").format(cal.getTime());
		
		try {
			PreparedStatement ps = conn.prepareStatement("insert into paysal (basicPay,specialPay,professionalPay,drPay,incomeTaxPay,lopPay,paPay,otherAllowancesPay,otherDeductionsPay,empId,month,year) values(?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setDouble(1, conf.getBasicPay());
			ps.setDouble(2, conf.getSpecialPay());
			ps.setDouble(3, conf.getProfessionalPay());
			ps.setDouble(4, conf.getDrPay());
			ps.setDouble(5, conf.getIncomeTaxPay());
			ps.setDouble(6, conf.getLopPay());
			ps.setDouble(7, conf.getPaPay());
			ps.setDouble(8, conf.getOtherAllowancesPay());
			ps.setDouble(9, conf.getOtherDeductionsPay());
			ps.setInt(10, conf.getEmpId());
			ps.setString(11,currentMonth);
			ps.setInt(12, Integer.parseInt(currentYear));
			i = ps.executeUpdate();
		 
		 
		 
		 
		 } catch (SQLException e) {
			e.printStackTrace();
		}
		
		return i;
	}
	
	public static PaySalary getSalByMonthYearId(int empId,String month,int year)
	{
		PaySalary sal = new PaySalary();
		
		try {
			PreparedStatement ps = conn.prepareStatement("select * from paysal where empId=? and month=? and year=?");
			ps.setInt(1, empId);
			ps.setString(2, month);
			ps.setInt(3, year);
			ResultSet rs = ps.executeQuery();
		    if(rs.next())
		    {
		    sal.setBasicPay(rs.getDouble("basicPay"));
		    sal.setDrPay(rs.getDouble("drPay"));
		    sal.setEmpId(rs.getInt("empId"));
		    sal.setId(rs.getInt("id"));
		    sal.setIncomeTaxPay(rs.getDouble("incomeTaxPay"));
		    sal.setLopPay(rs.getDouble("lopPay"));
		    sal.setMonth(rs.getString("month"));
		    sal.setOtherAllowancesPay(rs.getDouble("otherAllowancesPay"));
		    sal.setOtherDeductionsPay(rs.getDouble("otherDeductionsPay"));
		    sal.setPaPay(rs.getDouble("paPay"));
		    sal.setProfessionalPay(rs.getDouble("professionalPay"));
		    sal.setSpecialPay(rs.getDouble("specialPay"));
		    sal.setYear(rs.getInt("year"));
		    
		    }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sal;
	}

}
