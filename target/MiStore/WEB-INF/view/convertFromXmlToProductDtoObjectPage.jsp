<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>convertFromXmlToProductDtoObjectPage</title>
</head>
<body>
<h1>convertFromXmlToProductDtoObjectPage</h1>
<hr>
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

            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
