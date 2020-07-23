<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/css.css">
<script src="http://code.jquery.com/jquery-Latest.js"></script>
<script src="<%=request.getContextPath()%>/js/header.js"></script>
</head>
<body>
	<!-- header -->
	<div>
		<%@include file="../header/header.jsp"%>
	</div>
	<!-- header -->
	<input type="button" value="글쓰기" align="right">
	<table border=1 width="300" height="500" align="center">
		<h4>게시판목록</h4>
		<tr>번호
		</tr>
		<tr>제목
		</tr>
		<tr>작성자
		</tr>
		<tr>작성일
		</tr>
		<tr>조회
		</tr>
		<c:if test="${empty boardlist}">
			작성된 게시글이 없습니다.
			<br>
			<input type="button" value=글쓰기 onClick="./BoardWrite.do">
		</c:if>
		<c:forEach var="board" items="${boardlist}">
			<tr>
				<td>${board.BOARD_NO}</td>
				<td><a href="./BoardDetail.do?BOAR_NO=${BOAR_NO}&page=${page}">${board.BOAR_TITLE}</a></td>
				<td>${board.MEM_ID}</td>
				<td>${board.BOAR_TIME}</td>
				<td>${board.BOAR_COUN}</td>
			</tr>
		</c:forEach>
		
		<br>
		<!-- 페이징 처리 -->
		<center>
			<c:if test="${listcount > 0}">

				<!-- 첫페이지 이동-->
				<a href="./BoardList.do?page=1" style="text-decoration: none">
					<< </a>

				<!-- 이전 페이지 -->
				<c:if test="${listcount > 10 }">
					<a href="./BoardList.do?page=${startPage-10}"> [이전] </a>
				</c:if>

				<c:forEach var="i" begin="${Start}" end="${End}">
					<c:if test="${i == page}">
						<!-- 현재 페이지 -->
		[${i}]	
	</c:if>
					<c:if test="${i != page}">
						<a href="./BoardList.do?page=${i}"> [${i}] </a>
					</c:if>
				</c:forEach>

				<!-- 다음 블럭 이동 -->
				<c:if test="${End < limit}">
					<a href="./BoardList.do?page=${startPage+10}"> [다음] </a>
				</c:if>

				<!-- 마지막 페이지 이동-->
				<a href="./BoardList.do?page=${limit}" style="text-decoration: none">
					>> </a>
			</c:if>
			<!-- 검색 -->
			<form>
				<select name="op">
					<option value="0">제목</option>
					<option value="1">내용</option>
					<option value="2">제목+내용</option>
					<option value="3">아이디</option>
				</select>
				<input type="text" size="20" name="search">&nbsp;
				<input type="submit" value="검색">
			</form>

		</center>
	</table>
	<!-- footer -->
	<div>
		<%@include file="../footer/footer.jsp"%>
	</div>
	<!-- footer -->
</body>
</html>