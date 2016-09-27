<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
	<title>Employee Management</title>
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
	
	<h2><spring:message code="lbl.page.list" text="lbl.page.list" /></h2>
	<br/>
	
	<table id="listOfEmployees" border="1">
	<tr>
	    <td>ID</td>
	    <td>Name</td>
	    <td>Speciality</td>
	  </tr>
	<c:forEach items="${allPrograms}" var="program">    
	  <tr>
	    <td>${program.id}</td>
	    <td>${program.name}</td>
	    <td>${program.speciality.name}</td>
	  </tr>
	</c:forEach>
	</table>

	<h2><spring:message code="lbl.page" text="Add New Employee" /></h2>
	<br/>
	<form:form method="post" modelAttribute="program">
		<table>
			<tr>
				<td><spring:message code="lbl.firstName" text="First Name" /></td>
				<td><form:input path="name" /></td>
				<td><form:errors path="name" cssClass="error" /></td>
			</tr>
			<tr>
				<td><spring:message code="lbl.department" text="Department" /></td>
				<td><form:select path="speciality" items="${allSpecialities}" itemValue="id" itemLabel="name" /></td>
				<td><form:errors path="speciality" cssClass="error" /></td>
			</tr>
			<tr>
				<td colspan="3"><input type="submit" value="Add Employee"/></td>
			</tr>
		</table>
	</form:form>
</body>
</html>