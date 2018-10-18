<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Display Categories</title>
	
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
	<form action="manageCategories" method="post">
		<table class="table table-hover" border="2" style="width:80%">
			<h3 align="center">Category List</h3>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Description</th>
				<th>Action</th>
			</tr>
			<c:forEach items="${CategoryList}" var="current">
				<tr>
					<td>${current.categoryId}</td>
					<td>${current.categoryName}</td>
					<td>${current.categoryDesc}</td>
					<td><a href="manageCategories?updateCategory=${current.categoryName}"><input type="button" value="Update" name="categories"/></a>
						&nbsp;
						<a href="manageCategories?deleteCategory=${current.categoryName}"><input type="button" value="Delete" name="categories"/></a>
					</td>
				</tr>
			</c:forEach>
		</table>
		<div class="form-group">
				<input type="submit" class="btn btn-default" onclick="document.forms[0].action = 'AddCategory.jsp'" value="Add Category" name="categories"/>
		</div>
	</form>
</div>

<div>
<%@ include file="Footer.html" %>
</div>

</body>

</html>