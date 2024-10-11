<%@page import="chapter05.exam5_1"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:useBean id="aa" class="chapter05.exam5_1"></jsp:useBean>
</head>
<body>
	<%
		String id=(String)request.getAttribute("aa");
		String password=(String)request.getAttribute("bb");
	
	
	%>
	<p>아이디 : <%= id %>
	<p>비밀번호 : <%= password %>
</body>
</html>