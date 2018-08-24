
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Title goes here</title>
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
<div class="content" style="height: 600px;">
<h3 style="text-align: center;font-size: 20px;">HR Registration</h3>
<div class="container" style="margin-top: -80px">
  <div class="form-container flip">
    <form class="login-form">
      <h3 class="title">Hello.</h3>
      <div class="form-group" id="username">
        <input class="form-input" tooltip-class="username-tooltip" placeholder="enter name" id="email" required="true"></input>
      </div>
      <div class="form-group" id="password">
        <input type="password" class="form-input" tooltip-class="password-tooltip" placeholder="enter email"></input>
      </div>
       <div class="form-group" id="username">
        <input class="form-input" tooltip-class="username-tooltip" placeholder="enter designation" id="email" required="true"></input>
      </div>
      <div class="form-group" id="password">
        <input type="text" class="form-input" tooltip-class="password-tooltip" placeholder="enter contact number"></input>
       
      </div>
       <div class="form-group" id="username">
        <textarea style="height:70px;"  class="form-input" tooltip-class="username-tooltip" placeholder="enter address" id="email"></textarea>
      </div>
      <div class="form-group" id="password">
        <input type="password" class="form-input" tooltip-class="password-tooltip" placeholder="enter password"></input>
      </div>
       <div class="form-group" id="password">
        <input type="password" class="form-input" tooltip-class="password-tooltip" placeholder="enter confirm password"></input>
      </div>
      <div class="form-group">
        <button onclick="clickListener();"class="login-button">Sign Up</button>
        <input class="remember-checkbox"type="checkbox"></input>
      </div>
    </form>
    <div class="loading">
      <div class="loading-spinner-large" style="display: none;"></div>
      <div class="loading-spinner-small" style="display: none;"></div>
    </div>
  </div>
</div>
  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script src='https://cdnjs.cloudflare.com/ajax/libs/Chart.js/1.0.2/Chart.min.js'></script>
<script src='https://code.jquery.com/jquery-2.1.4.min.js'></script>

  

    <script  src="js/index.js"></script>




</div>
<div class="footer">
<p>&copy; Copyright 2014. All Rights Reserved.
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