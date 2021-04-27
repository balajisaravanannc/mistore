<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<title>Mi Store addProducts</title>
<style type="text/css">
.header {
	padding: 7px;
	text-align: center;
	background: #1abc9c;
	color: white;
	font-size: 30px;
}

.tableborder {
	overflow: hidden;
	background-color: #333;
	background: #F7DC6F;
}

.topnav {
	overflow: hidden;
	background-color: #333;
	background: #CCCCFF;
}

.tableborder a {
	float: left;
	color: #f2f2f2;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
	font-size: 17px;
}

.tableborder a:hover {
	background-color: #ddd;
	color: red;
}

.topnav a.active {
	background-color: #4CAF50;
	color: white;
}

.error {
	color: red;
	position: fixed;
	text-align: left;
	margin-left: 30px;
}

</style>
</head>
<body>
	<h2 align="center" class="header">Welcome to Mi Store</h2>
	<hr>
	<div class="topnav" align="center">
		<table class="tableborder" border="2" width="70%" cellpadding="2">
			<tr>
				<th><a href="http://localhost:8081/MiStore_war_exploded/">Home</a></th>
				<th><a href="showProducts">ShowProducts</a></th>
				<th><a href="addProducts">Addproducts</a></th>
				<th><a href="aboutUs">AboutUs</a></th>
			</tr>
		</table>

		<h4 align="center">Add Your Products</h4>
		<%--@elvariable id="productDto" type="com"--%>
		<form:form action="addProductsSave" method="POST" modelAttribute="productDto">

			<div align="center">

				<label for="pi">ProductId :</label>
				<form:input path="productId" id="pi" />
				<form:errors path="productId" cssClass="error"/>

				<br> <label for="pn">ProductName :</label>
				<form:input path="productName" id="pn" />
				<form:errors path="productName" cssClass="error"/>

				<br> <label for="inr">Inr :</label>
				<form:input path="inr" id="inr" />
				<form:errors path="inr" cssClass="error"/>

				<br> <label for="ds">Description :</label>
				<form:input path="description" id="ds"/>
				<form:errors path="description" cssClass="error"/>

				<br> <label for="cm">Comapany :</label>
				<form:input path="company" id="cm" />
				<form:errors path="company" cssClass="error"/>

				<br> <label for="spc">Specification :</label>
				<form:input path="specification" id="spc" />
				<form:errors path="specification" cssClass="error"/>

				<br> <input type="submit" value="AddProduts" /> <br> <a
					href="getAllShowProducts">Show All</a>
			</div>

		</form:form>
		<div align="center">
			<p>
				<b>Aura Balance Design</b><br> The Redmi Note Series takes the
				premium road with the new and improved Aura Balance<br> Design.
				The Quad Camera setup with the Symmetrical design and Triple Corning<br>
				Gorilla Glass 5 gives the smartphone a smooth finish and lends it a
				refined look.<br> The cinematic Dot Display includes the
				in-display selfie camera to offer a truly <br> immersive
				viewing experience. The design is further splash-proof nano coated,
				<br> protected by P2i to prevent any kind of water damage. The
				smartphone is available<br> in 3 lustrous colors - Interstellar
				Black, Aurora Blue and Glacier White.
			</p>
		</div>
	</div>
</body>
</html>
