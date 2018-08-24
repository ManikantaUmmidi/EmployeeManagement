
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>downloading payslip</title>
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
<%@include file="employeemenu.jsp"%>
</div>
</div>
<div class="content" style="height: 400px" id="what">
       <center>
<div style="width:50%;">

<form action="GeneratePDF">
   <table id="customers">
 
  <tr>
    <th>Select Year & Month</th>
    <td><input name="year" type="number" required></td>
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
    </select> </td>
   
  </tr>
  
  
</table>
      <br><br>
      <button>Get Slip</button>
      </form>
</div>
<br><br><br><br>
<h3>${msg}</h3>
</center>
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
<script type="text/javascript">
// Handler for .ready() called.
$('html, body').animate({
    scrollTop: $('#what').offset().top
}, 'slow');

</script>

</body></html>