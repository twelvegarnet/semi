<%@page import="review.dto.BoardFile"%>
<%@page import="review.dto.Review"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%	Review r = (Review) request.getAttribute("viewReview"); %>
<%	BoardFile boardFile = (BoardFile) request.getAttribute("boardFile"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- jQuery 2.2.4 -->
<script type="text/javascript" src="http://code.jquery.com/jquery-2.2.4.min.js"></script>

<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<script type="text/javascript">
$(document).ready(function() {
	//목록버튼 동작
	$("#btnList").click(function() {
		$(location).attr("href", "/review/list");
	});
	
	//수정버튼 동작
	$("#btnUpdate").click(function() {
		$(location).attr("href", "/review/update?reviewno=<%=r.getReviewno() %>");
	});

	//삭제버튼 동작
	$("#btnDelete").click(function() {
		
		if( confirm("게시글을 삭제하시겠습니까?") ) {
			$(location).attr("href", "/review/review?reviewno=<%=r.getReviewno() %>");
		}
		
	});
	
});
</script>
</head>
<style>

</style>
<body>
<br>
<h2 style="text-align:center">리뷰 상세</h2>
<br>
<div class="text-center">	
	<button id="btnList" class="btn btn-warning">목록</button>
	<button id="btnUpdate" class="btn btn-warning">수정</button>
	<button id="btnDelete" class="btn btn-warning">삭제</button>
</div>
<br>
<div class="container">
<table class="table table-bordered">
<tr>
<td class="info" style="background-color: #FAA600; width: 100px;">글번호</td><td colspan="3"><%=r.getReviewno() %></td>
</tr>
<tr>
<td class="info" style="background-color: #FAA600;">제목</td><td colspan="3"><%=r.getTitle() %></td>
</tr>
<tr>
<td class="info" style="background-color: #FAA600;">회원번호</td><td><%=r.getUserno() %></td>
<%-- <td class="info">닉네임</td><td><%=request.getAttribute("nick") %></td> --%>
</tr>
<tr>
<td class="info" style="background-color: #FAA600;">작성일</td><td colspan="3"><%=r.getCreate_date()%></td>
</tr>
<tr>
<td class="info" style="background-color: #FAA600;">별점</td><td colspan="3"><%=r.getStar_score() %></td>
</tr>
<tr><td class="info" style="background-color: #FAA600;"  colspan="4">본문</td></tr>
<tr><td colspan="4"><%=r.getInq_content() %></td></tr>

</table>
<div>
<%	if( boardFile != null ) { %>

<a href="/upload/<%=boardFile.getStoredName() %>"
 download="<%=boardFile.getOriginName() %>">
	<%=boardFile.getOriginName() %>
</a>

<%	} %>
</div>
</div>

</body>
</html>