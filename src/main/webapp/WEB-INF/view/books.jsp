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
<h2>Books</h2>
<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Genre</th>
    </tr>

    <c:forEach var="dsf" items="${allBooks}">
        <tr>
            <td>${dsf.bookIdId}</td>
            <td>${dsf.bookName}</td>
            <td>${dsf.genre}</td>
        </tr>
    </c:forEach>
</table>
book: ${book.bookId} , ${book.bookName}

<form:form action="/books" modelAttribute="book">
    Id <form:input path="bookId"/>
    <br><br>
    Name <form:input path="bookName"/>
    <form:errors path="bookName"/>
    <br><br>
<%--    выпадающий список из enum--%>
    Genre <form:select path="genre">
    <form:options items="${book.genre}"/>
    </form:select>


<%--    &lt;%&ndash;    радиобаттон список из enum&ndash;%&gt;--%>
<%--    Genre <form:radiobuttons path="genre"/>--%>



    <br><br>
    <input type="submit" value="OK">
</form:form>



<br/>
<a href="/">Back to start page</a>

</body>
</html>
