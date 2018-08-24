<%@page import="employeemanagement.Hr_EmployeeDBOperations"%> 
<ul>
  <li style="background: transparent none repeat scroll 0% 50%; -moz-background-clip: initial; -moz-background-origin: initial; -moz-background-inline-policy: initial; padding-left: 0px;"><a href="adminhome.jsp"><span>Home</span></a></li>
  <li><a href="ViewAllEmps_HrsServlet"><span>View Emp</span></a></li>
  <li><a href="confleaves.jsp"><span>Conf Leaves</span></a></li>
   <li><a href="confSal.jsp"><span>Conf Sal
   <% int list1 = Hr_EmployeeDBOperations.getEmpSalNotConf();
        if(list1 != 0)
        {
 %>
  &nbsp; <b style="color:red;font-size: 15px;">(<%=list1%>)</b>
  <%} %>
  </span></a></li>
  <li><a href="ViewAllEmps_HrsServlet?pagename=paysal.jsp"><span>Pay Sal</span></a></li>
  <li><a href="assingtask.jsp"><span>Ass Task</span></a></li>
  <li><a href="sendnotice.jsp"><span>Send Notice</span></a></li>
  
  
  
</ul>