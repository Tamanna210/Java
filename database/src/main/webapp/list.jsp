<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Product List: ${time}</h1>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>Name</th>
		</tr>
		<c:forEach  items="${products}" var="product">
			<tr>
				<td>${product.id}</td>
				<td>${product.name}</td>
			</tr>
		</c:forEach>	
	</table>
	<a href="index.html">Back</a>
</body>
</html>