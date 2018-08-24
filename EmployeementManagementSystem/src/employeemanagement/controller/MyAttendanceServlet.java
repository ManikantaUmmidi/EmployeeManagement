package employeemanagement.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import employeemanagement.GetUserFromSession;
import employeemanagement.DBOperations.AttendanceDbOperation;
import employeemanagement.model.Attendance;

/**
 * Servlet implementation class MyAttendanceServlet
 */
@WebServlet("/MyAttendanceServlet")
public class MyAttendanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MyAttendanceServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String pagename = request.getParameter("pagename");
		String month=request.getParameter("month");
		int empId=GetUserFromSession.getIdFromSession(request);
		
		List<Attendance> attList = AttendanceDbOperation.getAttandenceList(empId, month);
		
		
		if(attList.size()>0)
		{
			request.setAttribute("attList",attList);
			request.getServletContext().getRequestDispatcher(pagename).forward(request, response);
		}
		else
		{
			request.setAttribute("msg","data is not available for given information...!");
			request.getServletContext().getRequestDispatcher(pagename).forward(request, response);
		}

	}


}
