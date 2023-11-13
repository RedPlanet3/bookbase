<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: elena
  Date: 13.11.2023
  Time: 14:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New Author</title>
</head>
<body>

<form:form action="saveauthor" modelAttribute="newauthor">
    Name <form:input path="authorFullName"/>

    <input type="submit" value="OK">
</form:form>

</body>
</html>
