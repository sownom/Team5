<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="resources/css/check.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script src="http://code.jquery.com/jquery-Latest.js"></script>
<script src="resourcesjs/check.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

</head>
<body>
	<form action = "./Alcoholcheck.do" method = "post" class = "alcoholresult" >
		<table>
			<tr>
				<th id = "question">문항</th>
				<th id = "contents">내용</th>
				<th id = "never">전혀없었다</th>
				<th id = "almost">거의없었다</th>
				<th id = "sometimes">때때로있었다</th>
				<th id = "often">자주있었다</th>
				<th id = "extremely">매우자주있었다.</th>
			</tr>
		
			<c:forEach var="alcohol" items="${alcohollist}">
				<tr>
					<th>${alcohol.EXAM_NO}</th>
					<td>${alcohol.EXAM_CONT}</td>
					<th><input type = "radio" name = "select${alcohol.EXAM_NO}" class = "select${alcohol.EXAM_NO}" value = "1"></th>
					<th><input type = "radio" name = "select${alcohol.EXAM_NO}" class = "select${alcohol.EXAM_NO}" value = "2"></th>
					<th><input type = "radio" name = "select${alcohol.EXAM_NO}" class = "select${alcohol.EXAM_NO}" value = "3"></th>
					<th><input type = "radio" name = "select${alcohol.EXAM_NO}" class = "select${alcohol.EXAM_NO}" value = "4"></th>
					<th><input type = "radio" name = "select${alcohol.EXAM_NO}" class = "select${alcohol.EXAM_NO}" value = "5"></th>
				</tr>
			</c:forEach>
			
			<tr>
				<th colspan = "7"><input type = "submit" id = "alcoholresult" value = "결과 확인">
								<input type = "button" id = "cancel" class = "btn btn-danger" value = "취소"></th>
			</tr>
		</table>
	</form>
</body>
</html>