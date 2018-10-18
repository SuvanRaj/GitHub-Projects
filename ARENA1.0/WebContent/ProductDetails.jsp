<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.arena.model.Product" %>
<%@ page import="com.arena.daoImpl.ProductDaoImpl" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Product Details</title>
	
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

	<style>
		.customlabel{
			color:green;
		}
		img {
		    border: 1px solid #ddd;
		    border-radius: 4px;
		    padding: 5px;
		}

		img:hover {
		    box-shadow: 0 0 2px 1px rgba(0, 140, 186, 0.5);
		}
		#footer{
			position:fixed;
		}
	</style>
</head>

<body style="background-color:lightgray">

<jsp:include page="UserHeader.jsp"></jsp:include>

<%
	String name = request.getParameter("name");
	Product prod = new ProductDaoImpl().getProductByName(name);
%>
<div class="container">
	<div class="row">
		<div class="col-md-4" >
			<img src="./Images/generated/<%out.print(prod.getProductName());%>.jpg" width="100%" height="100%"/>
		</div>
		<div class="col-md-7 col-md-offset-1" >
			<h2><%out.print(prod.getProductName()); %></h2>
			<br/>
			<h4><span class="customlabel">MRP</span>: <i class="fa fa-inr"></i> <%out.print(prod.getProductPrice()); %>.00 </h4>
			<br/>
			<h4><span class="customlabel">Platform</span> - <%out.print(prod.getProductCategory()); %></h4>
			<br/>
			<h4><span class="customlabel">Details</span> - <%out.print(prod.getProductDesc()); %></h4>
			<br/>
			<h4><span class="customlabel">Availability</span> - <%out.print(prod.getProductQuantity()); %> left in stock</h4>
			</br>
			<h4><a href="#" class="btn btn-info btn-lg"><span class="glyphicon glyphicon-shopping-cart"></span> Add To Cart</a></h4>
		</div>
	</div>
</div>

<div id="footer">
<jsp:include page="Footer.html"></jsp:include>
</div>

</body>

</html>