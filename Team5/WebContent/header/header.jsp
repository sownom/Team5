<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
	<!-- 헤드 정보 -->
	<div id = "h_main" class = "h_main">
		<!-- 로고 -->
		<img src = "<%=request.getContextPath() %>/image/h_logo.jpg" id = "h_logo" class = "h_logo">
		<!-- 로고 -->
		
		<!-- 사이트 이름 -->
		<div id = "h_title" class = "h_title">Team5 Psychological</div>
		<!-- 사이트이름 -->
		
		<!-- 로그인 버튼 -->
		<div id = "h_right" class = "h_right">
			<input type = "button" id = "h_login" class = "h_login" value = "로그인">
			<input type = "button" id = "h_join" class = "h_join" value = "회원가입">
		</div>
		
		<div id = "h_right2" class = "h_right2">
			<input type = "button" id = "h_logout" class = "h_logout" value = "로그아웃">
			<input type = "button" id = "h_amend" class = "h_amend" value = "회원정보 수정">
		</div>
		<!-- 로그인버튼 -->
	</div>
	<!-- 헤드 정보 -->
	
	<!-- 메뉴 -->
	<div id = "h_nav">
		<input type = "button" id = "h_check" class = "h_check" value = "검사">
		<input type = "button" id = "h_result" class = "h_result" value = "검사 결과">
		<input type = "button" id = "h_board" class = "h_board" value = "게시판">
		<input type = "button" id = "h_counselor" class = "h_counselor" value = "상담사">
	</div>
	<!-- 메뉴 -->
</body>
</html>