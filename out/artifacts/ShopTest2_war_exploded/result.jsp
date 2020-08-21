<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Query Result</title>
    <meta http-equiv="content-type" content="text/html; chardet=UTF-8">
</head>
<body>
<a href="${pageContext.request.contextPath}">Home page</a>
<h3>Query: <c:out value="$requestScope.query"/></h3>

<c:choose>
    <c:when test="${not empty requestScope.products}">
        <table border="1">
            <thead>
            <tr>
                <td>ID</td>
                <td>Name</td>
                <td>Price</td>
                <td>Category</td>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="product" items="${requestScope.products}">
                <tr>
                    <td>${product.id}</td>
                    <td>${product.name}</td>
                    <td>${product.price}</td>
                    <td>${product.category}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:when>
    <c:otherwise>
        <strong>Brak produktów spełniających kryteria</strong>
    </c:otherwise>
</c:choose>
</body>
</html>
