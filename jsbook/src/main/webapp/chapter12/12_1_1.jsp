<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	   String name=(String)request.getAttribute("name");
		out.println("<p>이름은"+name+"</p>");
	
	%>
</body>
</html>