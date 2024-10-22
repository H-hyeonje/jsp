<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="jakarta.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		session=request.getSession(false);
		String id=(String)session.getAttribute("id");
		String xx=(String)session.getAttribute("xx");
		
		
	
	%>
	<p><%= xx  %>
	<p><a href="13_2">13_2</a>
	<p><a href="13_4">13_4</a>
	<p><a href="13_4">13_5</a>
	<p><a href="13_6">13_6</a>
	<p><a href="13_7">13_7</a>
	<p><a href="13_8">13_8</a>
</body>
</html>