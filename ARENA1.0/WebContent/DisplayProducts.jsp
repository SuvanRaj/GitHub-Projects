<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ page import="com.arena.model.Product" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Display Products</title>
	
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

	<style>
		th{
			align:center;
		}
	</style>
</head>

<body style="background-color:lightgray">

<jsp:include page="AdminHeader.jsp"></jsp:include>

<div align="center"> 
	<span style="color:red">
		<%
			String msg = null;
			msg = request.getParameter("msg");
			if(msg!=null)
				out.println(msg);
		%>
	</span>	 
	<form action="manageProducts" method="post" enctype="multipart/form-data">
		<table class="table table-hover" border="2" style="width:80%">
			<h3 align="center">Product List</h3>
			<tr>
			   	<th>Id</th>
			   	<th>Name</th>
			   	<th>Description</th>
			   	<th>Price</th>
			   	<th>Quantity</th>
			   	<th>Category</th>
			   	<th>Action</th>
		  	</tr>
		  	<c:set var='ext' value='.jpg'></c:set>
		  	<c:forEach items="${ProductList}" var="current">
		    <tr>
				<td>${current.productId}</td>
				<td>${current.productName}</td>
				<td>${current.productDesc}</td>
				<td>${current.productPrice}</td>
				<td>${current.productQuantity}</td>
				<td>${current.productCategory}</td>
				
				<td><a href="manageProducts?updateProduct=${current.productName}"><input type="button" value="Update" name="products"/></a>
					&nbsp; &nbsp;
					<a href="manageProducts?deleteProduct=${current.productName}"><input type="button" value="Delete" name="products"/></a>
				</td>
		    </tr>
		  	</c:forEach>
		</table>
		<div class="form-group">
			<input type="submit" class="btn btn-default" onclick="document.forms[0].action = 'AddProduct.jsp'" value="Add Product" name="products"/>
		</div>
	</form>
</div>

<div>
<%@ include file="Footer.html" %>
</div>

</body>
  
</html>