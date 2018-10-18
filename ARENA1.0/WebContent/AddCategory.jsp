<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Add Category</title>

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

<!-- Add Category Form-->
<div class="container" align="center">	
	<h2>Add Category</h2>
	<form class="form-horizontal" action="manageCategories" method="post">
		<div class="form-group">
			<label class="control-label col-sm-5" for="name"><span class="star">*</span>Name:</label>
			<div class="col-sm-3">
			  <input type="text" class="form-control" id="name" name="cname" placeholder="Enter name" required/>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-5" for="desc"><span class="star">*</span>Description:</label>
			<div class="col-sm-3"> 
			  <textarea rows="4" cols="25" class="form-control" id="desc" name="cdesc" placeholder="Enter description"/></textarea>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-5"></label>
			<div class="col-sm-7"> 
				<span class="star">*</span> denotes required fields.
			</div>
		</div>
		<div class="form-group"> 
			<div class="col-sm-offset-2 col-sm-8">
				<input type="submit" class="btn btn-default" value="Add" name="categories"/>
				<input type="reset" class="btn btn-default" value="Reset"/>
			</div>
		</div>
	</form>
</div>

<div>
<%@ include file="Footer.html" %>
</div>

</body>

</html>