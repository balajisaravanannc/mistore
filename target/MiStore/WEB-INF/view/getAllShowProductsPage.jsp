<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Mi Store ShowAllproduct</title>
</head>
<body>
	<h2 align="center">Welcome to Mi Store</h2>
	<hr>
	<div align="right">
		<a href="http://localhost:8081/MiStore_war_exploded/">Home</a>
	</div>
	<div align="center">
		<table border="2" width="70%" cellpadding="2">
			<tr>
				<th>ProductId</th>
				<th>ProductName</th>
				<th>USD</th>
				<th>INR</th>
				<th>Description</th>
				<th>Company</th>
				<th>Specification</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
			<c:forEach items="${products}" var="products">
				<tr>
					<td>${products.productId}</td>

					<td>${products.productName}</td>

					<td>${products.usd}</td>

					<td>${products.inr}</td>

					<td>${products.description}</td>

					<td>${products.company}</td>

					<td>${products.specification}</td>

					<td><a href="editGetAllShowProducts/${products.productId}">Edit</a></td>

					<td><a href="deleteInGetAllShowProducts/${products.productId}">Delete</a></td>

				</tr>
			</c:forEach>
		</table>
		<br>
	</div>
	<div align="center">
		<a href="addProducts">AddProducts</a>
	</div>
</body>
</html>
