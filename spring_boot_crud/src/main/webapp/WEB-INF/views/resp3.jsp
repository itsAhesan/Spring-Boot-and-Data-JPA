<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Edit Form</h2>



<form action="/update" >
 
 		<input type="hidden" placeholder="Enter Your Id" name="id" value= "${edit1.getId() } ">
      	<input type="text" placeholder="Enter Your Name" name="name" value= "${edit1.getName() } ">
      	<input type="password" placeholder="Enter Your Password" name="pass" value= "${edit1.getPass() } ">
		<input type="number" placeholder="Enter Your Age" name="age" value= "${edit1.getAge() } ">
	
	<input type="text" placeholder="Enter Your Address" name="address" value= "${edit1.getAddress() } ">
		
		<input type="submit" value="update">
		
		</form>
		
	
	


</body>
</html>