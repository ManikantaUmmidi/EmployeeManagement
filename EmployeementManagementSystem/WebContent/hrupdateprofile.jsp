
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<html>
<head>


<title>update profile</title>
<meta name="description" content="Description of your site goes here">
<meta name="keywords" content="keyword1, keyword2, keyword3">
<link href="css/styles.css" rel="stylesheet" type="text/css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<style type="text/css">
#customers {
	font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

#customers td, #customers th {
	border: 1px solid #ddd;
	padding: 8px;
}

#customers tr:nth-child(even) {
	background-color: #f2f2f2;
}

#customers tr:hover {
	background-color: #ddd;
}

#customers th {
	padding-top: 12px;
	padding-bottom: 12px;
	text-align: left;
	/* background-color: #4CAF50;
    color: white;*/
}


input{
   padding:8px;
   width:70%;
}
.btn2 {
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
				<div class="content" style="height: 600px" id="what">
					<center>
						<h2>Profile View</h2>
						<div style="width: 50%;">

							<form action="Hr_EmpUpdateServlet" method="Post" >

								<table id="customers">


									<%-- <tr>
										<th>Profile</th>
										<td><input type="file" value="${model.getProfilepic()}" name="profilepic"></td>
									</tr> --%>
									<tr>
										<th>Name</th>
										<td>${model.getName()}</td>

									</tr>
									<tr>
										<th>email</th>
										<td>${model.getEmail()}</td>
									</tr>

									</tr>
									<tr>
										<th>Designation</th>
										<td>${model.getDesignation()}</td>

									</tr>
									<tr>
										<th>Department</th>
										<td>${model.getDepartment()}</td>

									</tr>
									<tr>
										<th>HR</th>
										<td>${model.getHr()}</td>

									</tr>
									
									
									<tr>
										<th>Contact</th>
										<td><input type="text" name="contact" value="${model.getContact()}"></td>
									</tr>

									</tr>
									<tr>
										<th>Date Of Birth</th>
										<td><input type="text" name="dob" value="${model.getDob()}"></td>

									</tr>
									<tr>
										<th>Address</th>
										<td><input type="text" name="address" value="${model.getAddress()}"></td>
									</tr>

									</tr>


								</table>
								<br>
								<br>
								<input type="hidden" name="id" value="${model.getId()}">
								<input type="hidden" name="pagename" value="/hrhome.jsp">
								<button type="submit" class="btn2" value="Update">Update</button>
							</form>
						</div>
					</center>
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
	<script>
		/*loading page slowly  */
		// Handler for .ready() called.
		$('html, body').animate({
			scrollTop : $('#what').offset().top
		}, 'slow');
	</script>

</body>
</html>