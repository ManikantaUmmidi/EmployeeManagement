<%@page import="employeemanagement.GetUserFromSession"%>
<%@page import="employeemanagement.Hr_EmployeeDBOperations"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>attendance page</title>
<meta name="description" content="Description of your site goes here">
<meta name="keywords" content="keyword1, keyword2, keyword3">
<link href="css/styles.css" rel="stylesheet" type="text/css">
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

#myTable tr:nth-child(even) {
	background-color: #f2f2f2;
}

#myTable tr:hover {
	background-color: #ddd;
}

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
	border-radius: 10px;
}
/*side nav bar  */
.sidenav {
	height: 100%;
	width: 0;
	position: fixed;
	z-index: 1;
	top: 0;
	left: 0;
	background-color: #111;
	overflow-x: hidden;
	transition: 0.5s;
	padding-top: 60px;
}

.sidenav a {
	padding: 8px 8px 8px 32px;
	text-decoration: none;
	font-size: 25px;
	color: #818181;
	display: block;
	transition: 0.3s;
}

.sidenav a:hover {
	color: #f1f1f1;
}

.sidenav .closebtn {
	position: absolute;
	top: 0;
	right: 25px;
	font-size: 36px;
	margin-left: 50px;
}

@media screen and (max-height: 450px) {
	.sidenav {
		padding-top: 15px;
	}
	.sidenav a {
		font-size: 18px;
	}
}
</style>
</head>
<body>
	<div class="page-in">
		<div class="page">
			<div class="main">
				<div class="header">
					<div class="header-top"></div>
					<div class="header-bottom">
						<h2 style="font-family: cursive; position: absolute; left: 280px;">
							Employee Management System <span></span>
						</h2>
					</div>
					<div class="topmenu">
						<%@include file="employeemenu.jsp"%>
					</div>
				</div>
				<div class="content" style="height: 400px; text-align: center;"
					id="what">
					<center>

					<form action="MyAttendanceServlet">
						<table id="customers">

							<tr>
								<th>Select Month</th>

								<td><select name="month">
										<option>Jan</option>
										<option>Feb</option>
										<option>Mar</option>
										<option>Apr</option>
										<option>May</option>
										<option>Jun</option>
										<option>Jul</option>
										<option>Aug</option>
										<option>Sep</option>
										<option>Oct</option>
										<option>Nov</option>
										<option>Dec</option>
								</select></td>

							</tr>


						</table>
						<br>
						<br>
						<input type="hidden" name="pagename" value="/myattendance.jsp">
						<button>Get Attendance List</button>
					</form>
</center>

				</div>

				<div style="color: red; text-align: center; background-color: white">
					<h2>${msg}</h2>
				</div>

				<div class="footer">
					<p>&copy; Copyright 2018. All Rights Reserved.</p>
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
		$(document).ready(function() {

			//Handler for .ready() called.
			$('html, body').animate({
				scrollTop : $('#what').offset().top
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

		function openNav() {
			document.getElementById("mySidenav").style.width = "250px";
		}

		function closeNav() {
			document.getElementById("mySidenav").style.width = "0";
		}
	</script>
</body>
</html>