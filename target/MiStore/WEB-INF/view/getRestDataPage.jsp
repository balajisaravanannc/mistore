<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>RestData</title>
</head>
<body>
<h1>RestData</h1>
<hr>
<a href="download">Download</a>
<br>
<table border="2" width="70%" cellpadding="2">

    <tr>
        <th>page</th>
        <th>per_page</th>
        <th>total</th>
        <th>total_pages</th>
    </tr>

    <td> ${reqresDto.page}</td>
    <td> ${reqresDto.per_page}</td>
    <td> ${reqresDto.total}</td>
    <td> ${reqresDto.total_pages}</td>

    <c:forEach items="${reqresDto.data}" var="reqresDtoData">
        ${reqresDtoData.id}
        ${reqresDtoData.email}
        ${reqresDtoData.first_name}
        ${reqresDtoData.last_name}
        <img src = ${reqresDtoData.avatar}>
        <br>
    </c:forEach>
</table>
<c:out value="${xml}"/>

<tr>
    <th>page</th>
    <th>per_page</th>
    <th>total</th>
    <th>total_pages</th>
</tr>

<td> ${object.page}</td>
<td> ${object.per_page}</td>
<td> ${object.total}</td>
<td> ${object.total_pages}</td>

<c:forEach items="${object.data}" var="object">
    ${object.id}
    ${object.email}
    ${object.first_name}
    ${object.last_name}
    <img src = ${object.avatar}>
    <br>
</c:forEach>
</body>
</html>
