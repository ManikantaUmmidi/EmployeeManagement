
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>HR Login</title>
  <meta name="description" content="Description of your site goes here">
  <meta name="keywords" content="keyword1, keyword2, keyword3">
  <link href="css/styles.css" rel="stylesheet" type="text/css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
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
<div class="content" style="height: 400px" id="what">
<h3 style="text-align: center;font-size: 20px;">HR Login</h3>
<div class="container" style="margin-top: -80px">
  <div class="form-container flip">
    <form class="login-form" method="post" action="HRLoginServlet">
      <h3 class="title">Hello.</h3>
      <div class="form-group" id="username">
        <input class="form-input"  placeholder="Username" id="email" name="username"  required="true"></input>
      </div>
      <div class="form-group" id="password">
        <input type="password" class="form-input"  placeholder="Password" name="password"></input>
      </div>
      <div class="form-group">
        <button type="submit" class="login-button">Login</button>
       <div style="font-size: 15px;"><a class="remember-p" href="forgotpassword.jsp">Forgot Password??</a></div>
      </div>
    </form>
   
  </div>

  
</div>
 




</div>
<div style="color:red;text-align:center;background-color:white"><h2>${msg}</h2></div>
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
<script>

$('html, body').animate({
    scrollTop: $('#what').offset().top
}, 'slow');

</script>

</body></html>