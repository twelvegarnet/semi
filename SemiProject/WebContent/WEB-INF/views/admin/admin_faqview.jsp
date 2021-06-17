<%@page import="dto.Faq"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% Faq v = (Faq) request.getAttribute("adminView"); %>

<%@include file="/WEB-INF/views/admin/admin_header.jsp" %>

<script type="text/javascript">

$(document).ready(function() {
	
	//목록 버튼 클릭 시
	$("#btnList").click(function() {
		$(location).attr("href", "/admin/faqlist");
	});
	
	//수정 버튼 클릭 시
	$("#btnUpdate").click(function() {
		location.href = "/admin/faqupdate?postno=<%=v.getPostno() %>"
		
	});

	//삭제 버튼 클릭 시
	$("#btnDelete").click(function() {
		if(confirm("[확인]을 누르시면 되돌릴 수 없습니다. 삭제하시겠습니까?") ) {
			$(location).attr("href", "/admin/faqdelete?postno=<%=v.getPostno()%>");
		}
	});
});	

</script>

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

.adminfaqView_container {
	width: 80%;
	float: right;
	
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

<div class="adminfaqView_container">


<h1>FAQ 관리자페이지 상세보기</h1>
<hr>

<table class="table table-bordered" >
<tr>
<td class="warning">게시물번호</td><td style="width: 25%;"><%=v.getPostno() %></td>
<td class="warning">작성날짜</td><td><%=v.getCreate_date() %></td>
</tr>

<tr>
<td class="warning">제목</td><td colspan="3"><%=v.getTitle() %></td>
</tr>


<tr>
<td class="warning" colspan="4">문의내용</td>
</tr>
<tr>
<td colspan="4" style="height: 200px;"><%=v.getInq_content() %></td>
</tr>
</table>

<div class="text-center">	
	<button id="btnList" class="btn btn-primary">목록</button>
	<button id="btnUpdate" class="btn btn-info">수정</button>
	<button id="btnDelete" class="btn btn-danger">삭제</button>
</div>

</div>

<div class="clearfix"></div>



