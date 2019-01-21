<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Profile</title>
<link rel="stylesheet" href="/SpringMVCDemo/static/myCoolStyles.css">
</head>
<body>
	<div class="display">
		<!-- insert values from the Model into DOM -->
		<p>Username: ${username}</p>
		<br>
		<p>Email: ${email}</p>
	</div>

</body>
</html>