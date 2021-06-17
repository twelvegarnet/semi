<%@page import="common.PagingReview"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	PagingReview paging = (PagingReview) request.getAttribute("paging");
%>
<style>
.my.pagination > .active > a, 
.my.pagination > .active > span, 
.my.pagination > .active > a:hover, 
.my.pagination > .active > span:hover, 
.my.pagination > .active > a:focus, 
.my.pagination > .active > span:focus {
  background: #FAA600;
  border-color: #FAA600;
}
</style>

<div class="text-center">
	<ul class="pagination my">
	
		<!-- 첫 페이지로 이동 -->
		<%	if(paging.getCurPage() != 1) { //첫 페이지가 아닐 때 보임 %>
		<li><a data-curpage="1" href="/review/list">&larr;</a></li>
		<%	} %>
		
		
		
		
		<!-- 이전 페이징 리스트로 가기 -->
		<%	if(paging.getStartPage() > paging.getPageCount()) { %>
		<li><a data-curpage="<%=paging.getStartPage() - paging.getPageCount() %>" href="/review/list?curPage=<%=paging.getStartPage() - paging.getPageCount() %>">&laquo;</a></li>
		<%	} else { %>
		<li class="disabled"><a>&laquo;</a></li>
		<%	} %>
		
		
		
		
		<!-- 이전 페이지로 가기 -->
		<%	if(paging.getCurPage() != 1) { %>
		<li><a data-curpage="<%=paging.getCurPage() - 1 %>" href="/review/list?curPage=<%=paging.getCurPage() - 1 %>">&lt;</a></li>
		<%	} %>
		
		
		
		
		<!-- 페이징 리스트 -->
		<%	for(int i=paging.getStartPage(); i<=paging.getEndPage(); i++) { %>
		<%		if( i == paging.getCurPage() ) { %>
		<li class="active"><a data-curpage="<%=i %>" href="/review/list?curPage=<%=i %>"><%=i %></a></li>
		<%		} else { %>
		<li><a data-curpage="<%=i %>" href="/review/list?curPage=<%=i %>"><%=i %></a></li>
		<%		} %>
		<%	} %>
		



		<!-- 다음 페이지로 가기 -->
		<%	if(paging.getCurPage() != paging.getTotalPage()) { %>
		<li><a data-curpage="<%=paging.getCurPage() + 1 %>" href="/review/list?curPage=<%=paging.getCurPage() + 1 %>">&gt;</a></li>
		<%	} %>




		<!-- 다음 페이징 리스트로 가기 -->
		<li><a data-curpage="<%=paging.getStartPage() + paging.getPageCount() %>" href="/review/list?curPage=<%=paging.getStartPage() + paging.getPageCount() %>">&raquo;</a></li>

		<!-- 마지막 페이지로 가기 -->
		<% if(paging.getCurPage() !=paging.getTotalPage()) { %>
		<li><a data-curpage="<%=paging.getTotalPage() %>" href="/review/list?curPage=<%=paging.getTotalPage() %>">&rarr;</a><li>
		<%	} %>
	</ul>
</div>

