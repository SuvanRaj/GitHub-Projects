<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.arena.model.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="com.arena.daoImpl.ProductDaoImpl" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
	
	<link href="https://fonts.googleapis.com/css?family=Josefin+Sans:300,400,700&subset=latin-ext" rel="stylesheet">
	 
	 <style>
		h5{
			color: green;
		}
		img:hover{
			opacity:0.8;
		}
		
	</style>

</head>

<body>
<% List<Product> list = new ProductDaoImpl().getProductsByCategory("PC");
	session.setAttribute("PCProducts", list); 
	%>
	
<div class="container-fluid" style="background-color:lightgray;height:380px">
	<div class="row">
		<c:forEach items="${PCProducts}" begin="0" end="3" var="current">
	        <div class="col-sm-3" align="center">
	            <figure><a target="_parent" href="ProductDetails.jsp?name=${current.productName}"><img src="Images/generated/${current.productName}.jpg"/></a>
	            <h4 style="text-align:center">${current.productName}</h4>
	            <span class="fa fa-star "></span>
	            <span class="fa fa-star "></span>
	            <span class="fa fa-star "></span>
	            <span class="fa fa-star-o "></span>
	            <span class="fa fa-star-o "></span></figure>
	          	<h5><i class="fa fa-inr"></i>${current.productPrice}.00</h5>
	        </div>
         </c:forEach>  
	</div>
    <br />    
    <button style="font-size:18px;color:green;float:right">view all <i class="fa fa-eye"></i></button>
</div>
</body>
</html>