<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="save" method="post" modelAttribute="product">
<table>
<tr>
<td>Product Name</td>
<td><form:input path="prodName"/></td>
</tr>

<tr>
<td>Product Cost</td>
<td><form:input path="prodCost"/></td>
</tr>
</table>

</form:form>
${message}
</body>
</html>