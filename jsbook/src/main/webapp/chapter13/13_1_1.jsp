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
</body>
</html>