<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
   
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>employee registration</title>
 
  <link href="css/styles.css" rel="stylesheet" type="text/css">
   



<script>



</script>
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
<div class="content" style="height: 700px" id="what">

<div class="container" style=" ">
  <h3 style="text-align: center;font-size: 20px;">Employee Registration</h3>
<div class="container" style="margin-top: -80px;">
  <div class="form-container flip">
    <form class="login-form" id="loginForm" action="RegistrationServlet" method="post" enctype="multipart/form-data">
      <h3 class="title">Hello.</h3>
      <div class="form-group">
        <input class="form-input"  placeholder="enter name" name="name" required></input>
      </div>
      <div class="form-group">
        <input type="text" class="form-input" id="email" name="email" placeholder="enter email" required/>
        <span id="emailerror" style="color:red;font-size: 15px;font-weight: bolder;"></span>
      </div>
      <div class="form-group">
        <input type="date" class="form-input" name="dob" placeholder="enter date of birth" required>
      </div>
       <div class="form-group">
        <input class="form-input"  id="designation" name="designation" placeholder="enter designation" required></input>
      </div>
      <div class="form-group">
        <input type="text" class="form-input" id="contact" name="contact" placeholder="enter contact number" required></input>
           
      </div>
      
       <div class="form-group">
        <input type="file" class="form-input" id="profilepic" name="profilepic" required></input>
        <br>
      
           
      </div>
      
     
       <div class="form-group">
        <textarea style="height:70px;"  class="form-input" id="address" name="address" placeholder="enter address" required ></textarea>
      </div>
      <div class="form-group">
        <input type="password" class="form-input" name="password" id="password" placeholder="enter password" required></input>
        <input type="hidden" name="empType" value="employee">
        <span id="passworderror" style="color:red;font-size: 15px;font-weight: bolder;"></span>
      </div>
       <div class="form-group">
        <input type="password" class="form-input" id="confpassword" placeholder="enter confirm password" required></input>
         <span id="confpassworderror" style="color:red;font-size: 15px;font-weight: bolder;"></span>
      </div>
      <div class="form-group">
        <button class="login-button">Sign Up</button>
      </div>
    </form>
   
  </div>
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

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
   <script type="text/javascript" src="js/image-loader.js"></script>
<script type="text/javascript">
  $(document).ready(function(){
	  
 	  /*loading image  */
 	  
 	   $('.img-picker').imagePicker({name: 'images'});
	  
	  $(".login-button").click(function(){
	
	  $('#password, #confpassword').on('keyup', function () {
		  if ($('#password').val() == $('#confpassword').val()) {
		    $('#confpassworderror').html('Matching').css('color', 'green');
		   
		  } else 
		    $('#confpassworderror').html('Not Matching').css('color', 'red');
		       
		});
	  });
	  
	/*  
		  
		
		  var pass = $("#password").val();
		  var conpass = $("#confpassword").val();
		  
		  if(pass != conpass)
			  {
			  $("#confpassworderror").text("password & conf password should be same")
			  return false;
			  }
		  
		  
		  
	  }); */
	  
/* 	  $("#confpassword").keyup(function(){
		 
		  var pass = $("#password").val();
		  var conpass = $("#confpassword").val();
		 
		  if(pass != conpass)
			  {
			  $("#passworderror").text("pass and conf pass are not same");
			  
			  }
		  
		  
	  }); */
	 
	  $('#email').keyup(function(event) {
	    	var email = $("#email").val();
	    	
	      $.get('EmailValidationFromServer', {
	                email : email
	        }, function(responseText) {
	        	console.log("responsedata "+responseText);
	        	
	              $("#emailerror").text(email + " "+responseText);
	              
	        	
	        });
	  });
	  
	  
    	 // Handler for .ready() called.
        $('html, body').animate({
            scrollTop: $('#what').offset().top
        }, 'slow');
    
    });
    
    </script>

</body></html>