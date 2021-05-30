<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<body>

	<h1>
		Welcome <font color="red">${username} </font> to Add Product Details
	</h1>
	<a href="/logout">Logout</a>&nbsp; &nbsp; &nbsp;
	<a href="/">Home</a>
	<br>
	<br>
	<form:form action="/saveProduct" modelAttribute="command">
	
		Product ID: <form:input path="productId" />
		<font color="red">${alreadyExistProduct}</font>
		<font color="red"><form:errors path="productId" /></font><br>
		
				
		Product Name : <form:input path="productName" />
		<font color="red"><form:errors path="productName" /></font><br>
		
		Quantity On Hand : <form:input path="quantityOnHand" />
		<font color="red"><form:errors path="quantityOnHand" /></font><br>
		
				Price : <form:input path="price" />
		<font color="red"><form:errors path="price" /></font>
		<br>
		<br>
		<input type="submit" value="Add Product" />




	</form:form>
	<br>




	<br>



</body>
</html>