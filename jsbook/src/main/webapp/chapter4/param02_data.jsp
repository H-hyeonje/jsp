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
		String title=request.getParameter("title");
	%>
	<h3><%= java.net.URLDecoder.decode(title) %></h3>
	<h3>today is :<%= request.getParameter("date") %></h3>
</body>
</html>