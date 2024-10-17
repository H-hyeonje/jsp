<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container py-4">
		<%@include file="menu.jsp" %>
		
		<div>
			<div class="container-fluid py-5">
				<h1 class="display-5 fw-bold">로그인</h1>
				<p class="co-md-8 fs-4">Login</p>
			</div>
		</div>
	
	
		<div>
			<div>
				<div>
					<h3>Please sign in</h3>
					<%
						String error=request.getParameter("error");
						if(error!=null){
							out.println("<div class='alert alert-danger'>");
							out.println("아이디와 비밀번호를 확인해 주세요.");
							out.println("</div>");
						}
					%>
					<form class="form-signin" action="j_security_check" method="post">
					<div class="form-floating mb-3 row">
						<input type="text" class="form-control" name='j_username' required autofocus>
						<label for="floatingInput">ID</label>
					</div>
					<div class="form-floating mb-3 row">
						<input type="password" class="form-control" name='j_password' required autofocus>
						<label for="floatingInput">Password</label>
					</div>
					<button class="btn btn-lg btn-success" type="submit">로그인</button>
					</form>
				</div>
			</div>
		</div>
		<%@ include file="footer.jsp" %>
	
	</div>
</body>
</html>