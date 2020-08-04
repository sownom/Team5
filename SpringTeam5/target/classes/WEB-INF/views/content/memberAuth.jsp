<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script src="http://code.jquery.com/jquery-latest.js"></script>

<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script src="resources/js/member.js"></script>
<style>
#hed {
	border-style: 1px solid grey;
	margin: 0 auto;
	box-shadow: 2px 5px 5px 0px #eee;
	max-width: 500px;
	padding-top: 10px;
	height: 800px;
	margin-top: 50px;
}
</style>
<body>

	<div class="container" id="hed">
		<div class="content">
			<div class="form-group" style="display: none" id="af">
				<div class="from-control" id="e_success" align="center">
				</div>
				<button type="button" class="btn btn-info" id="e_end">확인</button>
			</div>
			<div class="form-group row" align="right" id="be">
				<div class="col-xs-7">
					<input type="text" class="form-control" id="code">
				</div>
				<div class="col-xs-5">
					<button type="button" class="btn btn-info" id="code_check">확인</button>
					<button type="button" class="btn btn-info"
						value=<%=request.getParameter("mail")%> id="email_code">이메일
						인증</button>
				</div>
			</div>
			<div class="form-group" id="e_time"></div>
		</div>
	</div>
</body>
</html>