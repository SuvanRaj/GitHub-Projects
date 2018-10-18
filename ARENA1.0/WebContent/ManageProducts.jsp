<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Manage Products</title>
	
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	
</head>

<body style="background-color:lightgray">

<jsp:include page="AdminHeader.jsp"></jsp:include>

<div class="container" align="center">	
	<h2>Manage Products</h2>
	<form class="form-horizontal" action="manageProducts" method="post">
		<br/>
		<div class="form-group">
			<input type="submit" class="btn btn-default" value="Display Products" name="products"/>
		</div>
		<br/>

		<br/>
		<!-- 
		<div class="form-group">
			<label class="control-label col-sm-5" >Update Product By Name:</label>
			<div class="col-sm-2">
				<input type="text" class="form-control" name="update" placeholder="Enter product name"/>
			</div>
			<div class="col-sm-1">
				<input type="submit" class="btn btn-default" value="Update Product" name="products"/>
			</div>
		</div>
		<br/>
		<div class="form-group">
			<label class="control-label col-sm-5" >Delete Product By Name:</label>
			<div class="col-sm-2">
				<input type="text" class="form-control" name="delete" placeholder="Enter product name"/>
			</div>
			<div class="col-sm-1">
				<input type="submit" class="btn btn-default" value="Delete Product" name="products"/>
			</div>
		</div>
		<br/>
		<div class="form-group">
			<label class="control-label col-sm-5" >Fetch Product by Name:</label>
			<div class="col-sm-2">
				<input type="text" class="form-control" name="get" placeholder="Enter product name"/>
			</div>
			<div class="col-sm-1">
				<input type="submit" class="btn btn-default" value="Get Product" name="products"/>
			</div>
		</div>
		  -->
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

<div>
<%@ include file="Footer.html" %>
</div>

</body>

</html>