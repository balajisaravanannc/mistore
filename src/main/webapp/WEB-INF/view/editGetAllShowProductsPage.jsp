<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
		 pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
	<title>Mi Store addProducts</title>
</head>
<body>
<h2 align="center">Welcome to Mi Store</h2>
<hr>
<h4 align="center">Update Your Products</h4>
<%--@elvariable id="products" type="com"--%>
<c:url value="/updateGetAllShowProducts" var="updateGetAllShowProducts"/>
<form:form action="${updateGetAllShowProducts}" method="put" modelAttribute="products">
	<div align="center">

		<label for="pi">ProductId :</label>
		<form:input path="productId" id="pi" />

		<br> <label for="pn">ProductName :</label>
		<form:input path="productName" id="pn" />

		<br> <label for="inr">Inr :</label>
		<form:input path="inr" id="inr" />

		<br> <label for="ds">Description :</label>
		<form:input path="description" id="ds" />

		<br> <label for="cm">Company :</label>
		<form:input path="company" id="cm" />

		<br> <label for="spc">Specification :</label>
		<form:input path="specification" id="spc" />

		<br> <input type="submit" value="Edit" />

	</div>
</form:form>
<div align="center">
	<a href="showProducts">Back</a>
</div>
</body>
</html>