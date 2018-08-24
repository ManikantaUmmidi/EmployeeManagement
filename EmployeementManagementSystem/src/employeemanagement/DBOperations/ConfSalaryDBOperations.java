package employeemanagement.DBOperations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import employeemanagement.DbConnection;
import employeemanagement.model.SalaryConf;

public class ConfSalaryDBOperations {
	
	static Connection conn = DbConnection.getConnection();
	
	public static int saveConfSal(SalaryConf conf) 
	{
		
		int i = 0;
		
		try {
			conn.setAutoCommit(false);
			PreparedStatement ps = conn.prepareStatement("insert into confSal (basicPay,specialPay,professionalPay,drPay,incomeTaxPay,lopPay,paPay,otherAllowancesPay,otherDeductionsPay,empId) values(?,?,?,?,?,?,?,?,?,?)");
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
			i = ps.executeUpdate();
		    conn.commit();
		
		} catch (Exception e) {
           try {
			conn.commit();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
           e.printStackTrace();
		}
		
		return i;
	}
	
	public static SalaryConf getSalConById(int id)
	{
		SalaryConf conf = new SalaryConf();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from confsal where empId=?");
		    ps.setInt(1, id);
		    ResultSet rs = ps.executeQuery();
		    if(rs.next())
		    {
			conf.setBasicPay(rs.getDouble("basicPay"));
			conf.setDrPay(rs.getDouble("drPay"));
			conf.setEmpId(rs.getInt("empId"));
			conf.setId(rs.getInt("id"));
			conf.setIncomeTaxPay(rs.getDouble("incomeTaxPay"));
			conf.setLopPay(rs.getDouble("lopPay"));
			conf.setOtherAllowancesPay(rs.getDouble("otherAllowancesPay"));
			conf.setOtherDeductionsPay(rs.getDouble("otherDeductionsPay"));
			conf.setPaPay(rs.getDouble("paPay"));
			conf.setProfessionalPay(rs.getDouble("professionalPay"));
			conf.setSpecialPay(rs.getDouble("specialPay"));
		    }
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conf;
	}
}
