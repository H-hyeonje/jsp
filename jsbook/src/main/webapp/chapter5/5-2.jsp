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
	<% ArrayList headerName=(ArrayList)request.getAttribute("aa");
		ArrayList headerValue=(ArrayList)request.getAttribute("en");
	%>
	
		 <p><%out.println(headerName); %>
		 <p><% out.println(headerValue); %>

</body>
</html>