<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel = "stylesheet" href="<%=request.getContextPath() %>/css/css.css">
<script src = "http://code.jquery.com/jquery-Latest.js"></script>
<script src="<%=request.getContextPath() %>/js/header.js"></script>
</head>
<body>
	<!-- header -->
	<div>
		<%@include file = "../header/header.jsp" %>
	</div>
	<!-- header -->
	
	<!-- content -->
	<div id = "b_ajax" class = "b_ajax">
		
	</div>
	
	<div id = "b_main" class = "b_main">
		
	</div>
	
	<div id = "b_check" class = "b_check">
		
	</div>
	<!-- content -->
	
	<!-- footer -->
	<div>
		<%@include file = "../footer/footer.jsp" %>
	</div>
	<!-- footer -->
</body>
</html>