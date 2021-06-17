<%@page import="dto.Recipe"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/header/header.jsp" %>


<style type="text/css">
body { 
    margin:20px auto; 
    padding: 0; 
    padding-top: 80px; 
}
    ul#navi {
        width: 200px;
        text-indent: 10px;
        margin:20px auto;
        padding: 0;
        font-size:0.9em;
        padding-top: 80px;
        
        background: #f4f4f4;
     	float: left;
    	min-height: 800px;
        
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

<% List<Recipe> rlist = (List) request.getAttribute("rList"); %>
<% List<Recipe> list = (List) request.getAttribute("list"); %>

<ul id="navi">
	
	<li class="group">
            <div class="maintitle">나의맛객</div>
        </li>
        <li class="group">
            <div class="title">My페이지</div>
            <ul class="sub">
                <li><a href="/mypage/review"">내가 작성한 후기</a></li>
                <li><a href="/mypage/recipelist">내가 작성한 레시피</a></li>
            </ul>
        </li>
        <li class="group">
            <div class="title">MY혜택</div>
            <ul class="sub">
                <li><a href="/payment">프리미엄 가입하기</a></li>                
                <li><a href="/payment/service">프리미엄 혜택보기</a></li>                
            </ul>
        </li>
        <li class="group">
            <div class="title">MY 활동</div>
            <ul class="sub">
                <li><a href="/mypage/inqwrite">문의하기</a></li>                
                <li><a href="/mypage/inqlist">문의내역 확인</a></li>    
            </ul>
        </li>        
    	<li class="group">
            <div class="title">MY 회원정보</div>
            <ul class="sub">
                <li><a href="/member/chg">회원정보 변경/탈퇴</a></li>                
            </ul>
        </li>        
</ul>

<div style="font-size: large; text-align: left; margin-top: 20px; padding-left: 225px;">내가 작성한 레시피</div>
<hr style="border: 0; height: 1px; background: black;">

<div id="content" style="height: 714px;">
<table style="height: 50px; margin-right: 0; width: 75%; margin-left: 250px;">
	<tr>
		<td style="width: 45%; border-right: 40px solid white; background: #fbf8e3;">
		<%=request.getSession().getAttribute("usernick") %>님
		</td>
		<td style="width: 45%; background: #fbf8e3;">
		내가 작성한 레시피 수 : 
		<% int res = 0; %>
			<% for(int i=0; i<list.size(); i++) { %>
				<% res++; %>
			<% } %>
		<%=res %>
		</td>
	</tr>
</table>
<table class="table table-hover" style="width: 83%; margin-top: 20px;">
	<tr class="active">
		<th style="text-align: center; width: 15%;">글 번호</th>
		<th style="text-align: center; width: 55%;">제목</th>
		<th style="text-align: center; width: 15%;">작성일</th>
		<th style="text-align: center; width: 15%;">조회수</th>
	</tr>
	<% for(int i=0; i<rlist.size(); i++) { %>
	<tr>
		<td><%=rlist.get(i).getPostno() %></td>
		<td><a href="/mypage/recipedetail?postno=<%=rlist.get(i).getPostno() %>"><%=rlist.get(i).getTitle() %></a></td>
		<td><%=rlist.get(i).getCreate_date() %></td>
		<td><%=rlist.get(i).getViews() %></td>
	</tr>
	<% } %>
</table>
<%@include file="/WEB-INF/views/mypage/mypage_recipepaging.jsp" %>
</div>


<%@include file="/WEB-INF/views/footer/footer.jsp" %>