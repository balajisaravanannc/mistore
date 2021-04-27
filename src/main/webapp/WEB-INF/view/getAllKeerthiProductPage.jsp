<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>GetAllKeerthiProductPage</title>
</head>
<body>
<div align="center">
    <h1>KeerthiProduct</h1>
    <hr>
    <table border="2" width="70%" cellpadding="2">
        <tr>
            <th>id</th>
            <th>name</th>
            <th>description</th>
            <th>price</th>
            <th>manufacture_date</th>
            <th>available</th>
            <th>manufacture_company</th>
            <th>cost</th>
            <th>usd</th>
            <th>inr</th>
        </tr>
        <c:forEach items="${KeerthiProductDto}" var="KeerthiProductDto">
            <tr>
                <td><a href="getKeerthiProductByID/productId=${KeerthiProductDto.id}">${KeerthiProductDto.id}</a></td>

                <td>${KeerthiProductDto.name}</td>

                <td>${KeerthiProductDto.description}</td>

                <td>${KeerthiProductDto.price}</td>

                <td>${KeerthiProductDto.manufacture_date}</td>

                <td>${KeerthiProductDto.available}</td>

                <td>${KeerthiProductDto.manufacture_company}</td>

                <td>${KeerthiProductDto.cost}</td>

                <td>${KeerthiProductDto.usd}</td>

                <td>${KeerthiProductDto.inr}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
