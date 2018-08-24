package employeemanagement.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import employeemanagement.DbConnection;
import employeemanagement.GetUserFromSession;
import employeemanagement.Hr_EmployeeDBOperations;
import employeemanagement.model.Hr_EmpModel;



@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
	    Connection conn = DbConnection.getConnection();
	    try {
			PreparedStatement ps = conn.prepareStatement("select * from admin where username=? and password=?");
			ps.setString(1, username);
			ps.setString(2, password);

		    ResultSet set =	ps.executeQuery();
		   
		    
		  
		    if(set.next())
		    {
		    	
		    	request.getSession().setAttribute("name", set.getString("name"));
		    	request.getSession().setAttribute("userId", set.getInt("id"));
		    	request.getServletContext().getRequestDispatcher("/adminhome.jsp").forward(request, response);
		    }
		    else
		    {
		    	response.sendRedirect("adminlogin.jsp?msg=username or password wrong try again");
		    }
	    
	    
	    
	    
	    
	    } catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
