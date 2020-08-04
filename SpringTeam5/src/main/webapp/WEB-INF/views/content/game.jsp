<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="resources/css/check.css">
<script src="http://code.jquery.com/jquery-Latest.js"></script>
<script src="resources/js/check.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>
<body>
	<form action = "./Gamecheck.do" method = "post" class = "gameresult">
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
		
			<c:forEach var="game" items="${gamelist}">
				<tr>
					<th>${game.EXAM_NO}</th>
					<td>${game.EXAM_CONT}</td>
					<th><input type = "radio" name = "select${game.EXAM_NO}" class = "select${game.EXAM_NO}" value = "1"></th>
					<th><input type = "radio" name = "select${game.EXAM_NO}" class = "select${game.EXAM_NO}" value = "2"></th>
					<th><input type = "radio" name = "select${game.EXAM_NO}" class = "select${game.EXAM_NO}" value = "3"></th>
					<th><input type = "radio" name = "select${game.EXAM_NO}" class = "select${game.EXAM_NO}" value = "4"></th>
					<th><input type = "radio" name = "select${game.EXAM_NO}" class = "select${game.EXAM_NO}" value = "5"></th>
				</tr>
			</c:forEach>
			
			<tr>
				<th colspan = "7"><input type = "submit" id = "gameresult" value = "결과 확인">
								<input type = "button" id = "cancel" class = "cancel" value = "취소"></th>
			</tr>
		</table>
	</form>
</body>
</html>