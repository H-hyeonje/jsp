<%@page import="java.awt.font.ImageGraphicAttribute"%>
<%@page import="java.io.File"%>
<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="com.oreilly.servlet.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String name=(String)request.getAttribute("aa");
	String subject=(String)request.getAttribute("bb");
	String filename=(String)request.getAttribute("cc");
	
	out.println("파일 이름 ="+name);
	out.println("파일 제목 ="+subject);
	out.println("파일 ="+filename);

	%>

</body>
</html>