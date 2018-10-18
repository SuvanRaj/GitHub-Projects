<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.arena.model.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="com.arena.daoImpl.ProductDaoImpl" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>PC Games</title>
	
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

	<style>
		img {
		    border: 1px solid #ddd;
		    border-radius: 4px;
		    padding: 5px;
		    
		}

		img:hover {
		    box-shadow: 0 0 2px 1px rgba(0, 140, 186, 0.5);
		}
		div p{
			font-size:16px;
		}
	</style>
</head>

<body style="background-color:lightgray">

	<%
		List<Product> list = new ProductDaoImpl().getProductsByCategory("PC");
		session.setAttribute("PCProducts", list);
	%>
	
<jsp:include page="UserHeader.jsp"></jsp:include>

<div class="container">
	<c:forEach items="${PCProducts}" var="current">
	<div class="row">
		<div class="col-md-3 col-md-offset-1" >
			<a target="_blank" href="./Images/generated/${current.productName}.jpg"><img src="./Images/generated/${current.productName}.jpg" /></a>
		</div> 
		<div class="col-md-8" >
			<h3><a href="ProductDetails.jsp?name=${current.productName}">${current.productName}</a></h3>
			<p>${current.productDesc}</p>
			<p>Platform - ${current.productCategory}</p>
			<p><i class="fa fa-inr"></i> ${current.productPrice}.00</p>
			<p>In stock: ${current.productQuantity}</p>
		</div>
	</div>
	<br/>
	</c:forEach>
</div>

<jsp:include page="Footer.html"></jsp:include>

</body>

</html>