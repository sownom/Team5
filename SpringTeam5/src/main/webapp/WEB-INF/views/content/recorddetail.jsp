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
	<div id = "mr_main" class = "mr_main">
		<c:set target = "${recordlist}" property = "PSYC_GRADE" value = "${recordlist.PSYC_GRADE}"/>
		<c:set target = "${recordlist}" property = "DETI_CONT" value = "${recordlist.DETI_CONT}"/>
		<c:out value = "${recordlist.PSYC_GRADE}"/><br>
		<c:out value = "${recordlist.DETI_CONT}"/><br>
	</div>
	<!-- content -->
	
	<!-- footer -->
	<div>
		<%@include file = "../footer/footer.jsp" %>
	</div>
	<!-- footer -->
</body>
</html>