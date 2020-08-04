<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/content/style1.css">

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
	height: 1000px;
	margin-top: 50px;
}
</style>

</head>
<body>

	<form action="./member.do" method="post" class="form-horizontal"
		id="member">
	<input type ="hidden" id ="mem_social" name = "mem_social" value="1">
		<div class="container" id="hed">
			<div class="content">
				<!--아이디 입력  -->
				<div class="form-group">
					<label for="mem_id">아이디</label>
					<div class="input-group">
						<span class="input-group-addon"> <i
							class="glyphicon glyphicon-user"></i>
						</span> <input type="text" id="mem_id" name="mem_id" class="form-control">	
						<div class="input-group-btn">
							<button class="btn btn-info" type="button" id="idcheck">
								<i class="glyphicon glyphicon-search"></i>
							</button>
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="from-control" id="myid"></div>
				</div>
				<!--비밀번호 입력 및 다시 확인  -->

				<div class="form-group">
					<label for="mem_pw">비밀번호</label>
					<div class="input-group">
						<span class="input-group-addon"> <i
							class="glyphicon glyphicon-lock"></i>
						</span> <input type="password" class="form-control" id="mem_pw"
							name="mem_pw" placeholder="Enter password">
					</div>
				</div>
				<div class="form-group">
					<div class="from-control" id="mypw"></div>
				</div>
				<div class="form-group">
					<label for="mem_pw2">비밀번호 재 확인</label>
					<div class="input-group">
						<span class="input-group-addon"> <i
							class="glyphicon glyphicon-bell"></i>
						</span> <input type="password" class="form-control" id="mem_pw2"
							placeholder="Enter password">
					</div>
				</div>
				<div class="form-group">
					<div class="from-control" id="mypw2"></div>
				</div>
				<div class="form-group ">
					<label for="i_id">이름</label>
					<div class="input-group">
						<span class="input-group-addon"> <i
							class="glyphicon glyphicon-user"></i>
						</span> <input type="text" id="mem_name" name="mem_name"
							class="form-control">
					</div>
				</div>
				<div class="form-group">
					<div class="from-control" id="myname"></div>
				</div>


				<!--생년월일  -->
				<label for="mem_birth">생년월일</label>
				<div class="form-group row">
					<div class="col-xs-4 ">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-calendar"></i>
							</span> <input type="text" class="form-control" id="mem_birth"
								name="mem_birth" placeholder="년 4자리" maxlength="4">
						</div>
					</div>
					<div class="col-xs-4">
						<select class="form-control" id="mem_month" name="mem_month">
							<option value="">월</option>
							<option value="01">01</option>
							<option value="02">02</option>
							<option value="03">03</option>
							<option value="04">04</option>
							<option value="05">05</option>
							<option value="06">06</option>
							<option value="07">07</option>
							<option value="08">08</option>
							<option value="09">09</option>
							<option value="10">10</option>
							<option value="11">11</option>
							<option value="12">12</option>
						</select>
					</div>
					<div class="col-xs-4">
						<input type="text" class="form-control" id="mem_day"
							name="mem_day" placeholder="일"  maxlength="2">
					</div>
				</div>
				<div class="form-group">
					<div class="from-control" id="mybirth"></div>
				</div>
				<!--집 전화 번호  -->
				<label for="mem_tel1">집 전화번호</label>
				<div class="form-group row">
					<div class="col-xs-4">
						<div class="input-group">
							<span class="input-group-addon "> <i
								class="glyphicon glyphicon-phone"></i>
							</span> <select class="form-control" id="mem_tel1" name="mem_tel1">
								<option value="02">02</option>
								<option value="031">031</option>
								<option value="080">080</option>
							</select>

						</div>
					</div>
					<div class="col-xs-4">
						<input type="text" class="form-control" id="mem_tel2"
							name="mem_tel2" maxlength="3">
					</div>
					<div class="col-xs-4">
						<input type="text" class="form-control" id="mem_tel3"
							name="mem_tel3" maxlength="4">
					</div>
				</div>
				<div class="form-group">
					<div class="from-control" id="mytel"></div>
				</div>

				<!--핸드폰 번호  -->
				<label for="mem_phone1">핸드폰 번호</label>
				<div class="form-group row">
					<div class="col-xs-4">
						<div class="input-group">
							<span class="input-group-addon "> <i
								class="glyphicon glyphicon-phone"></i>
							</span> <select class="form-control" id="mem_phone1" name="mem_phone1">
								<option value="010">010</option>
								<option value="016">016</option>
								<option value="011">011</option>
							</select>

						</div>
					</div>
					<div class="col-xs-4">
						<input type="text" class="form-control" id="mem_phone2"
							name="mem_phone2" maxlength="4">
					</div>
					<div class="col-xs-4">
						<input type="text" class="form-control" id="mem_phone3"
							name="mem_phone3" maxlength="4">
					</div>
				</div>
				<div class="form-group">
					<div class="from-control" id="myphone"></div>
				</div>

				<!--주소 검색  -->
				<label for="mem_address">주소</label>
				<div class="form-group row">
					<div class="input-group col-xs-7">
						<span class="input-group-addon"> <i
							class="glyphicon glyphicon-home"></i>
						</span> <input type="text" id="mem_post" name="mem_post"
							class="form-control">
						<div class="input-group-btn">
							<button class="btn btn-info" type="button" id="addressbutton"
								onClick="openDaumPostcode()">우편번호 검색</button>
						</div>
					</div>
				</div>
				<div class="form-group row">
					<div class="col-xs-7">
						<input type="text" id="mem_addr1" name="mem_addr1"
							class="form-control" />
					</div>
					<div class="col-xs-4">
						<input type="text" id="mem_addr2" name="mem_addr2"
							class="form-control" />

					</div>
				</div>

				<div class="form-group">
					<div class="from-control" id="myaddr"></div>
				</div>



				<!--이메일 -->
				<label for="mem_email1">이메일</label>
				<div class="form-group row">
					<div class="col-xs-4">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class=" glyphicon glyphicon-envelope"></i>
							</span> <input type="text" class="form-control" id="mem_email1"
								name="mem_email1">
						</div>
					</div>
					<div class="col-xs-4">
						<input type="text" class="form-control" id="mem_email2"
							name="mem_email2">
					</div>
					<div class="col-xs-4">
						<select id="mem_domain" class="form-control" name="mem_domain">
							<option value="">직접입력</option>
							<option value="naver.com">네이버</option>
							<option value="daum.net">다음</option>
							<option value="nate.com">네이트</option>
							<option value="gmail.com">gmail</option>
						</select>
					</div>
				</div>
				<div class="form-group">
					<div class="from-control" id="myemail"></div>
				</div>

				<!--이메일 인증  -->
				<div class="form-group">
					<button type="button" class="btn btn-info" id="email_auth">이메일
						인증</button>
					<div class="from-control" id="auth_message"></div>
				</div>
				<!--가입  -->
				<div class="form-group " align="center">

					<input type="submit" class="btn btn-info" value="가입">

					<button type="button" class="btn btn-info" onclick="ti()">취소</button>

				</div>
			</div>
		</div>
	</form>


</body>