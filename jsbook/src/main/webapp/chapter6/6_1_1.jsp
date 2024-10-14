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
	<%
		String id=(String)request.getAttribute("id");
	String pw=(String)request.getAttribute("pw");
	String phone1=(String)request.getAttribute("phone1");
	String phone2=(String)request.getAttribute("phone2");
	String phone3=(String)request.getAttribute("phone3");
	String name=(String)request.getAttribute("name");
	String sex=(String)request.getAttribute("sex");
	ArrayList<String> hobby=(ArrayList<String>)request.getAttribute("hobby");
	String comment=(String)request.getAttribute("com");
	

	%>
	<p>아이디 :<%= id %></p>
	<p>비밀번호 :<%= pw %></p>
	<p>이름 :<%= name %></p>
	<p>연락처:<%= phone1 %>-<%= phone2 %>-<%= phone3 %></p>
	<p>성별 :<%= sex %></p>
	<p>성별 :<% for(int i=0;i<hobby.size();i++){
		out.println(hobby.get(i)); }
		%>
		</p>
	
	<p>가입인사 :<%= comment %>
	
</body>
</html>