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
		String id=(String)request.getAttribute("id");
		String pw=(String)request.getAttribute("pw");
	%>
	<h3>입력에 성공하셨습니다.</h3>
	<p>아이디 : <%= id %>
	<p>비밀번호 : <%= pw %>
	<p><a href="8_2">8_2로</a>
</body>
</html>