<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="./6_1_2" method="post" name="member">
		<p> 아이디 : <input type="text" name="id"><input type="button" value="아이디 중복 검사" name="id"></p>
		<p> 비밀번호 : <input type="password" name ="pw"></p>
		<p>  이름 : <input type="text" name="name"></p>
		<p> 연락처 : <select name="phone1">
						<option value="010">010</option>
						<option value="011">011</option>
						<option value="016">016</option>
						<option value="017">017</option>
						<option value="019">019</option>
					</select>
				-<input type="text" maxlength="4" size="4" name="phone2">-
				<input type="text" maxlength="4" size="4" name="phone3">
					</p>
		<p>  성별  :남성<input type="radio" name="sex" value="남성" checked>
					여성<input type="radio" name="sex" value="여성" >
		</p>
		<p>   취미: 독서<input type="checkbox" name="hobby" value="독서" checked>
		           영화<input type="checkbox" name="hobby"value="영화" >
		           운동<input type="checkbox" name="hobby"value="운동" >
		           </p>
		 <p> <textarea name="comment" cols="30" rows="3" placeholder="가입 인사를 해주세요"></textarea>
		<p> <input type ="submit" value="가입하기">
			<input type ="reset" value="다시쓰기">
		</p>
	</form>
</body>
</html>