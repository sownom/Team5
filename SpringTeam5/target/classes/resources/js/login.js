$(document).ready(function() {
		//https://ko.coder.work/so/javascript/599215
		//function onSignIn(googleUser) {  		var id_token = googleUser.getAuthResponse().id_token; 		var xhr = new XMLHttpRequest();
		$("form").submit(function() {
			if ($("#l_id").val() == "") {
				$("#l_id_message").text("아이디를 입력하세요");
				$("#l_id").focus();
				return false;
			}
			if ($("#l_pw").val() == "") {
				$("#l_pw_message").text("비밀번호를 입력하세요");
				$("#l_pw").focus();
				return false;
			}
		});
	});
	// 구글 로그인
	function onSignIn(googleUser) {

		var id_token = googleUser.getAuthResponse().id_token;
		var xhr = new XMLHttpRequest();
		xhr.open('POST', 'http://localhost:80/Project01/googleLogin.do');
		xhr.setRequestHeader('Content-Type',
				'application / x-www-form-urlencoded');
		xhr.onload = function() {
			console.log('Signed in as :' + xhr.responseText);
		};
		xhr.send('idtoken=' + id_token);

	};