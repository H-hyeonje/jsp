<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form name ="loginForm" action="8_2" method="post">
	<p>아이디 :<input type ="text" name="id" id="id"></p>
	<p>비밀 번호 : <input type="password" name="pw" id="pw"></p>
	<p> <input type="button" value="전송"  >
</form>
<script type="text/javascript">
	var btn=document.querySelector("#submit");
	
	btn=addEventListener("click",checkLogin);
	console.log("aa");
	function checkLogin() {
	var form=document.loginForm;
		if(form.id.value==""){
			alert("아이디를 입력해주세요")
			form.id.focus();
			return false;
		}else if(form.pw.value==""){
			alert("비밀번호를 입력해주세요")
			form.pw.focus();
			return false;
		}
		form.submit();
	
	}
</script>
</body>
</html>