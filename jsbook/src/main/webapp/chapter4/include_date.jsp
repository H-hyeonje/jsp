<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>오늘의 날짜 및 시작</p>
	<p><%= (new java.util.Date()).toLocaleString() %>
	<p><a href="home">home</a>
</body>
</html>