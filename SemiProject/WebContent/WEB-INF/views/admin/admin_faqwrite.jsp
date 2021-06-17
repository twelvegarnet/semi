
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<%@include file="/WEB-INF/views/admin/admin_header.jsp" %>

<script type="text/javascript">

$(document).ready(function() {
	
	$("#btnWrite").click(function(){
		
		$("form").submit();
	});
	
	$("#btnCancel").click(function(){
			
			$(location).attr("href", "/admin/faqlist");
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

form { 
width: 80%;
float: right;
padding: 30px;

}

textarea {
width: 900px;
height: 300px;

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


<div>
<form action="/admin/faqwrite" method="post">

<table class="table">

<tr>
	<td class="active">제목</td>
	<td><input type="text" name="title" style="width: 100%;"></td>
</tr>

<tr>
	<td class="active" colspan="2">작성 내용</td>
</tr>
<tr>
	<td colspan="2"><textarea id="content" name="content"></textarea></td>
</tr>
</table>

</form>
</div>

<button type="button" id="btnWrite" class="btn btn-info">등록</button>
<button type="button" id="btnCancel" class="btn btn-info">취소</button>





<div class="clearfix"></div>



