<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
	<title>Mentorship programs</title>
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
	
	<h2><spring:message code="program.page.list"/></h2>
	<br/>
	
	<table id="listOfEmployees" border="1">
	<tr>
	    <td>#</td>
	    <td>Name</td>
	  </tr>
	<c:forEach items="${allSpecialities}" var="speciality">    
	  <tr>
	    <td>${speciality.id}</td>
	    <td>${speciality.name}</td>
	  </tr>
	</c:forEach>
	</table>

	<h2><spring:message code="speciality.page"/></h2>
	<br/>
	<form:form method="post" modelAttribute="speciality">
		<table>
			<tr>
				<td><spring:message code="speciality.name"/></td>
				<td><form:input path="name" /></td>
				<td><form:errors path="name" cssClass="error" /></td>
			</tr>
			<tr>
				<td colspan="3"><input type="submit" value="Add"/></td>
			</tr>
		</table>
	</form:form>
</body>
</html>