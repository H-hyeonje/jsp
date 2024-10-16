<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="8_4" method="post" name="loginForm">
		<p>아이디 : <input type="text" name="id"></p>
		<p>비밀번호 : <input type="password" name="pw"></p>
		<p> <input type="button" value="전송" id="submitt"></p>
	
	</form>



<script type="text/javascript">
	var btn=document.querySelector("#submitt");	
	btn.addEventListener("click",checkLogin);
	function checkLogin() {
		var form=document.loginForm;
		
			for(i=0;i< form.id.value.length;i++){
				var ch=form.id.value.charAt(i);
				
				if((ch<'a'||ch>'z') && (ch>'A'||ch<'Z') && (ch>'0'||ch<'9')){
					alert("아이디는 영문 소문자만 입력 가능 합니다!");
					form.id.select();
					return;
				}
			}
			if(isNaN(form.pw.value)){
				alert("비밀번호는 숫자만 입력 가능 합니다.!");
				form.pw.select();
				return;
			}
			form.submit();
	}

</script>
</body>
</html>