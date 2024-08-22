<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Details</title>
</head>
<body>
	<h1><%= "Student Name is "+request.getAttribute("studname") %></h1>
	<% 
		for(int i=0;i<5;i++)
			out.println("<h2>JSP page "+i+"</h2><br>"); 
	%>
</body>
</html>