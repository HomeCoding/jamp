<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
	<title>Admin panel</title>
	<style>
	.error 
	{
		color: #ff0000;
		font-weight: bold;
	}
	#listOfEmployees tr:first-child{
		font-weight: bold;
	}
	</style>
</head>

<body>
	<h3>Admin links</h3>
	<ul>
		<li><a href="/jamp-app/admin/specialities">List of specialities</a></li>
		<li><a href="/jamp-app/admin/programs">List of programs</a></li>
	</ul>
</body>
</html>