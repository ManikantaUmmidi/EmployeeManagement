<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
   
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>leave status</title>
  <meta name="description" content="Description of your site goes here">
  <meta name="keywords" content="keyword1, keyword2, keyword3">
  <link href="css/styles.css" rel="stylesheet" type="text/css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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
#messbox{
color:red;
font-size: 

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
<%@include file="hrnavbar.jsp" %>
</div>
</div>
<div class="content" style="height: 400px;" id="what">
<center>
  <h3>Leave Letters List</h3>

  <table id="myTable" style="width:70%;">
  <tr>
   <th>Mess</th>
    <th>Employee Id</th>
    <th>From Date</th>
    <th>To Date</th>
    <th>Type Of Leave</th>
    <th>status</th>
   
  </tr>
  <tbody>
  <c:forEach items="${letterList}" var="list">
  <tr>

  <c:choose>
    <c:when test="${list.getLetter()=='unread'}">
     
   <td><i class="fa fa-envelope" style="font-size:24px;color:green;"></i></td>
    </c:when>    
    <c:otherwise>
    <td><i class="fa fa-envelope-open" style="font-size:24px;color:yellow;"></i></td> 
    </c:otherwise>
</c:choose>
 
    <td>${list.getEmpId()}</td>
    <td>${list.getFromDate()}</td>
    <td>${list.getToDate()}</td>
    <td>${list.getTypeofLeave()}</td>
    <td id="status">${list.getStatus()}</td>
  </tr>
</c:forEach>
      </tbody>
</table>	


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
	
	
	$("td#status").each(function(){
		
	   if($(this).text()=="approve")
	    {
		   $(td).children().attr('disabled', true);
	    }
	})

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