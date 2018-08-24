<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
   
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>View All Messages</title>
  <meta name="description" content="Description of your site goes here">
  <meta name="keywords" content="keyword1, keyword2, keyword3">
  <link href="css/styles.css" rel="stylesheet" type="text/css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  
  <style>
#myTable {
    font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
    border-collapse: collapse;
    width: 100%;
}

#myTable td, #customers th {
    border: 1px solid #ddd;
    padding: 8px;
}

#myTable tr:nth-child(even){background-color: #f2f2f2;}

#myTable tr:hover {background-color: #ddd;}

#myTable th {
    padding-top: 12px;
    padding-bottom: 12px;
    text-align: left;
    background-color: #4CAF50;
    color: white;
}
.btn {
  background-color: #f4511e;
  border: none;
  color: white;
  padding: 6px 6hpx;
  text-align: center;
  font-size: 16px;
  margin: 4px 2px;
  opacity: 0.6;
  transition: 0.3s;
  border-radius:10px;

}

  td span .ui-icon ui-icon-mail-closed{
      
   font-size:20px;
  }
</style>
<link rel="stylesheet" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.9/themes/base/jquery-ui.css" type="text/css" media="all" /> 
<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.5.min.js" type="text/javascript"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.9/jquery-ui.min.js" type="text/javascript"></script>
</head>
<body>
<div class="page-in">
<div class="page">
<div class="main">
<div class="header">
<div class="header-top">
</div>
<div class="header-bottom">
<h2 style="font-family: cursive;position:absolute;left:280px;">Employee Management System  <span></span></h2>
</div>
<div class="topmenu">
<%@include file="employeemenu.jsp" %>
</div>
</div>
<div class="content" style="height: 400px;text-align: center;" id="what">
<center>
 
  


  <table id="myTable" style="width:70%;">
  
  <tbody>
   <%
  int employeeId1 = GetUserFromSession.getIdFromSession(request); 
  System.out.println("employeeId "+employeeId1);
  List<Message> messList1 = MessDBOperations.messageListById(employeeId1);

  if(messList1.size()>0)
  {
	  %>
	  <tr>
    <th>S.no</th>
    <th>Heading</th>
    <th>Description</th>
    <th>	Assigned By</th>
    <th>Sender Date</th>
    <th>view</th>
    <th>delete</th>
  </tr>
  <tr>
	  <%
	  for(Message mess :messList1)
	  {
		  if(mess.getStatus().equals("unread")){
     %>
     <input type="hidden" name="id" value="<%=mess.getId()%>">
      <td ><span class="ui-icon ui-icon-mail-closed" style="font-size: 20px;"></span></td>
    <%}else{ %>    
   <td ><span class="ui-icon ui-icon-mail-open" style="font-size: 20px;"></span></td>
   <%}%>
    <td><%=mess.getHeading()%></td>
    <td><%=mess.getDescription()%></td>
    <td><%=mess.getSenderId() %></td>
    <td><%=mess.getSendDate()%></td>
   
    <td><a href="ViewMessageServlet?id=<%=mess.getId()%>"  class="btn">view</a></td>
    <td><a href="DeleteMessage?id=<%=mess.getId()%>"  class="btn">delete</a></td>
   
  </tr>
    </tbody>
</table>
     <%} }else{%>
     
      </tbody>
</table>
<br>
  <h3>No messages</h3>

</center>
  <%}%>
</tbody>
</table>

</div>


<div class="footer">
<p>&copy; Copyright 2018. All Rights Reserved.
</p>
<ul>
  <li style="border-left: medium none;"><a href="index.html"><span>Home</span></a></li>
  <li><a href="#"><span>About&nbsp;us</span></a></li>
  <li><a href="#"><span>What's&nbsp;new</span></a></li>
  <li><a href="#"><span>Services</span></a></li>
  <li><a href="#"><span>Contact</span></a></li>
  <li><a href="#"><span>Resources</span></a></li>
  <li style="padding-right: 0px;"><a href="#"><span>Links</span></a></li>
</ul>
</div>
</div>
</div>
</div>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
// Handler for .ready() called.
$('html, body').animate({
    scrollTop: $('#what').offset().top
}, 'slow');

</script>
</body></html>