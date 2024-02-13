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



<table border="2" width="70%" cellpadding="2">  
<tr><th>Id</th><th>Name</th><th>PassWord</th><th>Age</th><th>Address</th><th>Edit</th><th>Delete</th></tr>
<c:forEach var="b" items="${msg }"> 
<tr>


<td>${b.getId() }</td>
<td>${b.getName() }</td>
<td>${b.getPass() }</td>
<td>${b.getAge() }</td>
<td>${b.getAddress() }</td>
<td> <a href="edit/${b.getId() }">Edit </a> </td>
<td> <a href="delete/${b.getId() }">Delete </a> </td>

</tr>



</c:forEach>
	</table>

</body>
</html>