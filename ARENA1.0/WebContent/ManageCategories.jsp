<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Manage Categories</title>
	
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

<jsp:include page="AdminHeader.jsp"></jsp:include>

<div class="container" align="center"> 
	<h2>Manage Categories</h2>
	<form class="form-horizontal" action="manageCategories" method="post">
		<br/>
		<div class="form-group">
			<input type="submit" class="btn btn-default" value="Display Categories" name="categories"/>
		</div>
		<br/>
		<span style="color:red">
		<%
			String msg = null;
			msg = request.getParameter("msg");
			if(msg!=null)
				out.println(msg);
		%>
		</span>		
	</form>
	<br/>
</div>

<div>
<%@ include file="Footer.html" %>
</div>

</body>

</html>