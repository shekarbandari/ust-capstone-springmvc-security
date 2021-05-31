<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">


<title>registration form</title>
</head>
<body>

	<form:form method="post" action="/register" modelAttribute="user">

		<h3>Registration Form</h3>

		<div class="form-group">
			<span>User Name :</span>
			<form:input path="username" />
			<font color="red"><form:errors path="username" /></font><br> <span>New
				Password :</span>
			<form:password path="password" />
			<font color="red"><form:errors path="password" /></font><br> <span>Confirm
				Password :</span>
			<form:password path="confirmPassword" />
			<font color="red"><form:errors path="confirmPassword" /></font><br>


			<span>ADMIN :</span>
			<form:radiobutton path="role" value="ADMIN" />
			<span>USER :</span>
			<form:radiobutton path="role" value="USER" />
			<font color="red"><form:errors path="role" /></font><br> <br>
			<br>
			<button class="btn btn-primary" type="submit">Register</button>

		</div>

	</form:form>
	<font color="red">${errorMsg}</font>
	<font color="red">${failedRegistrationMessage}</font>

	<font color="green">${logoutMsg}</font>


</body>
</html>