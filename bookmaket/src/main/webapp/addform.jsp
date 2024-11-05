<%@page import="org.eclipse.jdt.internal.compiler.parser.RecoveredRequiresStatement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page session="false" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<!-- 리소스 경로는 절대 경로를 추천 -->

<link rel ="stylesheet" href ="/bookmaket/resources/css/bootstrap.min.css" />
<script type="text/javascript" src="/bookmaket/resources/js/validation.js"></script>
<meta charset="UTF-8">
<title>도서등록</title>
</head>
<body>
<fmt:setLocale value='<%=request.getParameter("language")%>'/>
<fmt:bundle basename="bundle.message">
	<div class="container py-4">
		<%@include file="menu.jsp" %>
		
		<div class="p-5 mb-4 bg-body-tertiary rounded-3">
			<div class="container-fluid py-5">
				<h1	class="display-5 fw-bold"><fmt:message key="title"></fmt:message></h1>
				<p class="col-md-8 fs-4">Book Addition</p>
			</div>
		</div>
	
		<div class="row align-items-md-stretch">
			<div class="text-end">
				<a href="?language=ko">kor</a> | <a href="?language=en">eng</a>
				<a href = "logout.jsp" class ="btn btn-sm btn-success pull right">logout</a>
			</div>
			<form action="add" name="newBook" method="post" class="form-horizontal" enctype="multipart/form-data">
				<div class="mb-3 row">
					<label class="col-sm-2"><fmt:message key="bookid"></fmt:message></label>
					<div class="col-sm-3">
						<input id="bookid" type="text" name="bookid" class="form-control">
					</div>
				</div>
				
				<div class="mb-3 row">
					<label class="col-sm-2"><fmt:message key="bookname"></fmt:message></label>
					<div class="col-sm-3">
						<input id="bookname" type="text" name="bookname" class="form-control">
					</div>
				</div>
				
				<div class="mb-3 row">
					<label class="col-sm-2"><fmt:message key="unitPrice"></fmt:message></label>
					<div class="col-sm-3">
						<input id="unitPrice" type="text" name="unitprice" class="form-control">
					</div>
				</div>				

				<div class="mb-3 row">
					<label class="col-sm-2"><fmt:message key="author"></fmt:message></label>
					<div class="col-sm-3">
						<input type="text" name="author" class="form-control">
					</div>
				</div>	
				
				<div class="mb-3 row">
					<label class="col-sm-2"><fmt:message key="publisher"></fmt:message></label>
					<div class="col-sm-3">
						<input type="text" name="publisher" class="form-control">
					</div>
				</div>						

				<div class="mb-3 row">
					<label class="col-sm-2"><fmt:message key="releaseDate"></fmt:message></label>
					<div class="col-sm-3">
						<input type="text" name="releaseDate" class="form-control">
					</div>
				</div>						

				<div class="mb-3 row">
					<label class="col-sm-2"><fmt:message key="bookdescription"></fmt:message></label>
					<div class="col-sm-3">
						<textarea id="bookdescription" name="bookdescription" rows="2" cols="50" class="form-control" placeholder="100자 이상 적어주세요"></textarea>
					</div>
				</div>						

				<div class="mb-3 row">
					<label class="col-sm-2"><fmt:message key="category"></fmt:message></label>
					<div class="col-sm-3">
						<input type="text" name="category" class="form-control">
					</div>
				</div>						

				<div class="mb-3 row">
					<label class="col-sm-2"><fmt:message key="unitsInStock"></fmt:message></label>
					<div class="col-sm-3">
						<input id="unitsInStock" type="text" name="unitsInStock" class="form-control">
					</div>
				</div>						

				<div class="mb-3 row">
					<label class="col-sm-2"><fmt:message key="bookcondition"></fmt:message></label>
					<div class="col-sm-5">
						<input type="radio" name="bookcondition" value="new" checked="checked"><fmt:message key="bookcondition_new"></fmt:message>
						<input type="radio" name="bookcondition" value="Old"><fmt:message key="bookcondition_Old"></fmt:message>
						<input type="radio" name="bookcondition" value="Ebook"><fmt:message key="bookcondition_Ebook"></fmt:message>
					</div>
				</div>	
				
				<div class="mb-3 row">
					<label class="col-sm-2"><fmt:message key="bookImage"></fmt:message></label>
					<div class="col-sm-5">
						<input type="file" name="BookImge" class="form-control">
					</div>
				</div>

				<div class="mb-3 row">
					<div class="col-sm-offset-2 col-sm-10">
						<input type="button" class="btn btn-primary" value="<fmt:message key="button"/>" onclick="CheckBook()">
						
					</div>
				</div>	
							
			</form>
		</div>
	<jsp:include page="footer.jsp"></jsp:include>
	
	
	</div>
	</fmt:bundle>

</body>
</html>