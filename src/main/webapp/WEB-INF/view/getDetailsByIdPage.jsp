<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Mi Store product</title>
</head>
<body>
	<h2 align="center">Welcome to Mi Store</h2>
	<hr>
	<div align="center">
		<table border="2" width="70%" cellpadding="2">
			<tr>
				<th>ProductId</th>
				<th>ProductName</th>
				<th>USD</th>
				<th>INR</th>
				<th>Description</th>
				<th>Comapany</th>
				<th>Specification</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>

			<tr>
				<td>${products.productId}</td>

				<td>${products.productName}</td>

				<td>${products.usd}</td>

				<td>${products.inr}</td>

				<td>${products.description}</td>

				<td>${products.company}</td>

				<td>${products.specification}</td>

				<c:url value="/editShowProducts" var="editShowProducts"/>
				<td><a href="${editShowProducts}?productId=${products.productId}">Edit</a></td>

				<c:url value="/deleteShowProducts" var="deleteShowProducts"/>
				<td><a href="${deleteShowProducts}?productId=${products.productId}">Delete</a></td>

			</tr>

		</table>
	</div>
	<div align="center">
		<c:url value="/showProducts" var="showProducts"/>
		<a href="${showProducts}">Back</a>
	</div>
</body>
</html>