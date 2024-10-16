<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>회원가입</h3>
	<form action="8_5" method="post" name="member">
		<p>아이디 : <input type="text" name="id">
		<p>비밀번호 :<input type="password" name="pw">
		<p>이름 : <input type="text" name="name">
		<p> 연락처 : <input type="text" name="phon1" maxlength="3" size="4">-
		<input type="text" name="phon2" maxlength="4" size="4">-
		<input type="text" name="phon3" maxlength="4" size="4">
		<p>이메일 : <input type="text" name="email">
		<p><input type="button" value="가입하기" onclick="checkMember()">

	</form>

	<script type="text/javascript">
		function checkMember(){
				console.log("여")
			var regExpId=/^[a-z|A-Z\ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/;
			var regExpName=/^[가-힣][가-힣]*$/;
			var regExpPasswd=/^[0-9][0-9]*$/;
			var regExpPhone=/^\d{3}-\d{3,4}-\d{4}$/;
			var regExpEmail=/^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
				console.log("di")
			var form=document.member;
				console.log("염")
				
			var id=form.id.value
			var name=form.name.value
			var pw=form.pw.value
			var phone=form.phon1.value+"-"+form.phon2.value+"-"+form.phon3.value
			var email=form.email.value
				console.log("병")
			if(!regExpId.test(id)){
				alert("아이디는 문자로 시작해주세요")
				form.id.select();
				return;
			}
	
			if(!regExpPasswd.test(pw)){
				alert("비밀번호는 숫자만 입력해주세요")
				form.pw.select();
				return;
			}
			if(!regExpName.test(name)){
				alert("이름은 한글만 입력해주세요")
				form.name.select();
				return;
			}
			if(!regExpPhone.test(phone)){
				alert("연락처 입력을 확인해주세요")
				form.phon1.select();
				return;
			}
			if(!regExpEmail.test(email)){
				alert("이메일 입력 확인해주세요")
				form.email.select();
				return;
			}
			form.submit();
		}
	
	</script>
</body>
</html>