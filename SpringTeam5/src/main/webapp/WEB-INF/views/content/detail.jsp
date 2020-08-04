<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="resources/css/css.css">
<script src="http://code.jquery.com/jquery-Latest.js"></script>
<script src="resources/js/header.js"></script>
<script type="text/javascript">
 jQuery(document).ready(function() {
	  if(${sessionScope.MEM_ID == null}) {
        alert("게시판을 이용하시려면 로그인하셔야 합니다.");
        location.href="./Login.do";	// 로그인폼으로 이동
    }
});
 

</script>
</head>
<body>
	<!-- header -->
	<div>
		<%@include file="../header/header.jsp"%>
	</div>
	<table id="detailboard" width="1000" boarder="1">
		<tr>
		<td>${board.BOAR_TITLE}</td>
		</tr>
		<tr>
		<td>${board.MEM_ID}</td>
		</tr>
		<tr>
		<td>${board.BOAR_CONT}</td>
		</tr>
	</table>
	<c:if test="${sessionScope.MEM_ID}">
	<input type="button" value="수정" onClick="./BoardModify.do?BOAR_NO=${BOAR_NO}&page=${page}">
	<input type="button" value="삭제" onClick="./BoardDelete.do?BOAR_NO=${BOAR_NO}&page=${page}">
	<input type="button" value="목록" style="float:right;" onClick="./BoardList.do?page=${page}">
	</c:if>
	<br>
	<br>
	
	<!-- footer -->
	<div>
		<%@include file="../footer/footer.jsp"%>
	</div>
	<!-- footer -->
</body>
</html>