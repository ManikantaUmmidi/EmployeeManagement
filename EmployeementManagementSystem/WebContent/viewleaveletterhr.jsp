<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Leave Letter</title>
<meta name="description" content="Description of your site goes here">
<meta name="keywords" content="keyword1, keyword2, keyword3">
<link href="css/styles.css" rel="stylesheet" type="text/css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<style>
  

/* Full-width input fields */
input[type=text], input[type=password],input[type=date],select ,textarea{
    width: 100%;
    padding: 15px;
    margin: 5px 0 22px 0;
    display: inline-block;
   /*  border: none; */
    background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus {
    background-color: #ddd;
   /*  outline: none; */
}
td{
      
}
h2,h3{
  display: block;
  font-size: 2.1em;
  line-height: 1.45em;
  font-family: 'Laila', serif;
  text-align: center;
  font-weight: bold;
  color: #555;
  text-shadow: 1px 1px 0 #fff;
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
						<%@include file="hrnavbar.jsp"%>
					</div>
				</div>
				<div class="content" style="height: 400px; text-align: center;">
				
	           			
				<center>
				<h2>View Application Letter</h2>
				
					<div class="container">

						<table>
								<tr>
								<td><input  style="width:140%" type="date" value="${leave.getFromDate()}" placeholder="From Date"
									name="fromDate" required></td>
								<td><input type="date" name="toDate" value="${leave.getToDate()}" placeholder="To Date"></td>
								<td><select name="typeofLeave">
								   <option value="casualleave">${leave.getTypeofLeave()}</option>
								</select></td>
							</tr>
							<tr>
							<td><textarea rows="5" name="reason" style="width:255%" placeholder="Enter Reason for Leave" cols="">${leave.getReason()}</textarea></td>
							</tr>
						</table>
						<a href="ViewAllLeaveLettersServlet?pagename=/viewleaveletters_hr.jsp" class="btn2">Go Back</a> &nbsp;&nbsp;<a href="ApproveLeave?empId=${leave.getEmpId()}&pagename=/hrhome.jsp" class="btn2">Approve</a>&nbsp;&nbsp;<a href="RejectLeaveServlet?empId=${leave.getEmpId()}&pagename=/hrhome.jsp" class="btn2">Reject</a>
					</div>
                  </center>
				</div>
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
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript">
// Handler for .ready() called.
$('html, body').animate({
    scrollTop: $('#what').offset().top
}, 'slow');

</script>
</body>
</html>