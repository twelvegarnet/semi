<%@page import="dto.Inquiry"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%	List<Inquiry> list = (List) request.getAttribute("inquiryList"); %>

<%	Inquiry inq = (Inquiry) request.getAttribute("nick"); %>
    
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

.admininqList_container {
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




<div class="admininqList_container">

<h2>회원 문의내역</h2>
<br><br>

<div>
<table class="table table-striped table-hover table-condensed">
<tr>
	<th style="width: 10%;">문의번호</th>
	<th style="width: 50%;">제목</th>
	<th style="width: 15%;">작성자</th>
	<th style="width: 15%;">작성일</th>
</tr>

<%	for(int i = 0; i < list.size(); i++) { %>
<tr>
	<td><%=list.get(i).getInquiryno() %></td>
	<td>
		<a href="/admin/inqview?inquiryno=<%=list.get(i).getInquiryno() %>">
		<%=list.get(i).getTitle() %>
		</a>
	</td>
	<td><%=list.get(i).getNick() %></td>
	<td><%=list.get(i).getCreateDate() %></td>
</tr>
<%	} %>
</table>
</div>

<!-- .inqList_container end -->
</div>


<div class="clearfix"></div>

<%@include file="/WEB-INF/views/admin/admin_inquiryPaging.jsp" %>





