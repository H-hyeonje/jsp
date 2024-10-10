<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="dto.Book" %>
<jsp:useBean id="bookDAO" class="dao.BookRepository" scope="session"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
<meta charset="UTF-8">
<title>도서목록</title>
</head>
<body>
<div class="container py-4">
 <%@ include file="menu.jsp" %>
 <div class="p-5 mb-4 bg-body-tertiary rounded-3">
 	<div class="comtainer-fluid py-5">
 		<h1 class="display-5 fw-bold">도서목록</h1>
 		<p class="col-md-8 fs-4">BookList</p>
 	</div>
 </div>




</div>
</body>
</html>