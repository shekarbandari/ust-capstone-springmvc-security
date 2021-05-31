<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">


<title>Change Passwrod</title>
</head>
<body>

	<form:form method="post" action="/chngePassword" modelAttribute="command">

		<h3>Change Password </h3>

		<div >
			<span>New
				Password :  </span>
			<form:password path="password" />
			<font color="red"><form:errors path="password" /></font><br>
			<br> <span>Confirm
				Password :</span>
			<form:password path="confirmPassword" />
			<font color="red"><form:errors path="confirmPassword" /></font><br>


			
			<br>
			<button class="btn btn-primary" type="submit">Change</button>

		</div>

	</form:form>
	


</body>
</html>