<%@page import="java.net.URLEncoder"%>
<%@page import="dto.NoticeFile"%>
<%@page import="dto.Notice"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% Notice list = (Notice) request.getAttribute("viewNotice"); %>
<% NoticeFile noticefile = (NoticeFile) request.getAttribute("noticeFile"); %>

<%@include file="/WEB-INF/views/header/header.jsp" %>

<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js" ></script>

<script>
$(document).ready(function() {
	
	$("#btnList").click(function() {
		$(location).attr("href", "/admin/noticelist");
	});
	
	$("#btnUpdate").click(function() {
		$(location).attr("href", "/admin/noticeupdate?postno=<%=list.getPostno() %>");
	});
	
	$("#btnDelete").click(function() {
		$(location).attr("href", "/admin/noticeDelete?postno=<%=list.getPostno() %>");
		
		
	});
	
});

</script>


<div class="table" style="height: 548px;">
<h1>공지사항 상세보기 </h1>

<div>
<table style="margin-top: 40px; margin-left: 13%; width:80%;">
<tr>
<td class="table-warning">글제목 </td><td colspan=5><%=list.getTitle() %></td>
</tr>

<tr>
<td width="13%" class="table-warning">글번호 </td><td colspan=5><%=list.getPostno() %></td>
<td width="19%" class="table-warning">작성 날짜 </td><td width="25%"><%=list.getCreate_date() %></td>
<td width="16%" class="table-warning">조회수 </td><td><%=list.getHit() %></td>
</tr>



<tr>
<td colspan=10>글내용 </td>
</tr>

<tr>
<td colspan=10><%=list.getInq_content() %></td>
</tr>

<tr>
<td>첨부파일 </td><td><a href="/upload/<%=noticefile.getStoredName() %>" download="<%=noticefile.getOriginName() %>"><img src="/upload/<%=noticefile.getStoredName() %>"></a></td>
</tr>


</table>
</div>

<div>
<button id="btnList">목록 </button>
<button id="btnUpdate">수정 </button>
<button id="btnDelete">삭제 </button>
</div>

</div>


<%@include file="/WEB-INF/views/footer/footer.jsp" %>