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
		int num1=(Integer)request.getAttribute("num1");
		int num2=(Integer)request.getAttribute("num2");
		int num3=(Integer)request.getAttribute("num3");
			
		out.println(num1+"/"+num2+"="+num3);
	%>
</body>
</html>