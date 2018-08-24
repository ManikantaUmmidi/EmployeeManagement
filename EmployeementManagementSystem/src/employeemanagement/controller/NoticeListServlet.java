package employeemanagement.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import employeemanagement.DBOperations.NoticeDBOperation;
import employeemanagement.model.Notice;

/**
 * Servlet implementation class NoticeListServlet
 */
@WebServlet("/NoticeListServlet")
public class NoticeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     
		List<Notice> noticeList = NoticeDBOperation.getAllNotices();
		
		request.setAttribute("noticeList",noticeList);
		request.getServletContext().getRequestDispatcher("/employeehome.jsp").forward(request, response);
		
	
	
	}

	
}
