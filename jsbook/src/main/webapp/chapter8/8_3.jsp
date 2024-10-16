<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<form name ="loginForm" action="8_3" method="post">
			<p>아이디 : <input type="text" name="id" ></p>
			<p>비밀번호 : <input type="password" name="pw"></p>
			<p><input type="button" value="전송"></p>
		</form>


	<script type="text/javascript">
		var btn=document.querySelector("#submit");	
		btn=addEventListener("click",checkLogin);
		
		function checkLogin() {
			var form=document.loginForm;
			if (form.id.value.length<4||form.id.value.lenght>12){
				alert("아이디는 4~12자 사이로 입력 가능합니다.")
				form.id.select();
				return
			}
			if (form.pw.value.length<4){
				alert("비밀번호는 4자 이상으로 입력 가능합니다.")
				form.pw.select();
				return
			}
		form.submit();
	}
	
	</script>
</body>
</html>