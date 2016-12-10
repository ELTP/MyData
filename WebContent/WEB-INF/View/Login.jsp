<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>	${msg} <br>
<h3>Admin Log In</h3>
	<sf:form method="POST" modelAttribute="admin">
		Username : <sf:input path="username"/><br>
		Password : <sf:password path="password"/><br>
		<input type="submit" value="Login">
	</sf:form>

</body>
</html>