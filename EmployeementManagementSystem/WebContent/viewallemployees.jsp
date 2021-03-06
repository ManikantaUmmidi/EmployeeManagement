<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
   
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>View All Employees</title>
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
 .btn2{

    background-color: #f1f1f1;
    color: black;
    font-size: 16px;
    padding: 16px 30px;
    border: none;
    cursor: pointer;
    border-radius: 5px;
    text-align: center;
}th{
text-align:center;
}
</style>
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
<%@include file="adminnavbar.jsp" %>
</div>
</div>
<div class="content" style="min-height: 400px;height:100%;" id="what">
<center>
  <h3>Employees list</h3><br><br>
 <input type="text" id="myInput" onkeyup="myFunction()" style="width:40%;" placeholder="Search employees by email id's.."><br><br>

  <table id="myTable" style="width:70%;">
  <tr>
   
    <th>Name</th>
    <th>Email</th>
    <th>Designation</th>
    <th>Contact</th>
    <th>Dept</th>
    <th>HR</th>
    <th>view</th>
  </tr>
  <tbody>
  <c:forEach items="${empList}" var="emp">
  <tr>
      <td>${emp.getName()}</td>
    <td>${emp.getEmail()}</td>
    <td>${emp.getDesignation()}</td>
    <td>${emp.getContact()}</td>
    <td>${emp.getDepartment()}</td>
    <td>${emp.getHr()}</td>
    <td><a href="ViewHr_EmpServlet?id=${emp.getId()}&pagename=employeeview_admin.jsp" class="btn">view</a></td>
  </tr>
  </c:forEach>

      </tbody>
</table>
  <br>
  <br>
  <br>
  <br>
 

</center>


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

$(document).ready(function(){
	// Handler for .ready() called.
	$('html, body').animate({
	    scrollTop: $('#what').offset().top
	}, 'slow');

})

function myFunction() {
	  var input, filter, table, tr, td, i;
	  input = document.getElementById("myInput");
	  filter = input.value.toUpperCase();
	  table = document.getElementById("myTable");
	  tr = table.getElementsByTagName("tr");
	  for (i = 0; i < tr.length; i++) {
	    td = tr[i].getElementsByTagName("td")[1];
	    if (td) {
	      if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
	        tr[i].style.display = "";
	      } else {
	        tr[i].style.display = "none";
	      }
	    }       
	  }
	}
</script>
</body></html>