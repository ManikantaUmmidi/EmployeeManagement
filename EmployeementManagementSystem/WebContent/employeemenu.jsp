<%@page import="employeemanagement.GetUserFromSession"%>
<%@page import="employeemanagement.DBOperations.MessDBOperations"%>
<%@page import="java.util.*"%>
<%@page import="employeemanagement.model.*"%>

<ul>
  <li style="background: transparent none repeat scroll 0% 50%; -moz-background-clip: initial; -moz-background-origin: initial; -moz-background-inline-policy: initial; padding-left: 0px;"><a href="NoticeListServlet"><span>Home</span></a></li>
  
  <%  int id1=(Integer)GetUserFromSession.getIdFromSession(request); 
  if(id1!=0)
  {
  %>
  <li><a href="ViewHr_EmpServlet?id=<%=id1%>&pagename=viewprofile.jsp"><span>View Profile</span></a></li>
  <%} %>
  <li><a href="downpayslip.jsp"><span>Down Pay Slip</span></a></li>
    
  <li><a href="applyleave.jsp"><span>Apply Leave</span></a></li>
  <li><a href="viewtasklist.jsp"><span>View Task
  <%
  int employeeId = GetUserFromSession.getIdFromSession(request); 
  List<Message> messList = MessDBOperations.messageListById_Status(employeeId);

  if(messList.size()>0)
  {
  %>
  <b style="color:red;background-color: white">(<%=messList.size()%>)</b>
  
  <%} %>
  </span></a></li>
  <li><a href="sendMes.jsp"><span>Send Message</span></a></li>

  
  
</ul>