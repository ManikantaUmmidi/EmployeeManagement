package employeemanagement;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.sun.javafx.collections.MappingChange.Map;

import employeemanagement.model.Hr_EmpModel;


public class Hr_EmployeeDBOperations {
	
	static Connection conn = DbConnection.getConnection();
	
	public static Hr_EmpModel getHr_Emp(int id)
	{
		PreparedStatement ps;
		Hr_EmpModel hr = new Hr_EmpModel();
		try {
			ps = conn.prepareStatement("select * from hr_emp where id=?");
		
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
		
		hr.setId(rs.getInt("id"));
		hr.setAddress(rs.getString("address"));
		hr.setContact(rs.getString("contact"));
		hr.setDesignation(rs.getString("designation"));
		hr.setDob(rs.getDate("dob"));
		hr.setEmail(rs.getString("email"));
		hr.setName(rs.getString("name"));
		hr.setPassowrd(rs.getString("password"));
		hr.setHr(rs.getInt("hr"));
		hr.setDepartment(rs.getString("dept"));
		hr.setProfilepic(rs.getBinaryStream("profilepic"));
		}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		return hr;
	}
	
	
	public static Hr_EmpModel getHr_EmpByEmail(String email)
	{
		PreparedStatement ps;
		Hr_EmpModel hr = new Hr_EmpModel();
		try {
			ps = conn.prepareStatement("select * from hr_emp where email=?");
		
		ps.setString(1,email);
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
		
		hr.setId(rs.getInt("id"));
		hr.setAddress(rs.getString("address"));
		hr.setContact(rs.getString("contact"));
		hr.setDesignation(rs.getString("designation"));
		hr.setDob(rs.getDate("dob"));
		hr.setEmail(rs.getString("email"));
		hr.setName(rs.getString("name"));
		hr.setPassowrd(rs.getString("password"));
		hr.setHr(rs.getInt("hr"));
		hr.setDepartment(rs.getString("dept"));
		hr.setProfilepic(rs.getBinaryStream("profilepic"));
		}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		return hr;
	}
	
	
	public static int updateHr_Emp(Hr_EmpModel model)
	{
		 int i = 0;
		try {
			PreparedStatement ps = conn.prepareStatement("update hr_emp set address=?,contact=?,designation=?,dob=?,hr=?,dept=? where id=?");
		    
		    Date date = new Date(model.getDob().getTime());
			
			ps.setString(1, model.getAddress());
		    ps.setString(2, model.getContact());
		    ps.setString(3, model.getDesignation());
		    ps.setDate(4, date);
		    ps.setInt(5, model.getHr());
		    ps.setString(6, model.getDepartment());
		    ps.setInt(7, model.getId());
		    
		  i = ps.executeUpdate();
		 
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return i;
	}
	
	public static List<Hr_EmpModel> getAllHr_Emps()
	{
		List<Hr_EmpModel> hr_empList = new ArrayList<Hr_EmpModel>();
		
		
		
		try {
			PreparedStatement ps = conn.prepareStatement("select * from hr_emp");
		    ResultSet rs = ps.executeQuery();
		    rs.last();
		    int rowCount = rs.getRow();
		    Hr_EmpModel[] hr_emp = new Hr_EmpModel[rowCount];
		    rs.beforeFirst();
		    int count=0;
		    while(rs.next())
		    {
		    	System.out.println("address "+rs.getString("address"));
		    	hr_emp[count] = new Hr_EmpModel(); 
		    	System.out.println(hr_emp[1]);
		    	hr_emp[count].setAddress(rs.getString("address"));
		    	hr_emp[count].setContact(rs.getString("contact"));
		    	hr_emp[count].setDesignation(rs.getString("designation"));
		    	hr_emp[count].setDob(rs.getDate("dob"));
		    	hr_emp[count].setEmail(rs.getString("email"));
		    	hr_emp[count].setId(rs.getInt("id"));
		    	hr_emp[count].setName(rs.getString("name"));
		    	hr_emp[count].setProfilepic(rs.getBinaryStream("profilepic"));
		    	hr_emp[count].setHr(rs.getInt("hr"));
		    	hr_emp[count].setDepartment(rs.getString("dept"));
		    	hr_empList.add(hr_emp[count]);
		    	count++;
		    
		    }
		
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(hr_empList);

		return hr_empList;
	}
	
	public static HashMap<Integer,String> getAllHrs()
	{
		
		
		HashMap<Integer, String> hrList =  new HashMap<Integer,String>();
	
		
		try {
			PreparedStatement ps = conn.prepareStatement("select id,name from hr_emp where dept=?");
			ps.setString(1, "hr");
		    ResultSet rs = ps.executeQuery();
		    int count=1;
		    while(rs.next())
		    {
		    	hrList.put(rs.getInt("id"),rs.getString("name"));
		    	
		    }
		    
		    PreparedStatement ps2 = conn.prepareStatement("select id,name from admin where id=1");
		    ResultSet rs2 = ps2.executeQuery();
		    if(rs2.next())
		    {
		    	
		    	hrList.put(rs2.getInt("id"),rs2.getString("name"));
		    }
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(hrList);
		return hrList;
	
	}
	
	
	public static int getEmpSalNotConf()
	{
	
		int i = 0;
	
		
		try {
			PreparedStatement ps = conn.prepareStatement("select count(salConf) from hr_emp where salConf=?");
			ps.setString(1, "notconfigured");
		    ResultSet rs = ps.executeQuery();
		   
		    while(rs.next())
		    {
		    	
		    	i = rs.getInt(1);
		    	
		    	/*System.out.println("address "+rs.getString("address"));
		    	hr_emp[count] = new Hr_EmpModel(); 
		    	System.out.println(hr_emp[1]);
		    	hr_emp[count].setAddress(rs.getString("address"));
		    	hr_emp[count].setContact(rs.getString("contact"));
		    	hr_emp[count].setDesignation(rs.getString("designation"));
		    	hr_emp[count].setDob(rs.getDate("dob"));
		    	hr_emp[count].setEmail(rs.getString("email"));
		    	hr_emp[count].setId(rs.getInt("id"));
		    	hr_emp[count].setName(rs.getString("name"));
		    	hr_emp[count].setProfilepic(rs.getBinaryStream("profilepic"));
		    	hr_empList.add(hr_emp[count]);
		    	count++;*/
		    }
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return i;
	}
	
	public static List<Hr_EmpModel> getEmpNamesSalNotConf()
	{
		List<Hr_EmpModel> hr_empList = new ArrayList<Hr_EmpModel>();
		
		Hr_EmpModel[] hr_emp = new Hr_EmpModel[20];
		
		try {
			PreparedStatement ps = conn.prepareStatement("select * from hr_emp where salConf=?");
			ps.setString(1, "notconfigured");
		    ResultSet rs = ps.executeQuery();
		    int count=1;
		    while(rs.next())
		    {
		    	System.out.println("address "+rs.getString("address"));
		    	hr_emp[count] = new Hr_EmpModel(); 
		    	System.out.println(hr_emp[1]);
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
		System.out.println(hr_empList);
		return hr_empList;
	}
	
	public static int updateSalConf(int id) 
	{
		
		int i = 0;
		Connection conn = DbConnection.getConnection();
		try {
			conn.setAutoCommit(false);
			PreparedStatement ps = conn.prepareStatement("update hr_emp set salconf=? where  id=?");
			ps.setString(1, "configured");
			ps.setInt(2, id);
			i = ps.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		};
		return i;
	}
	
	
	
	

}
