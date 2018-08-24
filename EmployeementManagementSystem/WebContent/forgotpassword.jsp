
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>forgot password</title>
  <meta name="description" content="Description of your site goes here">
  <meta name="keywords" content="keyword1, keyword2, keyword3">
  <link href="css/styles.css" rel="stylesheet" type="text/css">
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
<%@include file="menubarlink.jsp" %>
</div>
</div>
<div class="content" style="height: 400px;text-align;center;">
<h3 style="text-align: center;font-size: 20px;">Forgot Password Page</h3>
<br>
<br><br>
<center>
<form action="SendPasswordToEmailServlet">
<h3>Please Enter Your Valid email address</h3><br>
<input type="text" name="email" style="width:30%;padding:6px;"><br><br>
<input type="submit" style="width:10%;padding:3px;">
</form>
  </center>
  <br>
  <br>
  <br>    
<div style="color:red;text-align:center;background-color:white"><h2>${msg}</h2></div>
</div>
 




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

</body></html>