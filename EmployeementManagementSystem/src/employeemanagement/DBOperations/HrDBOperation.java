package employeemanagement.DBOperations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import employeemanagement.DbConnection;
import employeemanagement.GetUserFromSession;
import employeemanagement.model.Hr_EmpModel;

public class HrDBOperation {

	static Connection conn = DbConnection.getConnection();

	public static Hr_EmpModel hrlogin(String username,String password)
	{
		
		Hr_EmpModel hr = new Hr_EmpModel();
		
             try {
            	 
            	 PreparedStatement ps = conn.prepareStatement("select * from hr_emp where email=? and password=? and dept=?");
            	 ps.setString(1, username);
            	 ps.setString(2, password);
            	 ps.setString(3, "hr");
            	 ResultSet rs = ps.executeQuery();
            	 if(rs.next())
            	 {
                     
            		 hr.setName(rs.getString("name"));
            		 hr.setId(rs.getInt("id"));
            		 hr.setHr(rs.getInt("hr"));
            		 
            		 
            	 }
			} catch (Exception e) {
			}
		
		return hr;
	}
	
	public static  List<Hr_EmpModel>  getAllEmps(int name)
	{
		List<Hr_EmpModel> hr_empList = new ArrayList<Hr_EmpModel>();
		try {
			PreparedStatement ps=conn.prepareStatement("select  * from hr_emp where  hr=?");
			
			ps.setInt(1, name);
			 ResultSet rs=ps.executeQuery();
			  rs.last();
			    int rowCount = rs.getRow();
			    Hr_EmpModel[] hr_emp = new Hr_EmpModel[rowCount];
			    rs.beforeFirst();
			  
			 int count=0;
			    while(rs.next())
			    {
			    	System.out.println("address "+rs.getString("address"));
			    	hr_emp[count] = new Hr_EmpModel(); 
			    	hr_emp[count].setAddress(rs.getString("address"));
			    	hr_emp[count].setContact(rs.getString("contact"));
			    	hr_emp[count].setDesignation(rs.getString("designation"));
			    	hr_emp[count].setDob(rs.getDate("dob"));
			    	hr_emp[count].setEmail(rs.getString("email"));
			    	hr_emp[count].setId(rs.getInt("id"));
			    	hr_emp[count].setName(rs.getString("name"));
			    	hr_emp[count].setProfilepic(rs.getBinaryStream("profilepic"));
			    	hr_empList.add(hr_emp[count]);
			    	count++;
			    
			    }
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return hr_empList;
		
	}
	
	
	
	
	
}
