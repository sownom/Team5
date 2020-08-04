<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js">
</script>


<style>
#hed {
	border-style: 1px solid grey;
	margin: 0 auto;
	box-shadow: 2px 5px 5px 0px #eee;
	max-widt8h: 500px;
	padding-top: 10px;
	height: 300px;
	width: 250px;
	margin-top: 50px;
}
</style>
</head>
<body>
	
	<div class="container" id="hed">
		<div class="content">
			<c:if test="${sessionScope.id != null}">				
				<div id="l_id">${sessionScope.name}</div>
			</c:if>

			
				<input type="button" class="btn btn-info" value="로그아웃"
					onClick="location.href='logOut.do'">
			
			<input type="button" class="btn btn-info" value="마이 페이지 " onClick ="location.href='mypage.do'">
		</div>
	</div>

</body>
</html>