<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="dto.memberdto" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<%
			memberdto dto=(memberdto)request.getAttribute("dto");
		%>
		<form action="update" method="post">
		<h3>.회원가입.</h3>
		<p> ID :<input name="id" type="text" value="<%=dto.getId() %>" readonly="readonly">
		<p> pw :<input name="pw" type="password" value="<%=dto.getPw() %>">
		<p> age :<input name="age" type="text" value="<%=dto.getAge() %>">
		<p><input type="submit" value="변경">
	</form>
</body>
</html>