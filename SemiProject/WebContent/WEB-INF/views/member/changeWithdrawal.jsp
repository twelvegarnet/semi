<%@page import="dto.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/header/header.jsp" %>

<% Member info = (Member)request.getAttribute("info"); %>
<% boolean check = true; %>
<script type="text/javascript">
$(document).ready(function () {
	$("#cancleBtn").click(function () {
		history.back();
	})
	
	$("#secessionBtn").click(function () {
		alert("정말 탈퇴하시겠습니까?")
	})
	
	
	
})




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
	    padding-top: 20px;
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

.session {
	margin-top: 50px;
	margin-bottom: 200px;
	float: right;
	width: 80%;
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


<div class="session">
<h1>회원정보 수정 / 탈퇴</h1><br><br>
<form method = "post" action = "/member/secession" name = "userinput" >
<table width = "600" border = "1" cellspacing = "0" cellpadding = "3" align = "center" class="table table-boardered">
<tr class="active">
      <td colspan = "2" height = "39" align = "center">
            <font size = "+1"><b>회원 정보 수정</b></font>
      </td>
</tr>

<tr>
      <td width = "200">ID</td>
      <td width = "400"><%=info.getUserid() %></td>
</tr>


<tr>
      <td width = "200">이름</td>
      <td width = "400">
			<%=info.getUsername() %>
      </td>
</tr>
<tr>
      <td width = "200">닉네임</td>
       <td width = "400">
			<%=info.getNick() %>
      </td>
</tr>


<tr>
      <td width = "200">E-Mail</td>
      <td width = "400">
       <%
             if(info.getEmail() == null)
             {
       %>
            <b>이메일없음</b>
       <%
             }
             else
             {
       %>
            <%=info.getEmail() %>
       <%
             }
       %>
      </td>
</tr>

<tr>
      <td width = "200">생년월일</td>
      <td width = "400">
                 <%= info.getUserbirth() %>
      </td>
</tr>
<tr>
      <td width = "200">성별</td>
      <td width = "400">
            <%= info.getGender() %>
      </td>
</tr>

<tr>
      <td width = "200">회원등급</td>
      <td width = "400">
            <%= info.getGrade() %>
      </td>
</tr>


                 

</table>
            <input type = "button" class="btn btn-default" name = "modify" value = "수  정" id="modifyBtn" onclick = "location.href='/member/chg?check=<%=check%>'">
            <input type = "submit" class="btn btn-default" value = "탈  퇴" id="secessionBtn"/>
            <input type = "button" class="btn btn-default" value = "취  소" id="cancleBtn"/>
</form>


</div>

<div class="clearfix"></div>















<%@include file="/WEB-INF/views/footer/footer.jsp" %>