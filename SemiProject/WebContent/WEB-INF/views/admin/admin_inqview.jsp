<%@page import="dto.Inquiry"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%	Inquiry inq = (Inquiry) request.getAttribute("viewInquiry"); %>
<%	int inqCnt = (int) request.getAttribute("cntAnswer"); %>

<%@include file="/WEB-INF/views/admin/admin_header.jsp" %>

<script type="text/javascript">
$(document).ready(function() {
	
	//답변 등록 버튼 클릭 시
	$("#btnWriteAns").click(function() {
	});
	
	//목록 버튼 클릭 시
	$("#btnListInq").click(function() {
		$(location).attr("href", "/admin/inqlist");
	});
	
	//삭제 버튼 클릭 시
	$("#btnDeleteInq").click(function() {
		
		if(confirm("[확인]버튼 클릭 시 해당 문의글이 삭제되고 되돌릴 수 없습니다.\n 삭제하시겠습니까?")) {
			$(location).attr("href", "/admin/inqdelete?inquiryno=<%=inq.getInquiryno() %>");
		}
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


.admininqView_container {
	width: 80%;
	padding: 30px;
	
	float: right;
}

.inqAnswer_container {
	padding: 40px;
}

h3 {
	font-weight: bolder;
	padding: 20px;
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


<div class="admininqView_container">

<h2>문의내용 상세보기</h2>
<br><br>

<div>
<table class="table" style="border: 1px solid #ccc;">
<tr>
	<td class="active">문의번호</td><td><%=inq.getInquiryno() %></td>
	<td class="active">문의종류</td><td><%=inq.getInqsort() %></td>
</tr>
<tr>
	<td class="active">회원번호</td><td><%=inq.getUserno() %></td>
	<td class="active">닉네임</td><td><%=request.getAttribute("nick") %></td>
</tr>
<tr>
	<td class="active">제목</td><td><%=inq.getTitle() %></td>
	<td class="active">작성일자</td><td><%=inq.getCreateDate() %></td>
</tr>
<tr>
	<td class="active" colspan="4">내용</td>
</tr>
<tr>
	<td colspan="4" style="height: 200px; text-align: left; padding: 20px;"><%=inq.getInqcontent() %></td>
</tr>
</table>
</div>

<%	if( inqCnt > 0 ) { %>
<!-- 해당 문의글에 대한 답변이 존재할 경우
	답변을 보여줌 -->
	<h3>답변완료!</h3>

<%	} else {  %>
<!-- 해당 문의글에 대한 답변이 없을 경우
	답변 작성 form을 보여줌 -->
	<div class="inqAnswer_container">
	<form action="/admin/inqanswer" method="post">
	<input type="hidden" name="inquiryno" value="<%=request.getParameter("inquiryno") %>">
		<div>
			<textarea id="answertext" name="answercontent" rows="10" cols="100" placeholder="해당 문의에 대한 답변 작성하기"></textarea>
			<input type="submit" id="btnWriteAns" class="btn btn-default" value="답변등록">
		</div>
	</form>

<!-- .inqAnswer_container end -->
</div>

<%	} %>


<div>
	<button type="button" id="btnListInq" class="btn btn-default">목록으로</button>
	<button type="button" id="btnDeleteInq" class="btn btn-danger">삭제</button>
</div>


<!-- .inqView_container end -->
</div>

<div class="clearfix"></div>

