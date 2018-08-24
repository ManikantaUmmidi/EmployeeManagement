package employeemanagement.DBOperations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import employeemanagement.DbConnection;
import employeemanagement.model.Dept;

public class Department {
	
	static Connection conn = DbConnection.getConnection();
	
	public static List<Dept> getAllDepartment()
	{
		List<Dept> deptList =  new ArrayList<Dept>();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from department");
 		    ResultSet rs = ps.executeQuery();
            rs.last();
            int countRows = rs.getRow();
		    Dept[] dept = new Dept[countRows];
		    rs.beforeFirst();
		    
		    int count=0;
		    while(rs.next())
		    {
		    	dept[count] = new Dept();
		    	dept[count].setDept(rs.getString("dept"));
		    	deptList.add(dept[count]);
		    	count++;
		    }
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return deptList;
	}
	
	

}
