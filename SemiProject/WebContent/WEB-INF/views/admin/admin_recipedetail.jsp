<%@page import="dto.UploadFile"%>
<%@page import="dto.Member"%>
<%@page import="dto.Recipe"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@include file="/WEB-INF/views/admin/admin_header.jsp" %>
<% UploadFile uf = (UploadFile) request.getAttribute("uploadfile"); %>

<style type="text/css">
body { 
    margin:20px auto; 
    padding: 0; 
    padding-top: 80px; 
}
ul#navi {
	margin:20px auto;
    padding: 0;
    font-size:0.9em;
    padding-top: 80px;
    width: 200px;
    text-indent: 10px;
    
    background: #f4f4f4;
    float: left;
    min-height: 700px;
}
ul#navi, ul#navi ul {
    margin:0;
    padding:0;
    list-style:none;
}
li.group {
    margin-bottom: 0;
}
li.group div.title {
    height: 35px;
    line-height: 35px;
    background:#f4f4f4;
    cursor:pointer;
    font-size: 15px;
    font-weight: bolder;
    padding-bottom: 30px;
}
li.group div.maintitle {
    height: 50px;
    line-height: 50px;
    background:#f4f4f4;
    cursor:pointer;
    font-size: 15px;
    font-weight: bolder;
    padding-bottom: 70px;
}
ul.sub li {
    margin-bottom: 0px;
    height:35px;
    line-height:35px;
    background:#f4f4f4;
    cursor:pointer;
}
ul.sub li a {
    display: block;
    width: 100%;
    height:100%;
    text-decoration:none;
    color:#000;
}
ul.sub li:hover {
	background:#FFCC33;
}
</style>



<ul id="navi">
	<li style="height: 50px; padding: 10px;">
    </li>
    <li class="group">
        <div class="title">게시판 관리</div>
       	<ul class="sub">
            <li><a href="/admin/recipelist">전체 레시피 관리</a></li>
            <li><a href="/admin/noticelist">공지사항</a></li>
            <li><a href="/admin/faqlist">FAQ</a></li>
            <li><a href="/admin/inqlist">문의하기</a></li>
       	</ul>
    </li>
    <li class="group">
        <div class="title">데이터 관리</div>
        <ul class="sub">
            <li><a href="/admin/member">회원 관리</a></li>                
        </ul>
    </li>
</ul>


<% Recipe recipe = (Recipe) request.getAttribute("Recipe"); %>
<% List<Member> mList = (List) request.getAttribute("mList"); %>
<% List<UploadFile> fList = (List) request.getAttribute("fileList"); %>



<div id="content" style="height: 613px;">
<table id="detail" class="table" style="marget-top: 250px; width: 83%;">

	<tr>
		<td colspan="4" style="text-align: left;"><%=recipe.getTitle() %></td>
	</tr>
	<tr>
		<td>닉네임</td>
		<td style="width: 450px;">
			<% for(int i=0; i<mList.size(); i++) { %>
			<% if( recipe.getUserno() == mList.get(i).getUserno() ) { %>
			<%=mList.get(i).getNick() %>
			<% } %>
			<% } %>
		</td>
		<td>작성일 : <%=recipe.getCreate_date() %></td>
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

<button id="btnDelete" name="delete" onclick='location.href="/admin/recipedelete?userno=<%=recipe.getUserno() %>&postno=<%=recipe.getPostno() %>";'>삭제</button>
<button id="btnList" name="btnReturn" onclick='location.href="/admin/recipelist";'>목록으로</button>

</div>

<div style="width: 500px; height: 400px">
	<a href="/upload/<%=uf.getStoredName() %>"  download="/upload/<%=uf.getOriginName() %>">
	<img src="/upload/<%=uf.getStoredName() %>" style="width: 500px; height: 334px;" />
	</a>
</div>
<div></div>


<%@include file="/WEB-INF/views/footer/footer.jsp" %>
