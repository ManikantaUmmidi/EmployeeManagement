package employeemanagement.DBOperations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import employeemanagement.DbConnection;
import employeemanagement.model.Leaves;

public class LeavesDBOperation {
	
	static Connection conn = DbConnection.getConnection();
	public static int saveLeaves(Leaves leaves)
	{
		int i = 0;
		PreparedStatement ps;
		PreparedStatement ps2;
		try {
			ps = conn.prepareStatement("select * from leaves where empId=? and year=?");
			ps.setInt(1, leaves.getEmpId());
			ps.setInt(2, leaves.getYear());
		    ResultSet rs = ps.executeQuery();
		    if(rs.next())
		    {
		    	
		    	i = -1;
		    	
		    }
		    else
		    {
		    	ps2 = conn.prepareStatement("insert into leaves (casualleave,medicalleave,earnedleaves,year,empId) values(?,?,?,?,?)");
		    	ps2.setInt(1, leaves.getCasualleaves());
		    	ps2.setInt(2, leaves.getMedicalleaves());
		    	ps2.setInt(3, leaves.getEarnedleaves());
		    	ps2.setInt(4, leaves.getYear());
		    	ps2.setInt(5, leaves.getEmpId());
		    	i = ps2.executeUpdate();
		    }
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return i;
	}

}
