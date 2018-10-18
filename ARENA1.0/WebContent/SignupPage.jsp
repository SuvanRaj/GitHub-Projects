<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>SignUp</title>
	
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	
	<style>
		.star{
			color:red;
			font-size:16px;
		}
	</style>
	
</head>
	
<body style="background-color:lightgray">

<div align="center">
	<a href="HomePage.jsp"><img src="Images/Logo.png" style="float:left;width:100px;height:80px;margin-top:-10px;margin-left:10px"></a>
	<h1>ARENA</h1>
	<h4>The Online Game Store</h4>
</div>

<!-- NAV Bar -->
<nav class="navbar navbar-default" style="">
	<div class="container-fluid">
		<ul class="nav navbar-nav">
			<li class="active"><a href="HomePage.jsp">Home</a></li>
		</ul>
		<ul class="nav navbar-nav navbar-right">
			<li><a href="AboutUsPage.html"><span class="fa fa-vcard-o" style="font-size:16px"></span> About Us</a></li>
			<li><a href="ContactUsPage.html"><span class="fa fa-address-book" style="font-size:16px"></span> Contact Us</a></li>
			<!--<li><a href="SignupPage.jsp"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>-->
			<li><a href="LoginPage.jsp"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
		</ul>
	</div>
</nav>

<!-- FORM -->	
<div class="container" align="center">	
	<h2>Registration</h2>
	<br/>
	<form class="form-horizontal" action="signup" method="post">
		<div class="form-group">
			<label class="control-label col-sm-5" for="name"><span class="star">*</span>UserName:</label>
			<div class="col-sm-3">
			  <input type="text" class="form-control" id="name" name="rname" placeholder="Enter name" required/>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-5" for="pwd"><span class="star">*</span>Password:</label>
			<div class="col-sm-3"> 
			  <input type="password" class="form-control" id="pwd" name="rpass" placeholder="Enter password" required/>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-5" for="email"><span class="star">*</span>Email:</label>
			<div class="col-sm-3"> 
			  <input type="email" class="form-control" id="email" name="remail" placeholder="Enter email" required/>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-5" for="gender">Gender :</label>
			<div class="col-sm-1"> 
				Male <input type="radio" name="rgender" value="male" id="gender"  />
			</div>
			<div class="col-sm-1"> 
				Female <input type="radio" name="rgender" value="female" id="gender"  />
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-5" for="dob">Date Of Birth :</label>
			<div class="col-sm-3"> 
			  <input type="date" class="form-control" id="dob" name="rdob"/>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-5" for="contact">Contact No.:</label>
			<div class="col-sm-3"> 
			  <input type="tel" class="form-control" id="contact" name="rcontact" placeholder="Enter contact no."/>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-5" for="addr">Address :</label>
			<div class="col-sm-3"> 
			  <textarea rows="4" cols="25" class="form-control" id="addr" name="raddr" placeholder="Enter Your Address here..."></textarea>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-5"></label>
			<div class="col-sm-7"> 
				<span style="color:red;">*</span> denotes required fields.
			</div>
		</div>
		<!--
		<div class="form-group"> 
			<div class="col-sm-offset-2 col-sm-10">
			  <div class="checkbox">
				<label><input type="checkbox"> Remember me</label>
			  </div>
			</div>
		</div>
		-->
		<div class="form-group"> 
			<div class="col-sm-offset-2 col-sm-9">
				<button type="submit" class="btn btn-default">Register</button>
				<button type="reset" class="btn btn-default">Reset</button>
			</div>
		</div>
		<span style="color:red">
		<%
			String msg = null;
			msg = request.getParameter("msg");
			if(msg!=null)
				out.println(msg);
		%>
		</span>	
	</form>
</div>


<!-- FOOTER -->	
<%@ include file="Footer.html" %>


</body>
</html>