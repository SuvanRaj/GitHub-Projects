<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>

<!-- Page Title -->
<div align="center">
	<a href="HomePage.jsp"><img src="Images/Logo.png" style="float:left;width:100px;height:80px;margin-top:-10px;margin-left:10px"></a>
	<h1>ARENA</h1>
	<h4>The Online Game Store</h4>
	<div align="right">
		<%
			//Welcome message if signed in
			if(session.getAttribute("CustomerName") != null)	// && session != null
				{
					out.print("<span style='font-size:16px; color:red'>Hi, " + session.getAttribute("CustomerName") + "</span>");
				}
		%>
	</div>
</div>

<!-- Nav Bar -->
<nav class="navbar navbar-default">
	<div class="container-fluid">
		<ul class="nav navbar-nav">
			<li class="active"><a href="HomePage.jsp">Home</a></li>
			<li><a href='PCGamesPage.jsp'>PC</a></li>
			<li><a href='XBoxOneGamesPage.jsp'>Xbox One</a></li>
			<li><a href='PS4GamesPage.jsp'>PS4</a></li>
			<li><a href='AllProductsPage.jsp'>All Products</a></li>
		</ul>

		<ul class="nav navbar-nav navbar-right">
			<li><a href="AboutUsPage.html"><span class="fa fa-vcard-o" style="font-size:16px"></span> About Us</a></li>
			<li><a href="ContactUsPage.html"><span class="fa fa-address-book" style="font-size:16px"></span> Contact Us</a></li>
			<!-- <li><a href="LoginPage.html"><span class="glyphicon glyphicon-shopping-cart"></span> My Cart(0)</a></li> -->
			<% 	
				//Display Login/Signup if signed in else Logout
				if(session.getAttribute("CustomerName") != null)
				{
					out.print("<li><a href='#'><span class='glyphicon glyphicon-shopping-cart'></span> My Cart(0)</a></li>" + 
								"<li><a href='logout'>Logout <span class='glyphicon glyphicon-log-out'></span></a></li>");
				}
				else 
				{
					out.print("<li><a href='SignupPage.jsp'><span class='glyphicon glyphicon-user'></span> Sign Up</a></li>");
					out.print("<li><a href='LoginPage.jsp'><span class='glyphicon glyphicon-log-in'></span> Login</a></li>");
				}
			%>
		</ul>
	</div>
</nav>

</body>
</html>