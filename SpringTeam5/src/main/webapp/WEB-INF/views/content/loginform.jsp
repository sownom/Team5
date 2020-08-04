<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/style.css">
<script src="http://code.jquery.com/jquery-latest.js"></script>

<script src="https://apis.google.com/js/platform.js" async defer></script>

<meta name="google-signin-client_id"
	content="932339617596-7nffgo9n806mr2icsvnr41jc3n0p73l5.apps.googleusercontent.com">


	


<script src="resources/js/login.js"></script>
</head>

<body>
	<section class="login-form">
		<h1>프로젝트명 입력</h1>
		<form action="login.do" method="post" class="form-horizontal"
			id="member">
			<div class="int-area">
				<input type="text" name="id" id="id" autocomplete="off" required>
				<label for="id">ID</label>
			</div>

			<div class="form-group">
				<div class="from-control" id="l_id_message"></div>
			</div>

			<div class="int-area">
				<input type="password" name="pw" id="pw" autocomplete="off" required>
				<label for="pw">PASSWORD</label>
			</div>
			<div class="form-group">
				<div class="from-control" id="l_pw_message"></div>
			</div>
			<c:if test="${result=='-1'}">
				<div class="form-group">
					<div class="from-control">가입하지 않은 아이디이거나, 잘못된 비밀번호입니다.</div>
				</div>
			</c:if>
			<div class="btn-area">
				<button type="submit" class=login>LOGIN</button>
				<button onClick="location.href ='./memberform.do'" class=join>JOIN</button>
			</div>

			<div class="social" align="center">소셜로그인</div>

			<div class="form-group" align="center">
				<div class="col-xs-6">
					<a href="${apiURL}"><img height="50"
						src="http://static.nid.naver.com/oauth/small_g_in.PNG" /></a>
				</div>
				
				<div class="col-xs-6">
					<div class="g-signin2" data-onsuccess="onSignIn"></div>
				</div>
			</div>
		</form>
		<div class="caption">
		<a href="id_pw_find_form.do">아아디/비밀번호 찾기</a>
		</div>
	</section>
</body>
</html>