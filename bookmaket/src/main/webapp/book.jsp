<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="dto.dto" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		dto dto=(dto)request.getAttribute("dto");	
	%>
	<p>가:<%=dto.getBookId() %>
	<p>나:<%=dto.getName() %>
	<p>다:<%=dto.getUnitprice() %>
	<p>라:<%=dto.getAuthor() %>
	<p>바:<%=dto.getDescription() %>
	<p>사:<%=dto.getPublisher() %>
	<p>아:<%=dto.getCategory() %>
	<p>자:<%=dto.getUnitsInStock() %>
	<p>차:<%=dto.getReleaseDate() %>
	<p>카:<%=dto.getConditione() %>
	<p>타:<%=dto.getFileName() %>
	<a href="delete?id=<%=dto.getBookId() %>">삭제</a>
	<a href="update?id=<%=dto.getBookId() %>">수정</a>
</body>
</html>