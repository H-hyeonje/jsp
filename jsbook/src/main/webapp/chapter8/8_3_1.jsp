<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <h3>입력 성공했습니다.</h3>
 <% 
 		String id=(String)request.getAttribute("id");
 		String pw=(String)request.getAttribute("pw");
 %>
	<p>아이디 : <%= id %></p>
	<p>비밀번호 : <%= pw %></p>

</body>
</html>