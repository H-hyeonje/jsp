<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
<%!
	int pageCount=0;
	void addCount(){
		pageCount++;
	}
%>
<%
	addCount();
%>
<p>이 사이트 방문은 <%= pageCount %>번 입니다.</p>
<a href="home">home</a>
</body>
</html>