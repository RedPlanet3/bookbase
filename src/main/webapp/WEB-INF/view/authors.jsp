<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>--%>
<%--
  Created by IntelliJ IDEA.
  User: Elena
  Date: 08.11.2023
  Time: 11:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Autors</h2>
<br>
<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
    </tr>

<c:forEach var="dsf" items="${allAutors}">
    <tr>
        <td>${dsf.authorId}</td>
        <td>${dsf.authorFullName}</td>
    </tr>
</c:forEach>
</table>
<a href="/">Back to start page</a>

</body>
</html>
