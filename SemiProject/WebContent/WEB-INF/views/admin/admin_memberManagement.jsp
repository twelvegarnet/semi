<%@page import="dto.Member"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%	List<Member> list = (List) request.getAttribute("memList"); %>

<%@include file="/WEB-INF/views/admin/admin_header.jsp" %>

<script type="text/javascript">
$(document).ready(function() {
	
	$(".btnDelMem").click(function() {
		
		if(confirm("[확인]버튼 클릭 시 해당 회원이 삭제되고 되돌릴 수 없습니다.\n 삭제하시겠습니까?")) {
			$(location).attr("href", "/admin/memberdel?userno=" + $(this).attr("data-userno"));
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

.adminmemList_container {
	width: 80%;
	padding: 30px;
	
	float: right;
}

th {
	text-align: center;
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



<div class="adminmemList_container">

<h2>회원 관리</h2>
<br><br>

<table class="table table-striped table-hover table-condensed">
<tr>
	<th>회원번호</th>
	<th>아이디</th>
	<th>이름</th>
	<th>이메일</th>
	<th>등급</th>
	<th>/</th>
</tr>


<%	for(int i = 0; i < list.size(); i++) { %>
<tr>
	<td><%=list.get(i).getUserno() %></td>
	<td><%=list.get(i).getUserid() %></td>
	<td><%=list.get(i).getUsername() %></td>
	<td><%=list.get(i).getEmail() %></td>
	<td><%=list.get(i).getGrade() %></td>
	<td>
		<button type="button" class="btnDelMem" data-userno="<%=list.get(i).getUserno() %>">회원삭제</button>
	</td>
</tr>
<%	} %>
</table>

<!-- .adminmemList_container end -->
</div>


<div class="clearfix"></div>






