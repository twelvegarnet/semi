<%@page import="dto.UploadFile"%>
<%@page import="java.util.List"%>
<%@page import="dto.Member"%>
<%@page import="dto.Recipe"%>

<%@include file="/WEB-INF/views/board/recipe/recipeHeader.jsp" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<% Recipe recipe = (Recipe) request.getAttribute("Recipe"); %>
<% List<Member> mList = (List) request.getAttribute("mList"); %>
<% List<UploadFile> fList = (List) request.getAttribute("fileList"); %>
<% UploadFile uf = (UploadFile) request.getAttribute("uploadfile"); %>

<style type="text/css">


tr, td {
	border-color: white;
}
</style>

<div style="width: 1200px; height: 807px; margin:0 auto;">
<div id="content" style="height: 613px;">
<table id="detail" class="table" style="marget-top: 200px;">

	<tr>
		<td colspan="4" style="border: white; text-align: left;"><h3><%=recipe.getTitle() %></h3></td>
	</tr>
	<tr>
		<td style="border: white;">닉네임</td>
		<td style="border: white; width: 450px;">
			<% for(int i=0; i<mList.size(); i++) { %>
			<% if( recipe.getUserno() == mList.get(i).getUserno() ) { %>
			<%=mList.get(i).getNick() %>
			<% } %>
			<% } %>
		</td>
		<td style="border: white;">작성일 : <%=recipe.getCreate_date() %></td>
		<td style="border: white;">조회수 : <%=recipe.getViews() %></td>
	</tr>
	<tr>
		<td colspan="4" style="height: 300px; text-align: left;"><%=recipe.getInq_content() %></td>
	</tr>
	<tr style="border: white;">
		<td>첨부파일</td>
		<td colspan="3">
			<% for(int j=0; j<fList.size(); j++) {%>
				<% if( recipe.getPostno() == fList.get(j).getPostno() ){%>
					<%=fList.get(j).getStoredName() %>
				<% } %>
			<% } %>
		</td>
	</tr>
</table>
<hr>

<button id="btnUpdate" name="update" onclick='location.href="/recipe/update?userno=<%=recipe.getUserno() %>&postno=<%=recipe.getPostno() %>";'>수정</button>
<button id="btnDelete" name="delete" onclick='location.href="/recipe/delete?userno=<%=recipe.getUserno() %>&postno=<%=recipe.getPostno() %>";'>삭제</button>
<button id="btnList" name="btnReturn" onclick='location.href="/recipe/list";'>목록으로</button>

<div style="width: 300px; height: 200px">
	<a href="/upload/<%=uf.getStoredName() %>"  download="/upload/<%=uf.getOriginName() %>">
	<img src="/upload/<%=uf.getStoredName() %>" style="width: 300px; height: 200px;" />
	</a>
</div> 
</div>

</div>

<%@include file="/WEB-INF/views/footer/footer.jsp" %>