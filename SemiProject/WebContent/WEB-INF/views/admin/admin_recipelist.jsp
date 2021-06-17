<%@page import="dto.Member"%>
<%@page import="dto.Recipe"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@include file="/WEB-INF/views/admin/admin_header.jsp" %>


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

a:link {text-decoration: none; color: black;}
a:visited {text-decoration: none; color: black;}
a:active {text-decoration: none; color: black;}
a:hover {text-decoration: underline; color: black;}
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

<% List<Recipe> list = (List) request.getAttribute("List"); %>
<% List<Member> mList = (List) request.getAttribute("mList"); %>

<div style="font-size: large; text-align: left; margin-top: 20px; padding-left: 225px;">레시피 게시글 관리</div>
<hr style="border: 0; height: 1px; background: black;">

<div id="content" style="height: 548px;">
<table class="table table-hover" style="width: 83%;">
	<tr class="active">
		<th style='text-align: center; width="8%"'>글번호</th>
		<th style='text-align: center; width="67%"'>제목</th>
		<th style='text-align: center; width="10%"'>작성자</th>
		<th style='text-align: center; width="15%"'>작성일</th>
	</tr>
	<%	for(int i=0; i<list.size(); i++) { %>
	<tr>
		<td><%=list.get(i).getPostno() %></td>
		<td>
			<a href="/admin/recipedetail?postno=<%=list.get(i).getPostno() %>">
			<%=list.get(i).getTitle() %>
			</a>
		</td>
		<td><% for(int j=0; j<mList.size(); j++){ %>
				<% if( list.get(i).getUserno() == mList.get(j).getUserno() ) { %>
				 <%=mList.get(j).getUsername() %>
					<% } %>
				<% } %>
		</td>
		<td><%=list.get(i).getCreate_date() %></td>
	<%	} %>
	</tr>
</table>
<hr>
</div>

<%@include file="/WEB-INF/views/admin/admin_recipepaging.jsp" %>

<%@include file="/WEB-INF/views/footer/footer.jsp" %>