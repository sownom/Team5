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
		<table>
			<c:forEach var = "record" items = "${recordlist}">
				<tr>
					<td><a href = "./Recorddetail.do?no=${record.PSYC_NO}&grade=${record.DETI_GRADE}">${record.PSYC_TYPE}</a></td>
					<td>${record.RECO_TIME}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<!-- content -->
	
	<!-- footer -->
	<div>
		<%@include file = "../footer/footer.jsp" %>
	</div>
	<!-- footer -->
</body>
</html>