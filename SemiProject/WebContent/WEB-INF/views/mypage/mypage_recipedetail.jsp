<%@page import="dto.UploadFile"%>
<%@page import="dto.Member"%>
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
</style>


<% Recipe recipe = (Recipe) request.getAttribute("Recipe"); %>
<% List<Member> mList = (List) request.getAttribute("mList"); %>
<% List<UploadFile> fList = (List) request.getAttribute("fileList"); %>
<% UploadFile uf = (UploadFile) request.getAttribute("uploadfile"); %>

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

<!--  -->

<div style="font-size: large; text-align: left; margin-top: 20px; padding-left: 225px;">상세보기</div>
<hr style="border: 0; height: 1px; background: black;">

<div id="content" style="height: 714px;">
<table id="detail" class="table" style="marget-top: 200px; width: 83%;">

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
		<td>조회수 : <%=recipe.getViews() %></td>
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

<button id="btnUpdate" name="update" onclick='location.href="/mypage/recipeupdate?userno=<%=recipe.getUserno() %>&postno=<%=recipe.getPostno() %>";'>수정</button>
<button id="btnDelete" name="delete" onclick='location.href="/mypage/recipedelete?userno=<%=recipe.getUserno() %>&postno=<%=recipe.getPostno() %>";'>삭제</button>
<button id="btnList" name="btnReturn" onclick='location.href="/mypage/recipelist";'>목록으로</button>

<div style="width: 305px; height: 205px; margin-left :200px">
	<a href="/upload/<%=uf.getStoredName() %>"  download="/upload/<%=uf.getOriginName() %>">
	<img src="/upload/<%=uf.getStoredName() %>" style="width: 300px; height: 200px;" />
	</a>
</div> 
</div>



<%@include file="/WEB-INF/views/footer/footer.jsp" %>