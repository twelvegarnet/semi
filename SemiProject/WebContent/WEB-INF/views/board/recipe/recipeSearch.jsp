<%@page import="java.util.List"%>
<%@page import="dto.Member"%>
<%@page import="dto.Recipe"%>
    
<%@include file="/WEB-INF/views/board/recipe/recipeHeader.jsp" %>
    
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<% 	List<Recipe> list = (List) request.getAttribute("List"); %>
<%	List<Member> mList = (List) request.getAttribute("mList"); %>

<style type="text/css">
	a:link {text-decoration: none; color: black;}
	a:visited {text-decoration: none; color: black;}
	a:active {text-decoration: none; color: black;}
	a:hover {text-decoration: underline; color: black;}
</style>

<div style="width: 1200px; height: 807px; margin:0 auto;">
<ul class="nav nav-tabs" style="margin: 10px; margin-top: 100px;">
  <li role="presentation" class="active"><a href="/recipe/list">레시피공유</a></li>
  <li role="presentation"><a href="/notice/list">공지사항</a></li>
  <li role="presentation"><a href="/faq/view">FAQ</a></li>
</ul>

<div id="content" style="height: 445px;">
<table class="table table-hover">
	<tr style="background: #fbf8e3;">
		<th width="5%">글번호</th>
		<th width="65%">제목</th>
		<th width="10%">작성자</th>
		<th width="15%">작성일</th>
		<th width="5%">조회수</th>
	</tr>
	<%
		for(int i=0; i<list.size(); i++) {
	%>
	<tr>
		<td><%=list.get(i).getPostno()%></td>
		<td>
			<a href="/recipe/detail?postno=<%=list.get(i).getPostno()%>">
			<%=list.get(i).getTitle()%>
			</a>
		</td>
		<td><%
			for(int j=0; j<mList.size(); j++){
		%>
				<%
					if( list.get(i).getUserno() == mList.get(j).getUserno() ) {
				%>
				 <%=mList.get(j).getUsername()%>
					<%
						}
					%>
				<%
					}
				%>
		</td>
		<td><%=list.get(i).getCreate_date()%></td>
		<td><%=list.get(i).getViews()%>
	<%
		}
	%>
	</tr>
</table>

<div>
<button class="btn btn-default" style="float: right;" onclick='location.href="/recipe/write";'>글쓰기</button>
</div>

<hr>
<div style="margin-left: 85px;">
<form action="/recipe/search" method="get">
<input type="text" id="search" name="search" style="width: 200px;" />
<button class="btn btn-default" onclick='location.href="/recipe/search";' style="margin-left: 20px;">검색</button>
</form>
</div>
<%@include file="/WEB-INF/views/board/recipe/searchPaging.jsp" %>
</div>
</div>
    
<%@include file="/WEB-INF/views/footer/footer.jsp" %>