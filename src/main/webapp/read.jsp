<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Read</title>
</head>
<body>
	<h2>Spring MVC Create, Read, Update and Delete (CRUD) Example</h2>
	<p><strong>Employee List is Here | <a href="create.jsp">Click for Create</a></strong></p>
	<table border="1">
		<tr>
			<th>Id</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email</th>
			<th>Hobby</th>
			<th>Phone Number</th>
			<th>Action</th>
		</tr>
		<c:forEach var="employee" items="${listEmployee}">
			<tr>
				<td>${employee.id}</td>
				<td>${employee.firstname}</td>
				<td>${employee.lastname}</td>
				<td>${employee.email}</td>
				<td>${employee.hobby}</td>
				<td>${employee.phonenumber}</td>
				<td><a href="update/<c:out value='${employee.id}'/>">Update</a> | 
			 <a href="delete/<c:out value='${employee.id}'/>">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>