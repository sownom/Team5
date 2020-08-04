<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel = "stylesheet" href="resources/css/css.css">
<script src = "http://code.jquery.com/jquery-Latest.js"></script>
<script src="resources/js/js.js"></script>
</head>
<body>
	<!-- header -->
	<div>
		<%@include file = "../header/header.jsp" %>
	</div>
	<!-- header -->
	
	<!-- content -->
	<div id = "p_main" class = "p_main">
		<!-- MBTI -->
		<div id = "p_MBTI" class = "p_MBTI">
			<!-- MBTI img -->
			<img src = "resources/image/p_MBTI.png" id = "p_m_logo" class = "p_m_logo">
			<!-- MBTI img -->
			
			<!-- MBTI 설명 -->
			<div id = "p_explanation" class = "p_explanation">
				<p>일상생활에 유용하게 활용할 수 있도록 고안한 자기보고식 성격유형지표이다.</p>
				<p>인식과 판단에 대한 융의 심리적 기능이론, 그리고 인식과 판단의 향방을 결정짓는 융의 태도 이론을 바탕으로 하여 제작되었다.</p>
				<p>선호경향들이 하나하나 또는 여러 개가 합쳐져서 인간의 행동에 어떠한 영향을 미치는가를 파악하여 실생활에 응용할 수 있도록 제작된 심리검사이다.</p>
			</div>
			<!-- MBTI 설명 -->
			
			<!-- MBTI 검사 -->
			<div id = "p_inspection" class = "p_inspection">
				<input type = "button" value = "검사" id = "p_m_button" class = "p_m_button">
			</div>
			<!-- MBTI 검사 -->
		</div>
		<!-- MBTI -->
		
		<!-- 스트레스 -->
		<div id = "p_stress" class = "p_stress">
			<!-- 스트레스 img -->
			<img src = "resources/image/p_stress.jpg" id = "p_s_logo" class = "p_s_logo">
			<!-- 스트레스 img -->
			
			<!-- 스트레스 설명 -->
			<div id = "p_explanation" class = "p_explanation">
				<p>외부에서 압력받으면 긴장, 흥분, 각성, 불안 같은 생리 반응이 일어나는데 이런 외부 압력을 스트레스 요인이라고 칭하고 여기서 벗어나 원상 복귀하려는 반작용을 스트레스라고 칭한다</p>
				<p>스트레스가 과도하면 불안을 일으키고 이런 불안은 신체가 떨리는 소위 생리상 불순의 자동 반응을 일으켜 문제 해결을 간접으로 방해하는 역할을 한다.</p>
				<p>스트레스 수준이 지나치게 높거나 낮아도 바람직하지 않으므로, 스트레스는 적당한 수준을 유지해야 한다.</p>
			</div>
			<!-- 스트레스 설명 -->
			
			<!-- 스트레스 검사 -->
			<div id = "p_inspection" class = "p_inspection">
				<input type = "button" value = "검사" id = "p_s_button" class = "p_s_button">
			</div>
			<!-- 스트레스 검사 -->
		</div>
		<!-- 스트레스 -->
		
		<!-- 우울증 -->
		<div id = "p_depression" class = "p_depression">
			<!-- 우울증 img -->
			<img src = "resources/image/p_depression.jpg" id = "p_d_logo" class = "p_d_logo">
			<!-- 우울증 img -->
			
			<!-- 우울증 설명 -->
			<div id = "p_explanation" class = "p_explanation">
				<p>우울증은 생각의 내용, 사고 과정, 동기, 의욕, 관심, 행동, 수면, 신체 활동 등 전반적인 정신 기능이 지속적으로 저하되어 일상생활에도 악영향을 미치는 상태를 의미합니다.</p>
				<p>우울증의 확실한 원인은 아직 명확하게 밝혀지지 않았습니다. 다만 다른 정신 질환과 마찬가지로 다양한 생화학적, 유전적, 환경적 요인이 우울증을 일으킨다고 합니다.</p>
				<p>우울증은 정신건강의학과 의사와 면담하여 병력을 청취하고 환자의 상태가 진단 기준에 부합하는지 확인한 후 진단합니다.</p>
			</div>
			<!-- 우울증 설명 -->
			
			<!-- 우울증 검사 -->
			<div id = "p_inspection" class = "p_inspection">
				<input type = "button" value = "검사" id = "p_d_button" class = "p_d_button">
			</div>
			<!-- 우울증 검사 -->
		</div>
		<!-- 우울증 -->
		
		<!-- 알코올 중독 -->
		<div id = "p_alcohol" class = "p_alcohol">
			<!-- 알코올중독 img -->
			<img src = "resources/image/p_alcohol.jpg" id = "p_a_logo" class = "p_a_logo">
			<!-- 알코올중독 img -->
			
			<!-- 알코올중독 설명 -->
			<div id = "p_explanation" class = "p_explanation">
				<p>알코올 의존 또는 중독이란 지속적이고 반복적인 과도한 음주로 인해 신체적, 정신적, 사회적 기능이 손상되는 만성 질환입니다.</p>
				<p>유전적 요인이 알코올 중독 발생 위험도의 60%를 차지하며, 환경적 요인이 40%로 생각됩니다.</p>
				<p>알코올 의존의 진단기준은 DSM-IV-TR에 의하면 지난 12개월 동안 다음 증상 중에서 3가지 이상이 해당될 때 알코올 의존 진단을 할 수 있습니다.</p>
			</div>
			<!-- 알코올중독 설명 -->
			
			<!-- 알코올중독 검사 -->
			<div id = "p_inspection" class = "p_inspection">
				<input type = "button" value = "검사" id = "p_a_button" class = "p_a_button">
			</div>
			<!-- 알코올중독 검사 -->
		</div>
		<!-- 알코올 중독 -->
		
		<!-- 게임 중독 -->
		<div id = "p_game" class = "p_game">
			<!-- 게임중독 img -->
			<img src = "resources/image/p_game.jpg" id = "p_g_logo" class = "p_g_logo">
			<!-- 게임중독 img -->
			
			<!-- 게임중독 설명 -->
			<div id = "p_explanation" class = "p_explanation">
				<p>스스로 게임 행위를 통제할 수 없는 상태를 말한다.</p>
				<p>대체로 인과관계가 명확하게 게임을 가리키지 않고, 오히려 인터넷이나 스마트폰과 같은 다른 원인을 지목하거나, 다른 사회적인 문제가 인과관계로서 접목된다.</p>
				<p>2018년에 들어서 WHO 세계 보건 기구에서 개정안에 등록은 해놓았지만, 이를 확정한 것도 아니며 정확히 정의와 증상조차도 정의하지 못했다.</p>
			</div>
			<!-- 게임중독 설명 -->
			
			<!-- 게임중독 검사 -->
			<div id = "p_inspection" class = "p_inspection">
				<input type = "button" value = "검사" id = "p_g_button" class = "p_g_button">
			</div>
			<!-- 게임중독 검사 -->
		</div>
		<!-- 게임 중독 -->
	</div>
	<!-- content -->
	
	<!-- footer -->
	<div>
		<%@include file = "../footer/footer.jsp" %>
	</div>
	<!-- footer -->
</body>
</html>