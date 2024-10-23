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
		Cookie[] cookies=request.getCookies();
		
		for (int i=0;i<cookies.length;i++){
			cookies[i].setMaxAge(10);
			response.addCookie(cookies[i]);
			
		}
	%>
	<a href="14_1?a=2">aa</a>
</body>
</html>