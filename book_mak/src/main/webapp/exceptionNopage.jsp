<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
<title>페이지 오류</title>
</head>
<body>
<div class="container py-4">
	<jsp:include page="menu.jsp"></jsp:include>
		<div class ="p-5 mb-4 bg-body-tertiary rounded-3" >
			<div class="container-fluid py-5">
			<h2 class="alert alert-danger">요청하신 페이지를 찾을 수 없습니다.</h2>
		</div>	
	</div>
		<div class="row align-items-md-stretch">
			<div class="col-md-12">
				<div class="h-100 p-5">
					<p> <%= request.getRequestURL() %>
		<p> <a href="welcome.jsp" class="btn btn-secondary">도서 목록&raquo;</a>
				</div>
			</div>
		</div>

	</div>
</body>
</html>