<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Login</title>
	
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	
	<style>
		#footer{
			position:fixed;
		}
	</style>
	
</head>
	
<body style="background-color:lightgray">

<div align="center">
	<a href="HomePage.jsp"><img src="Images/Logo.png" style="float:left;width:100px;height:80px;margin-top:-10px;margin-left:10px"></a>
	<h1>ARENA</h1>
	<h4>The Online Game Store</h4>
</div>

<!-- Nav Bar -->
<nav class="navbar navbar-default">
	<div class="container-fluid">
		<ul class="nav navbar-nav">
			<li class="active"><a href="HomePage.jsp">Home</a></li>
		</ul>
		<ul class="nav navbar-nav navbar-right">
			<li><a href="AboutUsPage.html"><span class="fa fa-vcard-o" style="font-size:16px"></span> About Us</a></li>
			<li><a href="ContactUsPage.html"><span class="fa fa-address-book" style="font-size:16px"></span> Contact Us</a></li>
			<li><a href="SignupPage.jsp"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
			<!--<li><a href="LoginPage.jsp"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>-->
		</ul>
	</div>
</nav>


	
<div class="container" align="center" style="height:350">	
	<h2>Login Panel</h2>
	<img src="Images/LoginImmage.png" width="100px" height="100px">
	<form class="form-horizontal" action="login" method="post">
		<div class="form-group">
			<label class="control-label col-sm-5" for="email">Email Id:</label>
			<div class="col-sm-3">
			  <input type="email" class="form-control" id="email" name="uemail" placeholder="Enter name" required />
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-5" for="pwd">Password:</label>
			<div class="col-sm-3"> 
			  <input type="password" class="form-control" id="pwd" name="upass" placeholder="Enter password" required />
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
			<div class="col-sm-12">
			  <span style="color:red">
			  <%
				String msg = null;
				msg = request.getParameter("msg");
				if(msg!=null)
					out.println(msg);
				%>
				</span>
			</div>
		</div>
		<div class="form-group"> 
			<div class="col-sm-offset-2 col-sm-8">
			  <button type="submit" class="btn btn-default">Login</button>
			  <button type="reset" class="btn btn-default">Reset</button>
			</div>
		</div>
	</form>
</div>


<!-- FOOTER -->	
<div id="footer">
<%@ include file="Footer.html" %>
</div>

</body>

</html>