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
		Exception exception=(Exception)request.getAttribute("exception");
	
	%>
	<p>오류가 발생 하였습니다.
	<p>예외 : <%=exception %>
	<p>toString() : <%=exception.toString()%>
	<p>getClass() : <%=exception.getClass() %>
	<p>getMessage() : <%=exception.getMessage() %>
</body>
</html>