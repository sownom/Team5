$(document).ready(function(){
	$('.stressresult').click(function(){
		for(var i = 1; i <= 20; i++){
			if($('input:radio[name="select' + i + '"]:checked').val() == null){
				alert(i + "번 문항을 선택해 주세요.");
				break;
			}
			
			if(i == 20){
				location.href = './Stresscheck.do';
			}
		}
	});

	$('.cancel').click(function(){
		location.href = './Main.do';
	});
});