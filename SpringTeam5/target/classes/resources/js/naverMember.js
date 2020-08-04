var emailauth = true;
var x;
var time = 6000;
var idcheck = false;
$(document).ready(

		function() {

			$("#mem_day").change(function() {

				regExpbirth($("#mem_birth").val(), $("#mem_day").val());
			});
			$("#mem_phone3").change(function() {
				regExpphone($("#mem_phone3").val(), $("#mem_phone2").val());
			});

			$("#mem_tel3").change(function() {

				regExptel($("#mem_tel2").val(), $("#mem_tel3").val());
			});

			$("#mem_name").change(function() {

				regExpname($("#mem_name").val());
			});
			$("#sub").click(function() {
				$('#mem_month').removeAttr('disabled');
			});
			// -------------------------------------------------------------------------------------
			// ------------------------이메일 부분
			// ----------------------------------------------------
			// 도메인 선택
			$("#mem_domain").change(
					function() {
						if ($("#mem_domain").val() == "") { // 직접 입력 선택
							// $("#domain").attr("readonly", false);
							$("#mem_email2").removeAttr("readonly");
							$("#mem_email2").val("").focus();
						} else { // 도메인명 선택
							$("#mem_email2").val(
									$("#mem_domain option:selected").val());
							$("#mem_email2").attr("readonly", "readonly");
						}
					});

			// 이메일 인증
			$("#email_auth").click(
					function() {
						var mail = $("#mem_email1").val() + "@"
								+ $("#mem_email2").val();
						if ($("#mem_email1").val() == "") {
							$("#myemail").text("이메일을 입력하셔야 합니다 ");
							$("#mem_email1").focus();
						} else if ($("#mem_email2").val() == "") {
							$("#myemail").text("도메인 입력하셔야 합니다 ");
							$("#mem_email2").focus();

						} else {
							window.open("content/memberAuth.jsp?mail=" + mail,
									"이메일 인증",
									"width=500,height=300,left=700,top=300");
						}
					});

			$("#email_code").click(function() {
				start();
				authcode();
			});

			$("#code_check").click(function() {

				var mycode = $("#code").val();
				$.ajax({
					type : "post",
					url : "codeCheck.do",
					data : {
						"mycode" : mycode
					},
					datatype : "text",
					success : function(data) {
						if (data == 1) {
							alert(data);
							$("#be").hide();
							$("#e_time").hide();
							$("#e_success").text("인증에 성공하셨습니다").show();
							$("#af").show();
							opener.$("#email_auth").hide();
							opener.$("#auth_message").text("인증된 이메일 입니다");
							opener.$("#myemail").text("");
							ok = true;
						} else {

							$("#code").focus();
							return false;
						}
					}
				});
			});
			$("#e_end").click(function() {
				window.close();
			});

			// --------------------------------------------------------------------------------------------
			// ------------------------form submit
			// 부분-----------------------------------------------------

			$("form").submit(
					function() {

						if ($("#mem_name").val() == "") {
							$("#myname").text("이름을 입력하세요");
							$("#mem_name").focus();
							return false;
						}
						if ($("#mem_name").val() != "") {
							alert("이름");
							if (!regExpname($("#mem_name").val())) {
								alert("이름 오류");
								return false;
							}
						}

						if ($("#mem_birth").val() == "") {
							$("#mybirth").text("생년월일을 제대로 입력하세요 ");
							$("#mem_birth").focus();
							return false;
						} else if ($("#mem_month").val() == "") {
							$("#mybirth").text("생년월일을 제대로 입력하세요 ");
							$("#mem_month").focus();
							return false;
						} else if ($("#mem_day").val() == "") {
							$("#mybirth").text("생년월일을 제대로 입력하세요 ");
							$("#mem_day").focus();
							return false;
						}
						if ($("#mem_birth").val() != ""
								&& $("#mem_month").val() != "") {
							alert("생년월일");
							if (!regExpbirth($("#mem_birth").val(), $(
									"#mem_day").val())) {
								alert("생년월일오류");
								return false;
							}
						}

						if ($("#mem_tel2").val() == "") {
							$("#mytel").text("전화번호를 제대로 입력하세요 ");
							$("#mem_tel2").focus();
							return false;
						}
						if ($("#mem_tel3").val() == "") {
							$("#mytel").text("전화번호를 제대로 입력하세요 ");
							$("#mem_tel3").focus();
							return false;
						}
						if ($("#mem_tel3").val() != ""
								&& $("#mem_tel2").val() != "") {
							alert("전화번호");
							if (!regExptel($("#mem_tel2").val(), $("#mem_tel3")
									.val())) {
								alert("전화번호 오류");
								return false;
							}
						}

						if ($("#mem_phone2").val() == "") {
							$("#myphone").text("핸드폰 번호를 제대로 입력하세요 ");
							$("#mem_phone2").focus();
							return false;
						} else if ($("#mem_phone3").val() == "") {
							$("#myphone").text("핸드폰 뒷자리 제대로 입력하세요 ");
							$("#mem_phone3").focus();
							return false;
						}
						if ($("#mem_phone3").val() != ""
								&& $("#mem_phone2").val() != "") {
							alert("핸드폰");
							if (!regExpphone($("#mem_phone3").val(), $(
									"#mem_phone2").val())) {
								alert("핸드폰 오류");
								return false;
							}
						}

						if ($("#mem_addr1").val() == "") {
							$("#myaddr").text("주소를 제대로 입력하세요 ");
							$("#mem_addr1").focus();
							return false;
						}
						if ($("#mem_addr2").val() == "") {
							$("#myaddr").text("상세주소를 제대로 입력하세요 ");
							$("#mem_addr2").focus();
							return false;
						}
						if ($("#mem_email1").val() == "") {
							$("#myemail").text("이메일을 제대로 입력하세요 ");
							$("#mem_email1").focus();
							return false;
						}
						if ($("#mem_email2").val() == "") {
							$("#myemail").text("도메인을 제대로 입력하세요 ");
							$("#mem_email2").focus();
							return false;
						}
						if ($("#auth_message").text() == "") {
							$("#myemail").text("이메일 인증이 되지 않았습니다");
							return false;
						}

					});

		}); // ready() end

