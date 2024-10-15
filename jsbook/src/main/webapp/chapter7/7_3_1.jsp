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
		String a=(String)request.getAttribute("aa");
	%>
	<p>연결
	<img src="img/<%= a %>">
</body>
</html>