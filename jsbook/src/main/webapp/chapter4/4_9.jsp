<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="person" class="chapter4.person"></jsp:useBean>
	<jsp:setProperty property="id" name="person" value="111"/>
	<jsp:setProperty property="name" name="person" value="홍길동"/>
	<p> 아이디 : <% out.println(person.getId()); %>
	<p> 이름 : <% out.println(person.getName()); %>
	
</body>
</html>