
package employeemanagement.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import employeemanagement.GetUserFromSession;
import employeemanagement.DBOperations.HrDBOperation;
import employeemanagement.model.Hr_EmpModel;

/**
 * Servlet implementation class HrViewAllEmployeesServlet
 */
@WebServlet("/HrViewAllEmployeesServlet")
public class HrViewAllEmployeesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HrViewAllEmployeesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int name=GetUserFromSession.getIdFromSession(request);
		
		
		List<Hr_EmpModel> empModels=HrDBOperation.getAllEmps(name);
		if (empModels.size()>0) {
			
			request.setAttribute("empList", empModels);
			request.getServletContext().getRequestDispatcher("/View_allEmps_hr.jsp").forward(request, response);
			
		}
	
	
	
	
	}

}
