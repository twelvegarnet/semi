<%@page import="dto.Notice"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% Notice list = (Notice) request.getAttribute("viewNotice"); %>
<%@include file="/WEB-INF/views/board/notice/noticeheader.jsp" %>



<ul class="nav nav-tabs" style="margin: 10px; margin-top: 100px;">
  <li role="presentation"><a href="/recipe/list">레시피공유</a></li>
  <li role="presentation" class="active"><a href="/notice/list">공지사항</a></li>
  <li role="presentation"><a href="/faq/view">FAQ</a></li>
</ul>



<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js" ></script>

<script>
$(document).ready(function() {
	
	$("#btnList").click(function() {
		$(location).attr("href", "/notice/list");
	});
	
});

</script>

<style>

.list {
	bottom: 200px;
	left:200px;
	position: relative;
}


</style>


<div class="table" style="height: 548px;">

<div class="table ">

<table style="margin-top: 40px; margin-left: 13%; width:80%;">
<tr>
<th class="table-warning">글제목 </th><td colspan=5><%=list.getTitle() %></td>
</tr>

<tr>
<th width="13%" class="table-warning"  align=left valign=middle>글번호 </th><td  width="15%"><%=list.getPostno() %></td>
<td width="19%" class="table-warning">작성 날짜 </td><td width="25%"><%=list.getCreate_date() %></td>
<td width="16%" class="table-warning">조회수 </td><td><%=list.getHit() %></td>
</tr>

<tr>
<td colspan=6 align="left" valign="middle">글내용 </td>
</tr>

<tr>
<td colspan=6><%=list.getInq_content() %></td>
</tr>

</table>
</div>

<div>
<button id="btnList" class="btn btn-warning" class="list" style="float: right;  ">목록 </button>
</div>

</div>


<%@include file="/WEB-INF/views/footer/footer.jsp" %>