<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/header/header.jsp" %>


<style>
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
/*     	float: left; */
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

<%@include file="/WEB-INF/views/footer/footer.jsp" %>