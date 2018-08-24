package employeemanagement.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import employeemanagement.DBOperations.NoticeDBOperation;
import employeemanagement.model.Notice;

@WebServlet("/NoticeServlet")
public class NoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String description = request.getParameter("description");
		
		Notice notice = new Notice();
		notice.setDescription(description);
		int not = NoticeDBOperation.saveNotice(notice);
		
		request.setAttribute("msg","notice has been sent");
		request.getServletContext().getRequestDispatcher("/sendnotice.jsp").forward(request, response);
		
		
	}

}
