<%@page import="dto.Notice"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% List<Notice> list = (List) request.getAttribute("noticeList"); %>    
<%@include file="/WEB-INF/views/board/notice/noticeheader.jsp" %>



<ul class="nav nav-tabs" style="margin: 10px; margin-top: 100px;">
  <li role="presentation"><a href="/recipe/list">레시피공유</a></li>
  <li role="presentation" class="active"><a href="/notice/list">공지사항</a></li>
  <li role="presentation"><a href="/faq/view">FAQ</a></li>
</ul>




<style>




</style>

<div id="content" style="height: 548px;">
<div class ="table table-hover">

<table style="margin-top: 40px; margin-left: 10px; width:95%;">
<tr>
	<th width="8%" class="table-warning">글번호 </th>
	<th width="62%" class="table-warning">글제목 </th>
	<th width="10%" class="table-warning">사용자번호 </th>
	<th width="12%" class="table-warning">작성 날짜 </th>
	<th width="8%" class="table-warning"> 조회수 </th>
</tr>
<% for(int i=0; i<list.size(); i++) { %>
<tr>
	<td><%=list.get(i).getPostno() %></td>
	<td><a href="/notice/view?postno=<%=list.get(i).getPostno() %>" ><%=list.get(i).getTitle() %></a></td>
	<td><%=list.get(i).getUserno() %></td>
	<td><%=list.get(i).getCreate_date() %></td>
	<td><%=list.get(i).getHit() %></td>
</tr>
<% } %>
</table>

</div>
</div>


<%@ include file="/WEB-INF/views/board/notice/paging.jsp" %>

<%@ include file="/WEB-INF/views/footer/footer.jsp" %>