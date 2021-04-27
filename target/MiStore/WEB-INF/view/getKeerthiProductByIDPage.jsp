<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>getKeerthiProductByIDPage</title>
</head>
<body>
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
    <tr>
        <td>${KeerthiProductDto.id}</td>

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
</table>
</body>
</html>--%>

${KeerthiProductDto}
