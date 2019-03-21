<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Create</title>
</head>
<body>
	<h2>Spring MVC Create, Read, Update and Delete (CRUD) Example</h2>	
<form action="create" method="POST">
<pre>
    <strong>Create Here | <a href="./read">Click for Read</a></strong>

	First Name: <input type="text" name="firstname" />
	
	Last Name: <input type="text" name="lastname" />
	
	Email: <input type="text" name="email" />
	
	Hobby: <input type="text" name="hobby" />
	
	Phone Number <input type="text" name="phonenumber" />

	<input type="submit" value="Create" />
</pre>
</form>
${msg}
</body>
</html>