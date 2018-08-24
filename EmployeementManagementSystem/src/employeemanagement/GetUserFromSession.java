package employeemanagement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class GetUserFromSession {
	
	public static int getIdFromSession(HttpServletRequest request)
	{
		HttpSession sess = request.getSession();
		int id = (Integer)sess.getAttribute("userId");
	    return id;
	}
	public static String getUsernameFromSession(HttpServletRequest request)
	{
		HttpSession sess = request.getSession();
		String name = (String)sess.getAttribute("name");
	    return name;
	}
	
	public static int getHrNameFromSession(HttpServletRequest request)
	{
		HttpSession sess = request.getSession();
		int id = (int)sess.getAttribute("hr");
	    return id;
	}
		
	}


