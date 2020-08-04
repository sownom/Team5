<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

</script>
</head>
<body>
	<!-- 댓글창(누르면 밑에 댓글입력창과 댓글목록 출력하기) -->
	<c:if test="${not empty MEM_ID}">
	<input type="button" value="댓글(${comm_listcount})" onClick="/content/comment.jsp">
	</c:if>
	<c:if test="${empty comm_list}">
		<br>작성된 댓글이 없습니다.
	</c:if>
	<!-- 댓글쓰는칸 -->
	<input type="hidden" name="MEM_ID" value="${sessionScope.MEM_ID}">
	<input type="hidden" name="BOAR_NO" value="${board.BOAR_NO}">
	<textarea rows="3" cols="50" name = "commtext" placeholder="댓글을 입력해주세요.<br>(비방이나 욕설은 삼가해주시기바랍니다.)" style="width : 100%;" ></textarea>
	<input type="button" value="등록" >
	<!-- 댓글 리스트 -->
	<table>
	<c:forEach var="bd" items="${comment}">
	<tr>
	<td>${bd.MEM_ID}</td>
	<td>${bd.COMM_DATE}</td>
	</tr>
	<tr>
	<td id="td_${bd.BOAR_NO}">${bd.COMM_CONT}</td>
	<td id="bttn_${bd.BOAR_NO}">
	<c:if test="${bd.MEM_ID == board.MEM_ID}">
	<input type="button" value="댓글수정" >
	<input type="button" value="댓글삭제" >
	</c:if>
	</td>
	</tr>
	</c:forEach>
	</table>	
	<!-- 페이징 처리 -->
	<center>
		<c:if test="${comm_listcount > 0 }">
		
		<!-- 첫 댓글페이지 이동 -->
		<a href="./CommList.do?comm_page=1" style="text-decoration: none"> << </a>
		
		<!-- 댓글 이전페이지 -->
		<c:if test="${comm_listcount > 10 }">
			<a href="./commList.do?comm_page=${comm_StartPage - 10}">[이전]</a>
		</c:if>
		
		<c:forEach var="j" begin="${comm_StartPage}" end="${comm_EndPage}">
			<c:if test="${j == comm_page}">
			<!-- 댓글 현재 페이지 -->
		[${j}]
		
	</c:if>
			<c:if test="${j ! = comm_page }">
				<a href="./commList.do?comm_page=${j}">[${j}]</a>
			</c:if>
		</c:forEach>
		
		<!-- 댓글 다음페이지 -->
		<c:if test="${comm_EndPage < comm_listcount}">
			<a href="./commList.do?comm_page=${comm_StartPage + 10}">[다음]</a>
		</c:if>
		
		<!-- 댓글 마지막 페이지 -->	
		<a href="./commList.do?comm_page=${comm_listcount}" style="text-decoration : none">
		 >> </a>
		
		</c:if>
</body>
</html>