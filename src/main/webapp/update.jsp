<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Update</title>
</head>
<body>
	<h2>Spring MVC Create, Read, Update and Delete (CRUD) Example</h2>
	<p><strong>Update Here | <a href="./read">Click for Read</a></strong></p>
<form action="../update" method="post">
<pre>
<c:forEach var="employee" items="${listEmployee}">
		
Id:    	<input type="text" name="dispId" value="${employee.id}" disabled="disabled"/>
		<input type="hidden" name="id" value="${employee.id}"/>			
First Name:  	<input type="text" name="firstname" value="${employee.firstname}" />

Last Name:  	<input type="text" name="lastname" value="${employee.lastname}" />
		
Email: 	<input type="text" name="email" value="${employee.email}" />
	    
Hobby:	<input type="text" name="hobby" value="${employee.hobby}" />

Phone Number  	<input type="text" name="phonenumber" value="${employee.phonenumber}" />
		    
        <input type="submit" value="Update" />	
</c:forEach>	
</pre>
</form>
${msg}
</body>
</html>