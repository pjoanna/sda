<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>
<body>
	<table>
		<tr>
			<td>Welcome ${user.firstname}</td>
		</tr>
		<tr>
		</tr>
		<tr>
		</tr>
		<tr>
			<td><a href="home.jsp">Home</a></td>
		</tr>
	</table>

	<form:form id="logOutForm" modelAttribute="user" action="logOutProcess"
			   method="post">
		<table align="center">
			<tr>
				<td><form:input path="username" name="username" id="username" type="hidden"/>
				</td>
			</tr>
			<tr>
				<td></td>
				<td align="left"><form:button type="submit" id="logOut" name="logOut">Logout</form:button>
				</td>
			</tr>
			<tr></tr>

		</table>
	</form:form>
    <a href="loggedUsersProcess">zalogowani</a>
</body>
</html>