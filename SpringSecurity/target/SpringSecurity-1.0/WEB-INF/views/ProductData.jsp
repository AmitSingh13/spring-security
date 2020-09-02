<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>welcome to product data</h3>
<table>
<tr>
<th>ID</th>
<th>NAME</th>
<th>COST</th>
<th>Operation</th>
</tr>
<c:forEach items="${list}" var=ob>
<tr>
<td><c:out value="${ob.prodId}"></c:out></td>
<td><c:out value="${ob.prodName}"></c:out></td>
<td><c:out value="${ob.prodCost}"></c:out></td>
<td><a href="delete?id=${ob.prodId}">Delete</a></td>
</tr>
</c:forEach>
</table>
${message}
</body>
</html>