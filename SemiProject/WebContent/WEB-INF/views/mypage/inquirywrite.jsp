<%@page import="dto.Inquiry"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/header/header.jsp" %>

<%	Inquiry write = ((Inquiry) request.getAttribute("write")); %>

<!-- 스마트에디터 2 -->
<script type="text/javascript" src="../Resources/se2/js/service/HuskyEZCreator.js" charset="utf-8"></script>

<!-- <form>태그의 submit을 수행하면 editor에 작성한 내용을 <textarea>에 반영 -->
<script type="text/javascript">
function submitContents (elClickedObj) {
	
	//에디터의 내용을 #content에 반영한다
	oEditors.getById["content"].exec("UPDATE_CONTENTS_FIELD", []);
	
	try {
		//	<form>태그의 submit 수행
		elClickedObj.form.submit();
	} catch(e) {}
	
}
</script>

<script type="text/javascript">
$(document).ready(function() {
	
	//작성하기 버튼
	$("#btnWriteInq").click(function() {
		
		//스마트에디터의 내용을 <textarea>에 적용하는 함수를 호출한다
		submitContents($("#btnWriteInq"))
		
		//<form> submit
		$("form").submit();
	});
	
	//취소 버튼
	$("#btnCancel").click(function() {
		$(location).attr("href", "/mypage/inqlist");
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


.inq_container {
	width: 80%;
	padding: 30px;
	
	float: right;
}


textarea {
	width: 100%;
	height: 200px;
}

td:nth-child(2n) {
	text-align: left;
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




<div class="inq_container">

<h2>1 : 1 문의하기</h2>
<br><br>

<div>
<form action="/mypage/inqwrite" method="post">

<table class="table">

<tr>
	<td class="active">문의종류</td>
	<td colspan="2"><select name="inqsort">
		<option value="회원정보 수정">회원정보 수정</option>
		<option value="회원탈퇴">회원탈퇴</option>
		<option value="프리미엄 회원">프리미엄 회원</option>
		<option value="식당 관련">식당</option>
		<option value="기타">기타</option>
		</select></td>
</tr>
<tr>
	<td class="active">제목</td>
	<td><input type="text" name="title" style="width: 80%;"></td>
</tr>
<tr>
	<td class="active">닉네임</td>
	<td><%=session.getAttribute("usernick") %></td>
</tr>
<tr>
	<td class="active" colspan="2">문의 내용</td>
</tr>
<tr>
	<td colspan="2"><textarea id="content" name="content"></textarea></td>
</tr>
</table>

<!-- <input type="file" name="attachmentsfile" /> -->

</form>
</div>


<div>
	<button type="button" id="btnWriteInq" class="btn btn-info">작성하기</button>
	<button type="button" id="btnCancel" class="btn btn-default">취소</button>
</div>


<!-- .inq_container end -->
</div>


<div class="clearfix"></div>



<script type="text/javascript">
var oEditors = [];
nhn.husky.EZCreator.createInIFrame( {
	oAppRef: oEditors,
	elPlaceHolder: "content", //에디터가 적용될 <textarea>의 id를 입력
	sSkinURI: "/Resources/se2/SmartEditor2Skin.html",
	fCreator: "createSEditor2"
	
})

</script>

<%@include file="/WEB-INF/views/footer/footer.jsp" %>
