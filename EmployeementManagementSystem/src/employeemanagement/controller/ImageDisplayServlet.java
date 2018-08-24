package employeemanagement.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

import employeemanagement.Hr_EmployeeDBOperations;
import employeemanagement.model.Hr_EmpModel;


@WebServlet("/ImageDisplayServlet")
public class ImageDisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		System.out.println("inside image displayer");
		response.setContentType("image/jpeg");
	    int id = Integer.parseInt(request.getParameter("id"));
		Hr_EmpModel model = Hr_EmployeeDBOperations.getHr_Emp(id);
		
		InputStream image = model.getProfilepic();
		
		byte[] bytes = new byte[image.available()];
		/*byte[] bytes = IOUtils.toByteArray(image);*/
		 image.read(bytes);
		 
		response.getOutputStream().write(bytes);
		response.getOutputStream().flush();
		response.getOutputStream().close();		
		
	}

	

}
