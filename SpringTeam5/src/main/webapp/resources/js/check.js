$(document).ready(function(){
	$('.MBTIresult').submit(function(){
		for(var i = 1; i <= 40; i++){
			if($('input:radio[name="select' + i + '"]:checked').val() == null){
				alert(i + "번 문항을 선택해 주세요.");
				return false;
				break;
			}
		}
	});
	
	$('.stressresult').submit(function(){
		for(var i = 1; i <= 30; i++){
			if($('input:radio[name="select' + i + '"]:checked').val() == null){
				alert(i + "번 문항을 선택해 주세요.");
				return false;
				break;
			}
		}
	});
	
	$('.depressionresult').submit(function(){
		for(var i = 1; i <= 20; i++){
			if($('input:radio[name="select' + i + '"]:checked').val() == null){
				alert(i + "번 문항을 선택해 주세요.");
				return false;
				break;
			}
		}
	});
	
	$('.alcoholresult').submit(function(){
		for(var i = 1; i <= 10; i++){
			if($('input:radio[name="select' + i + '"]:checked').val() == null){
				alert(i + "번 문항을 선택해 주세요.");
				return false;
				break;
			}
		}
	});
	
	$('.gameresult').submit(function(){
		for(var i = 1; i <= 20; i++){
			if($('input:radio[name="select' + i + '"]:checked').val() == null){
				alert(i + "번 문항을 선택해 주세요.");
				return false;
				break;
			}
		}
	});

	$('.cancel').click(function(){
		location.href = './Main.do';
	});
});