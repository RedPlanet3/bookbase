<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Elena
  Date: 08.11.2023
  Time: 11:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Books add no sql</h2>

<%--<form:form action="/books" modelAttribute="book">--%>
<%--    Id <form:input path="bookId"/>--%>
<%--    <br><br>--%>
<%--    Name <form:input path="bookName"/>--%>
<%--    <br><br>--%>

<%--    <input type="submit" value="OK">--%>
<%--</form:form>--%>

<form action="/books" method="get">
    <input type="number" name="bookId"
           placeholder="Enter book id">
    <input type="text" name="bookName"
           placeholder="Enter book name">
<%--    <input type="text" name="bookName"--%>
<%--           placeholder="Enter book name">--%>
    <input type="submit">
</form>



<br/>
<a href="/">Back to start page</a>

</body>
</html>
