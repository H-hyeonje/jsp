<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%! int sum(int a,int b){
	return a+b;
}
	%>
<% out.println("2 + 3 = "+ sum(2,3)); %>

<p>2 + 3 = <%= sum(2,3) %></p>
<p><a href="home">돌아가자잉</a>
</body>
</html>