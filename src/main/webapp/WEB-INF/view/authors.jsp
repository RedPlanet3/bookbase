<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <th>Operations</th>
    </tr>

<c:forEach var="dsf" items="${allAutors}">
    <c:url var="updateButton" value="/updateAuthor">

    </c:url>
    <tr>
        <td>${dsf.authorId}</td>
        <td>${dsf.authorFullName}</td>
        <td>
            <input type="button" value="Update"
                   onclick="window.location.href='/authoradd'"/>
            <input type="button" value="Delete"
                   onclick="window.location.href='/authoradd'"/>
        </td>
    </tr>
</c:forEach>
</table>
<br>
<input type="button" value="Add"
onclick="window.location.href='/authoradd'"/>
<br><br>
<a href="/">Back to start page</a>

</body>
</html>
