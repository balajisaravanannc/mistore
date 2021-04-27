<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" isELIgnored="false" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Mi Store Showproduct</title>
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
    </style>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $(".usd").hide();
            $(".inr").show();
            $('#prices').on('change', function () {
                var price = this.value;
                if (price == 'usd') {
                    $(".usd").show();
                    $(".inr").hide();
                }
                if (price == 'inr') {
                    $(".usd").hide();
                    $(".inr").show();
                }
            });
        });
    </script>

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
</div>
<hr>

<%--@elvariable id="priceDto" type="com"--%>
<form:form modelAttribute="priceDto">
    <div align="center">
        <label>Price</label>
        <form:select path="price" id="prices">
            <form:option value="inr" label="INR"></form:option>
            <form:option value="usd" label="USD"></form:option>
        </form:select>
    </div>
</form:form>

<div align="center">
    <table border="2" width="70%" cellpadding="2">
        <tr>
            <th>ProductId</th>
            <th>ProductName</th>
            <th class="inr">INR</th>
            <th class="usd">USD</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <c:forEach items="${products}" var="products">
            <tr>
                <td><a href="getDetailsById/${products.productId}">${products.productId}</a></td>

                <td><a href="getDetailsByName/${products.productName}">${products.productName}</a></td>

                <td class="inr">${products.usd}</td>

                <td class="usd">${products.inr}</td>

                <td><a href="editShowProducts?productId=${products.productId}">Edit</a></td>

                <td><a href="deleteShowProducts?productId=${products.productId}">Delete</a></td>

            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
