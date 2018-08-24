package employeemanagement.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import employeemanagement.DBOperations.MessDBOperations;
import employeemanagement.model.Message;


@WebServlet("/ViewMessageServlet")
public class ViewMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int id = Integer.parseInt(request.getParameter("id"));
	
		MessDBOperations.updateMess(id);
		Message mess = MessDBOperations.getMessageById(id);
		
		request.setAttribute("model", mess);
		System.out.println(mess+" in view servlet");
		request.getServletContext().getRequestDispatcher("/viewtask.jsp").forward(request, response);
		
		
	}

}
