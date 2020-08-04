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
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>
<body>
	<!-- header -->
	<div>
		<%@ include file = "../header/header.jsp" %>
	</div>
	<!-- header -->
	
	<!-- content -->
	<div id = "m_main" class = "m_main">
		<!-- 이미지 변경 -->
		<div id = "m_image" class = "m_image">
			<img src = "resources/image/m_image1.jpg" id = "m_image1" class = "m_image1">
			<img src = "resources/image/m_image2.jpg" id = "m_image2" class = "m_image2">
			<img src = "resources/image/m_image3.jpg" id = "m_image3" class = "m_image3">
		</div>
		<!-- 이미지 변경 -->
		
		<!-- 심리검사 -->
		<div id = "m_point" class = "m_point">
			<p>심리검사는 사람들의 행동(사고, 감정, 행위)을 표본추출을 통해 얻어진 결과를 표준화시켜 비교하는 체계적 과정이다. 임상심리학(clinical psychology) 및 심리평가(psychological assessment) 분야에서 담당하고 있다.

다양한 검사도구들을 상호 보완적으로 사용하여 수검자의 데이터를 수집하기도 하는데, 오늘날에는 이처럼 다수의 검사도구들을 동원하는 것이 대다수이다. 이를 "총집"(full battery)이라고도 한다.</p>
		</div>
		<!-- 심리검사 -->
		
		<!-- 간단한 자가 진단 -->
		<div id = "m_self" class = "m_self">
			<img src = "resources/image/m_diagnosis.jpg" id = "m_selfimg" class = "m_selfimg">
		</div>
		<!-- 간단한 자가 진단 -->
	</div>
	<!-- content -->
	
	<!-- footer -->
	<div>
		<%@include file = "../footer/footer.jsp" %>
	</div>
	<!-- footer -->
</body>
</html>