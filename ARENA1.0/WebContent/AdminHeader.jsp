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

<div align="center">
	<a href="HomePage.jsp"><img src="Images/Logo.png" style="float:left;width:100px;height:80px;margin-top:-10px;margin-left:10px"></a>
	<h1>ARENA</h1>
	<p>The Online Game Store</p>
	</br>
	<div align="center">
		<span style="color:red; font-size:16px">Administrator Console</span>
	</div>
</div>

<!-- Nav Bar -->
<nav class="navbar navbar-default">
	<div class="container-fluid">
		<ul class="nav navbar-nav">
			<li><a href="ManageProducts.jsp">Manage Products</a></li>
			<li><a href="ManageCategories.jsp">Manage Categories</a></li>
		</ul>
		<ul class="nav navbar-nav navbar-right">
			<li><a style='color:white; background-color:black' href='AdminPage.jsp'>ADMIN</a></li>
			<li><a href="AboutUsPage.html"><span class="fa fa-vcard-o" style="font-size:16px"></span> About Us</a></li>
			<li><a href="ContactUsPage.html"><span class="fa fa-address-book" style="font-size:16px"></span> Contact Us</a></li>
			<li><a href='logout'>Logout <span class='glyphicon glyphicon-log-out'></span></a></li>
			
		</ul>
	</div>
</nav>

</body>
</html>