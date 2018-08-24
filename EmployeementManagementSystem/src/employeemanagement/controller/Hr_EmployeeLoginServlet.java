package employeemanagement.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import employeemanagement.DbConnection;
import employeemanagement.DBOperations.AttendanceDbOperation;



@WebServlet("/Hr_EmployeeLoginServlet")
public class Hr_EmployeeLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	 String username = request.getParameter("username");
	 String password = request.getParameter("password");
	 String pagename = request.getParameter("pagename");
	 String errorPagename = request.getParameter("errorpagename");
	 Connection conn = DbConnection.getConnection();
	 try {
		PreparedStatement ps = conn.prepareStatement("select * from hr_emp where email=? and password=?");
		ps.setString(1, username);
		ps.setString(2, password);
		
		
		ResultSet set = ps.executeQuery();
	   
		 if(set.next())
		 {
			 
			 int empId = set.getInt("id");
			 
			 boolean status = AttendanceDbOperation.checkAttendance(empId);
			 if(!status)
			 {
			 AttendanceDbOperation.saveattance(set.getInt("id"));
			 }
			 HttpSession sess = request.getSession();
			 System.out.println(set.getString("hr"));
			 sess.setAttribute("userId", set.getInt("id"));
			 sess.setAttribute("hr", set.getInt("hr"));
			 sess.setAttribute("name", set.getString("name"));
			 response.sendRedirect(pagename);
			 
		 }
		 else
		 { 
			 request.setAttribute("msg", "Username or Password wrong try again..");
			 request.getServletContext().getRequestDispatcher("/"+errorPagename).forward(request, response);
			
		 }
	 } catch (SQLException e) {
		e.printStackTrace();
	}
		
	
	
	
	}

}
