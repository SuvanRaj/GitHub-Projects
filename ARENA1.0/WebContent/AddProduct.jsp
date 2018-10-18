<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.arena.model.Category" %>
<%@ page import="java.util.List" %>
<%@ page import="com.arena.daoImpl.CategoryDaoImpl" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Add Product</title>

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

<%	List<Category> list = new CategoryDaoImpl().getAllCategories();
	session.setAttribute("CategoryListForAddProduct", list);
%>
<!-- Add Product Form-->	
<div class="container" align="center">	
	<h2>Add Product</h2>
	<form class="form-horizontal" action="manageProducts" method="post" enctype="multipart/form-data">
		<div class="form-group">
			<label class="control-label col-sm-5" for="name"><span class="star">*</span>Name:</label>
			<div class="col-sm-3">
			  <input type="text" class="form-control" id="name" name="pname" placeholder="Enter name" required/>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-5" for="desc"><span class="star">*</span>Description:</label>
			<div class="col-sm-3"> 
			  <textarea rows="4" cols="25" class="form-control" id="desc" name="pdesc" placeholder="Enter description" required/></textarea>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-5" for="price"><span class="star">*</span>Price:</label>
			<div class="col-sm-3"> 
			  <input type="number" min="1" max="9999" class="form-control" id="price" name="pprice" placeholder="Enter price(below 10,000)" required/>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-5" for="qty"><span class="star">*</span>Quantity(in stock):</label>
			<div class="col-sm-3"> 
			  <input type="number" min="1" max="99" class="form-control" id="qty" name="pquantity" placeholder="Enter quantity(below 100)" required/>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-5" for="cat"><span class="star">*</span>Category:</label>
			<div class="col-sm-3">
				<select class="form-control" name="pcategory">
					<c:forEach items="${CategoryListForAddProduct}" var="current"> 
					<option value="${current.categoryName}">${current.categoryName}</option>
					</c:forEach>
				</select>
			  <!-- <input type="text" class="form-control" id="cat" name="pcategory" placeholder="Enter category" required/> -->
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-5" for="image"><span class="star">*</span>Upload Image:</label>
			<div class="col-sm-3"> 
			  <input type="file" class="form-control" id="image" name="pimage" required/>
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
				<input type="submit" class="btn btn-default" value="Add" name="products"/>
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