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
		out.println("현재 설정된 쿠키의 갯수 :" +cookies.length+"<br>");
		out.println("==============================<br>");
		for(int i=0;i <cookies.length;i++){
			out.println("설정된 쿠키의 속성 이름 []"+i+cookies[i].getName()+"<br>");
			out.println("설정된 쿠키의 속성 값 []"+i+cookies[i].getValue()+"<br>");
			out.println("==============================<br>");
		}
	
	%>
	<a href="14_1?a=1">14_3으로</a>
</body>
</html>