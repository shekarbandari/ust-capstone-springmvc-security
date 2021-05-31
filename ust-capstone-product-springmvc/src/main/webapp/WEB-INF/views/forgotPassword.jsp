<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form action="/forgotPassword" method="post" modelAttribute="command">
		<table>
			<tr>
				<td><label for="emailId">Email :</label></td>
				<td><form:input path="emailId" /></td>
			</tr>
			<tr>
			<td><label for="username">User Name :</label></td>
				<td><form:input path="username" /></td>
			</tr>
			<tr>
				
				<td><input type="submit" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>