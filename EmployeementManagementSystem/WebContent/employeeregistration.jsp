
<!DOCTYPE html>
<%@page import="employeemanagement.NetworkConnectOrNot"%>
<html>
<head>
  <meta charset="UTF-8">
  <title>Title goes here</title>
  <meta name="description" content="Description of your site goes here">
  <meta name="keywords" content="keyword1, keyword2, keyword3">
  <link href="css/styles.css" rel="stylesheet" type="text/css">
    <link href = "https://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css"
         rel = "stylesheet">
  <link href="css/jquery.datepick.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="js/jquery.plugin.min.js"></script>
<script src="js/jquery.datepick.js"></script> 


<script>
$(function() {
	$('#popupDatepicker').datepick();
	$('#inlineDatepicker').datepick({onSelect: showDate});
});

function showDate(date) {
	alert('The date chosen is ' + date);
}
</script>
<style>
 .ui-widget-header,.ui-state-default, ui-button {
            background:#b9cd6d;
            border: 1px solid #b9cd6d;
            color: #FFFFFF;
            font-weight: bold;
            
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
<%@include file="menubarlink.jsp" %>
</div>
</div>

  <div id = "dialog-4" title = "Dialog Title goes here...">This my first jQuery UI Dialog!</div>
      <button id = "opener-4">Open Dialog</button>
<div class="content" style="height: 650px;" id="what">
<h3 style="text-align: center;font-size: 20px;">Employee Registration</h3>
<div class="container" style="margin-top: -80px">
  <div class="form-container flip">
    <form class="login-form">
      <h3 class="title">Hello.</h3>
      <div class="form-group" id="username">
        <input class="form-input"  placeholder="enter name"  required></input>
      </div>
      <div class="form-group">
        <input type="text" class="form-input" id="email" placeholder="enter email" required/>
        <span id="username-tool"></span>
      </div>
      <div class="form-group" id="password">
        <input type="text" class="form-input" id="popupDatepicker" placeholder="enter date of birth"></input>
      </div>
       <div class="form-group" id="username">
        <input class="form-input"  placeholder="enter designation" required="true"></input>
      </div>
      <div class="form-group" id="password">
        <input type="text" class="form-input" placeholder="enter contact number"></input>
       
      </div>
       <div class="form-group" id="username">
        <textarea style="height:70px;"  class="form-input"  placeholder="enter address" ></textarea>
      </div>
      <div class="form-group" id="password">
        <input type="password" class="form-input"  placeholder="enter password"></input>
      </div>
       <div class="form-group" id="password">
        <input type="password" class="form-input" placeholder="enter confirm password"></input>
      </div>
      <div class="form-group">
        <button class="login-button">Sign Up</button>
      </div>
    </form>
   
  </div>
</div>

<p id="result"></p>
  

   <!--  <script  src="js/index.js"></script> -->

    <!--   <script src = "https://code.jquery.com/jquery-1.10.2.js"></script> -->
    <!--  <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script> -->
    <script type="text/javascript">
    
     
    $(document).ready(function() {
    	
    	
    	 // Handler for .ready() called.
        $('html, body').animate({
            scrollTop: $('#what').offset().top
        }, 'slow');
    	
    	 var email = $("input#email").val();
    	
    	 
    $('#email').keyup(function(event) {
    	alert(email);
        $.get('EmailValidationFromServer', {
                email : email
        }, function(responseText) {
        	console.log(responseText);
                if(responseText=="Valid")
                	{
                	alert("valid");
                	}
                else if(responseText=="NotValid")
                	{
                	alert("not valid");
                	}
                else if(responseText=="NetworkIsNotAvailable")
                	{
                	alert("internet is not connected");
                	}
        	
        });
});
    
    
    $(function() {
        $( "#dialog-4" ).dialog({
           autoOpen: false, 
           modal: true,
           buttons: {
              OK: function() {$(this).dialog("close");}
           },
        });
        $( "#opener-4" ).click(function() {
           $( "#dialog-4" ).dialog( "open" );
        });
     });
    
    });
    
    
    </script>

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