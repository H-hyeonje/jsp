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
		String curency=(String)request.getAttribute("fc");
		String percentage=(String)request.getAttribute("fp");
		String numberFormat=(String)request.getAttribute("nf");
		String dateFormat=(String)request.getAttribute("df");
		String currentDate=(String)request.getAttribute("lc");
	%>
	
	<p> 국가 :<%=dateFormat %>
	<p> 날짜 :<%=currentDate %>
	<p> 로케일 통화 형식 :<%=curency %>
	<p> 로케일 비율 형식 :<%=percentage %>
	<p> 숫자 (1234.56) :<%=numberFormat%>

</body>
</html>