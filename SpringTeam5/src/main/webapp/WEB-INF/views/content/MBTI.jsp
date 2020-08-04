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
	<form action = "./MBTIcheck.do" method = "post" class = "MBTIresult">
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
			
			<c:set var = "sum" value = "0"/>
			
			<c:forEach var="MBTI" items="${MBTIlist}">
				<tr>
					<c:choose>
						<c:when test="${sum % 2 == 0}">
							<th rowspan ="2">${MBTI.EXAM_NO}</th>
							<td>${MBTI.EXAM_CONT}</td>
							<th><input type = "radio" name = "select${MBTI.EXAM_NO}" class = "select${MBTI.EXAM_NO}" value = "11"></th>
							<th><input type = "radio" name = "select${MBTI.EXAM_NO}" class = "select${MBTI.EXAM_NO}" value = "12"></th>
							<th><input type = "radio" name = "select${MBTI.EXAM_NO}" class = "select${MBTI.EXAM_NO}" value = "13"></th>
							<th><input type = "radio" name = "select${MBTI.EXAM_NO}" class = "select${MBTI.EXAM_NO}" value = "14"></th>
							<th><input type = "radio" name = "select${MBTI.EXAM_NO}" class = "select${MBTI.EXAM_NO}" value = "15"></th>
							<c:set var = "sum" value = "${sum + 1}"/>
						</c:when>
						<c:when test="${sum % 2 == 1}">
							<td>${MBTI.EXAM_CONT}</td>
							<th><input type = "radio" name = "select${MBTI.EXAM_NO}" class = "select${MBTI.EXAM_NO}" value = "21"></th>
							<th><input type = "radio" name = "select${MBTI.EXAM_NO}" class = "select${MBTI.EXAM_NO}" value = "22"></th>
							<th><input type = "radio" name = "select${MBTI.EXAM_NO}" class = "select${MBTI.EXAM_NO}" value = "23"></th>
							<th><input type = "radio" name = "select${MBTI.EXAM_NO}" class = "select${MBTI.EXAM_NO}" value = "24"></th>
							<th><input type = "radio" name = "select${MBTI.EXAM_NO}" class = "select${MBTI.EXAM_NO}" value = "25"></th>
							<c:set var = "sum" value = "${sum + 1}"/>
						</c:when>
					</c:choose>
				</tr>
			</c:forEach>
			
			<tr>
				<th colspan = "7"><input type = "submit" id = "MBTIresult" value = "결과 확인">
								<input type = "button" id = "cancel" class = "cancel" value = "취소"></th>
			</tr>
		</table>
	</form>
</body>
</html>