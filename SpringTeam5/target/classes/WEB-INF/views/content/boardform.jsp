<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="resources/css/css.css">
<script src="http://code.jquery.com/jquery-Latest.js"></script>
<script src="resources/js/header.js"></script>
</head>
<body>
<form action="./BoardWrite.do" method="post">
<h4>글 양식</h4>
<table align="center" border=1>

<tr>
<td>아이디</td>
<td>${sessionScope.MEM_ID}</td>
</tr> 

<tr>
	<td>제목</td>
	<td><input name="BOAR_TITLE" id="BOAR_TITLE" type="text" size="50" maxlength="100" ></td>
</tr>
<tr>
	<td>내용</td>
	<td><textarea name="BOAR_CONT" id="BOAR_CONT" clos="5" rows="40"></textarea></td>
</tr>
<br><br>
</table>
<input type="submit" value="등록">
<input type="reset" value="취소">
<input type="button" value="목록" onClick="./BoardList.do">
</form>

</table>
	<!-- footer -->
	<div>
		<%@include file="../footer/footer.jsp"%>
	</div>
	<!-- footer -->
</body>
</html>