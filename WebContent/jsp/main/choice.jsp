<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Parcer choose</title>
</head>
<body>
	<form name="choseForm" method="post" action="controller">
		<input type="hidden" name="command" value="show" /> <input
			type="radio" name="parcer" value="DOM" /> DOM <br /> <input
			type="radio" name="parcer" value="SAX" /> SAX <br /> <input
			type="radio" name="parcer" value="STAX" /> STAX <br /> <br /> <input
			type="submit" value="Parce" />
	</form>
	${notChosen}
	<br>
	<hr>
</body>
</html>