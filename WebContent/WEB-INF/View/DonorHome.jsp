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

<b>Donor currently registered</b><br>
	<c:forEach var="d" items="${donorList }">		
 		<a href="http://localhost:8080/BloodBank/userdetails/${d.donarName}">${d.donarName}</a> ${d.bloodgroup }<br>
	</c:forEach>
<body>
	<sf:form method="POST" modelAttribute="donor">
	Donar ID:<sf:input path="donerId" /><sf:errors path="donerId"></sf:errors><br>
	Donar Name:<sf:input path="donarName" /><sf:errors path="donarName"></sf:errors><br>
	Donar Age:<sf:input path="age" /><sf:errors path="age"/><br>
	  Contact:<sf:input path="contact" /><br>
	Blood Group:<sf:input path="bloodgroup" /><br>
		<input type="submit" value="Register">
	</sf:form>
</body>
</html>