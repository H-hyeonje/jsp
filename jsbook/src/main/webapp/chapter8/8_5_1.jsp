<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%	request.setCharacterEncoding("UTF-8");
		String id=(String)request.getAttribute("id");
		String name=(String)request.getAttribute("name");
		String pw=(String)request.getAttribute("pw");
		String p1=(String)request.getAttribute("phon1");
		String p2=(String)request.getAttribute("phon2");
		String p3=(String)request.getAttribute("phon3");
		String em=(String)request.getAttribute("email");
	%>
	
	<p> 아이디 :<%=id %>
	<p> 이름 :<%=name %>
	<p> 비밀번호 :<%=pw %>
	<p> 전화번호 :<%=p1 %>-<%=p2 %>-<%=p3 %>
	<p> 이메일 :<%=em %>
</body>
</html>