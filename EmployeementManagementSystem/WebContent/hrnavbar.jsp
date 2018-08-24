<%@page import="employeemanagement.GetUserFromSession"%>
<%@page import="employeemanagement.DBOperations.MessDBOperations"%>
<%@page import="java.util.*"%>
<%@page import="employeemanagement.model.*"%>
<ul>
  <li style="background: transparent none repeat scroll 0% 50%; -moz-background-clip: initial; -moz-background-origin: initial; -moz-background-inline-policy: initial; padding-left: 0px;"><a href="hrhome.jsp"><span>Home</span></a></li>
  <li><a href="HrViewAllEmployeesServlet"><span>View Emp</span></a></li>
 <%  int id1=(Integer)GetUserFromSession.getIdFromSession(request); 
  if(id1!=0)
  {
  %>
  <li><a href="ViewHr_EmpServlet?id=<%=id1%>&pagename=hrprofile.jsp"><span>View Profile</span></a></li>
  <%} %>
  
  <li><a href="sendmessagehr.jsp"><span>Send Message</span></a></li>
  <li><a href="ViewAllLeaveLettersServlet?pagename=/viewleaveletters_hr.jsp"><span>view Leave-Letters</span></a></li>
  <li><a href="hrleaveapply.jsp"><span>apply leave</span></a></li>
  
  
</ul>