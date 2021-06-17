<%@page import="java.util.List"%>
<%@page import="dto.Inquiry"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%	List<Inquiry> list = (List) request.getAttribute("inquiryList"); %>

<%	Inquiry inq = (Inquiry) request.getAttribute("nick"); %>

<%@include file="/WEB-INF/views/header/header.jsp" %>

<script type="text/javascript">
$(document).ready(function() {
	
	$("#btnWriteInq").click(function() {
		$(location).attr("href", "/mypage/inqwrite");
	});
	
});
</script>


<style>
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
    min-height: 600px;
        
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


.inqList_container {
	width: 80%;
	padding: 30px;
	
	float: right;
}

th {
	text-align: center;
}

</style>



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



<div class="inqList_container">

<h2>내 문의내역</h2>
<br><br>

<div>
<table class="table table-striped table-hover table-condensed">
<tr>
	<th style="width: 10%;">문의번호</th>
	<th style="width: 50%;">제목</th>
	<th style="width: 15%;">작성자</th>
	<th style="width: 15%;">작성일</th>
</tr>

<%	for(int i = 0; i < list.size(); i++)  { %>
<tr>
	<td><%=list.get(i).getInquiryno() %></td>
	<td>
		<a href="/mypage/inqview?inquiryno=<%=list.get(i).getInquiryno() %>">
		<%=list.get(i).getTitle() %>
		</a>
	</td>
	<td><%=list.get(i).getNick() %></td>
	<td><%=list.get(i).getCreateDate() %></td>
</tr>
<%	} %>
</table>
</div>


<div>
	<button type="button" id="btnWriteInq" class="btn btn-info">1:1 문의 작성하기</button>
</div>


<!-- .inqList_container end -->
</div>

<div class="clearfix"></div>



<%@include file="/WEB-INF/views/mypage/inquiryPaging.jsp" %>

<%@include file="/WEB-INF/views/footer/footer.jsp" %>