// ---------------------------------------------------------------------------------------
// -----------------------이메일 인증
// 타이머----------------------------------------------------
function start() {
	if (emailauth == true) {
		x = setInterval("timers()", 1000);
		emailauth = false;
	} else if (emailauth == false) {
		clearInterval(x);
		time = 30;
		x = setInterval("timers()", 1000);
	}
}
function timers() {
	var min = "";
	var sec = "";
	if (time > 0) {
		min = parseInt(time / 60);
		sec = time % 60;
		$("#e_time").text(min + "분" + sec + "초");
		time--;
	} else if (time <= 0) {
		clearInterval(x);
		$("#e_success").text("시간이 초과되었습니다").show();
		$("#af").show();
	}
};

// ---------------------------------------------------------------------------------------
// -----------------------이메일 인증
// 유효성----------------------------------------------------

function authcode() {

	var mail = $("#email_code").val();
	$.ajax({
		type : "post",
		url : "mailCode.do",
		data : {
			"mail" : mail
		},
		datatype : "text",
		success : function() {
			alert("이메일을 확인해주세요");
			$("#email_code").text("재전송");
		}
	});
};

// ---------------------------------------------------------------------------------------
// -----------------------유효성
// 함수----------------------------------------------------
function regExpname(name) {

	var pattern = /[^가-힣\w]$/;
	if (pattern.test(name)) {
		$("#myname").focus();
		$("#myname").text("한글과 영문 대 소문자를 사용하세요. (특수기호, 공백 사용 불가)");
		return false;
	} else {
		$("#myname").text("");
		return true;
	}
}

// https://holybell87.tistory.com/22#.Xxfu654zaUk
function regExpphone(phone, phone2) {
	var pattern = /[0-9]{4}/;
	if (pattern.test(phone) && pattern.test(phone2)) {
		$("#myphone").text("");
		return true;
	} else {
		$("#myphone").text("핸드폰 입력이 제대로 되지 않았습니다 ");
		return false;
	}

}
function regExptel(tel1, tel2) {
	var pattern = /[0-9]{3}/;
	var pattern1 = /[0-9]{4}/;
	if (pattern.test(tel1) && pattern1.test(tel2)) {
		$("#mytel").text("");
		return true;

	} else {
		$("#mytel").text("전화번호 입력이 제대로 되지 않았습니다 ");
		return false;
	}

}
function regExpbirth(birth1, birth2) {

	var pattern = /^(19|20)\d{2}$/;
	var pattern1 = /^(0[1-9]|[12][0-9]|3[0-1])$/;

	if (!pattern.test(birth1)) {
		$("#mybirth").text("생년월일 입력이 제대로 되지 않았습니다 ");
		return false;
	} else if (!pattern1.test(birth2)) {
		$("#mybirth").text("형식을 지켜주세요 ");
		return false;

	} else {
		$("#mybirth").text("");
		return true;
	}
}
// ---------------------------------------------------------------------------------------
// -----------------------주소----------------------------------------------------

function openDaumPostcode() {
	new daum.Postcode({
		oncomplete : function(data) {
			// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
			// 우편번호와 주소 정보를 해당 필드에 넣고, 커서를 상세주소 필드로 이동한다.
			// document.getElementById('join_zip1').value = data.postcode1;
			// document.getElementById('join_zip2').value = data.postcode2;
			document.getElementById('mem_post').value = data.zonecode;
			document.getElementById('mem_addr1').value = data.address;

		}
	}).open();
}