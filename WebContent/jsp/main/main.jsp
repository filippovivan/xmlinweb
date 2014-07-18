<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Parced text</title>
</head>
<body>
	${train.locomotive}
	<br>
	<c:forEach items="${train.cars}" var="car">${car} <br>
	</c:forEach>
	<br />
	<form name="returnForm" method="post" action="controller">
		<input type="submit" value="Choose another parser" /> <input
			type="hidden" name="command" value="return" />
	</form>
</body>
</html>