<%@page import="dto.Notice"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% List<Notice> list = (List) request.getAttribute("noticeList"); %>    
<%@include file="/WEB-INF/views/admin/admin_header.jsp" %>

<script type="text/javascript" src="http://code.jquery.com/jquery-2.2.4.min/js"></script>

<script>
$(document).ready(function() {
	
	$("#btnWrite").click(function(){
		$(location).attr("href","/admin/noticewrite");
		
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

.totalnotice {
margin-top: 250px;
margin-bottom: 250px;
text-align: center;

}
.admininqList_container {
	width: 80%;
	padding: 30px;
	
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


<div class="admininqList_container">

<h1>공지사항 목록 </h1>
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
	<td><a href="/admin/noticeview?postno=<%=list.get(i).getPostno() %>" ><%=list.get(i).getTitle() %></a></td>
	<td><%=list.get(i).getUserno() %></td>
	<td><%=list.get(i).getCreate_date() %></td>
	<td><%=list.get(i).getHit() %></td>
</tr>
<% } %>
</table>


<div>
<button id="btnWrite" style="float: right;">글쓰기</button>
</div> <!--  버 -->
</div>

</div>



<%@ include file="/WEB-INF/views/board/notice/paging.jsp" %>

