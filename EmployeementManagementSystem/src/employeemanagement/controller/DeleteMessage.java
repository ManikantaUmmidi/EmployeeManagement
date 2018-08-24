package employeemanagement.controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import employeemanagement.DbConnection;
import employeemanagement.DBOperations.MessDBOperations;


@WebServlet("/DeleteMessage")
public class DeleteMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
        
		int i = MessDBOperations.delteMessById(id);
		
		if(i>0)
		{
			request.getServletContext().getRequestDispatcher("/viewtasklist.jsp").forward(request, response);
			
		}

	
	}
	

}
