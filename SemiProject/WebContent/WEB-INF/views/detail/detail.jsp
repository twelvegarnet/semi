<%@page import="dto.SeoulGrade"%>
<%@page import="dto.Review"%>
<%@page import="java.util.List"%>
<%@page import="dto.Seoul"%>
<%@include file="/WEB-INF/views/header/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%	Seoul s = (Seoul) request.getAttribute("viewupso"); %>
<%	Seoul sn = (Seoul) request.getAttribute("upso_sno"); %>
<%	List<Review> list = (List) request.getAttribute("reviewList"); %>
<% SeoulGrade grade = (SeoulGrade) request.getAttribute("grade"); %>
<% int cnt = (int) request.getAttribute("cnt"); %>

<html>
<head>
<!-- 최신 제이쿼리 -->

<script type="text/javascript"
src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/fancyapps/fancybox@3.5.7/dist/jquery.fancybox.min.css" />
<script src="https://cdn.jsdelivr.net/gh/fancyapps/fancybox@3.5.7/dist/jquery.fancybox.min.js"></script>
<script type="text/javascript" async> 
var url_default_ks = "https://story.kakao.com/share?url="; 
var url_default_fb = "https://www.facebook.com/sharer/sharer.php?u="; 
var url_default_tw_txt = "https://twitter.com/intent/tweet?text="; 
var url_default_tw_url = "&url="; 
var url_default_band = "http://band.us/plugin/share?body="; 
var url_route_band = "&route="; 
var url_default_naver = "http://share.naver.com/web/shareView.nhn?url="; 
var title_default_naver = "&title="; 
var url_this_page = location.href; 
var title_this_page = document.title; 
var url_combine_ks = url_default_ks + url_this_page; 
var url_combine_fb = url_default_fb + url_this_page; 
var url_combine_tw = url_default_tw_txt + document.title + url_default_tw_url + url_this_page; 
var url_combine_band = url_default_band + encodeURI(url_this_page)+ '%0A' + encodeURI(title_this_page)+'%0A' + '&route=tistory.com'; 
var url_combine_naver = url_default_naver + encodeURI(url_this_page) + title_default_naver + encodeURI(title_this_page); 
</script>
</head>
<script type="text/javascript">
function getListAjax(upso_sno, curpage) {
	var alldata = {upso_sno: upso_sno, curpage: curpage}
    $.ajax({
        type : "GET",
        url : "/review/list",
        data: alldata,
        dataType : "html",
        error : function() {
            alert('통신실패!!');
        },
        success : function(data) {
        	console.log(data)
        	$("#div1").html(data)
        }
 
    });
}
</script>

<script>
$(document).ready(function(){
	var upso_sno = <%=sn.getUpso_sno() %>
	
	var curpage = <%=request.getParameter("curPage") %>
	if( !curpage ) {
		curpage = 0;
	}
	
	getListAjax(upso_sno, curpage);


	$(document.body).on("click", ".my a", function(e) {
		e.preventDefault();
		
		console.log($(this).attr("data-curpage"))
		getListAjax(upso_sno, $(this).attr("data-curpage"));
		
	})
});

</script>
<style>

#container {
	margin-top: 100px;
}
#menu {
 width: 600px; height:500px;
}
#div1 {
 margin-top:100px; border: none; width:1100px; height:500x;
}
#upsoinfo {
 border-collapse:seperate; border-spacing: 20px;
}
</style>
<meta charset="UTF-8">
<title>맛집 상세 화면</title>
</head>
<body>

<div id="container" class="container">
<%-- <img id="menu" align="left" src="/resources/se2/img/upso/M<%=sn.getUpso_sno() %>.jpg"> --%>
<img style="width: 618px; height: 500px; "id="menu" align="left" src="https://source.unsplash.com/collection/8774409">

<span align="left" style="font-size: 36px; font-family: '바탕';">&nbsp;&nbsp;&nbsp;<%=s.getUpso_nm() %></span> <span style="font-size: 24px;">
<%for(int i=0;i<grade.getAvg();i++){%>
<span style="font-size: 24px;">⭐</span>
<%} %><img src="/Resources/img/pencil.png" width=30; height=30;><%= cnt %></span>
<br>
<br>

<div class="btn-type1" style="text-align:center;">
 공유하기&nbsp;<img width=30; height=30; src="/Resources/img/iconshare.png">
<!-- SNS버튼 시작 --> 
<span style="width: 100%; text-align: left; margin-bottom: 64px;"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<!-- 페이스북 공유 버튼 --> 
<a href="" onclick="window.open(url_combine_fb, '', 'scrollbars=no, width=600, height=600'); return false;">
<img src="/Resources/img/facebook.png" title="페이스북으로 공유하기" class="sharebtn_custom" style="width: 32px;"></a> 
<!-- 트위터 공유 버튼 --> 
<a href="" onclick="window.open(url_combine_tw, '', 'scrollbars=no, width=600, height=600'); return false;">
<img src="/Resources/img/twitter.png" title="트위터로 공유하기" class="sharebtn_custom" style="width: 32px;"></a> 
<!-- 카카오 스토리 공유 버튼 --> 
<a href="" onclick="window.open(url_combine_ks, '', 'scrollbars=no, width=600, height=600'); return false;">
<img src="/Resources/img/kakaostory.png" title="카카오스토리로 공유하기" class="sharebtn_custom" style="width: 32px;"></a> 
<!-- 네이버 공유 버튼 --> 
<a href="" onclick="window.open(url_combine_naver, '', 'scrollbars=no, width=600, height=600'); return false;">
<img src="/Resources/img/naver.jpg" title="네이버로 공유하기" class="sharebtn_custom" style="width: 32px;"></a> 
<!-- SNS버튼 끝 -->
</div>

</span>
<br>
<br>
<br>
<hr>
<table class="upsoinfo" id="upsoinfo">
<tbody>
<tr>
<td style="width:100px; padding: 10px; font-size: 14px;">업종</td>
<td><%=s.getBizcnd_code_nm() %>
</tr>
<tr>
<td style="padding: 10px; font-size: 14px;">주소</td>
<td><%=s.getRdn_code_nm() %></td>
</tr>
<tr>
<td style="padding: 10px; font-size: 14px;">전화번호</td>
<td><%=s.getTel_no() %></td>
</tr>
<tr>
<td style="padding: 10px; font-size: 14px;">메뉴</td>
<td><%=s.getFood_menu() %></td>
</tr>


</tbody>
</table>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<div style="width: 618px; height: 178px;">
<a href="https://source.unsplash.com/collection/8774409.jpg" 
data-fancybox data-caption="캡션"> <img style="float:left; width:200px; height:200px; padding-bottom: 30px;" 
src="https://source.unsplash.com/collection/8774409.jpg" alt="이미지 설명"> </a>
<a href="https://source.unsplash.com/collection/9689180.jpg" 
data-fancybox data-caption="캡션"> <img style="float:left; width:200px; height:200px; padding-bottom: 30px;" 
src="https://source.unsplash.com/collection/9689180.jpg" alt="이미지 설명"> </a>
<a href="https://source.unsplash.com/collection/4817197.jpg" 
data-fancybox data-caption="캡션"> <img style="float:left; width:200px; height:200px; padding-bottom: 30px;" 
src="https://source.unsplash.com/collection/4817197.jpg" alt="이미지 설명"> </a>
</div>
<h2 style="clear:left; text-align: left; font-family: '바탕';">찾아오시는 길</h2>
<hr>
<div id="map" style="width:700px;height:400px;"></div>
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=1aa4680f80a0da3158f23cbd473b93cf"></script>
    <script>
        var container = document.getElementById('map'); //지도 표시 div
        var options = {
            center: new kakao.maps.LatLng(<%=s.getY_dents() %>, <%=s.getX_cnts() %>), //지도의 중심좌표
            level: 3 //지도의 확대 레벨
        };
 
        var map = new kakao.maps.Map(container, options);
        
        // 마커가 표시될 위치
        var markerPosition  = new kakao.maps.LatLng(<%=s.getY_dents() %>, <%=s.getX_cnts() %>); 
 
        // 마커 생성
        var marker = new kakao.maps.Marker({
            position: markerPosition
        });
 
        // 마커가 지도 위에 표시되도록 설정
        marker.setMap(map);
        
     // 인포윈도우로 장소에 대한 설명을 표시합니다 
     var infowindow = new kakao.maps.InfoWindow({ content: '<div style="width:150px;text-align:center;padding:6px 0;"><div style="font-weight: bold;"><%=s.getUpso_nm()%></div></div>' }); infowindow.open(map, marker);

 
        // 아래 코드는 지도 위의 마커를 제거하는 코드
        // marker.setMap(null);     
    </script>
    

<div id="div1"></div>

<%-- <%@ include file="/WEB-INF/views/layout/paging.jsp" %> --%>
</div>
</body>
</html>

<%@include file="/WEB-INF/views/footer/footer.jsp" %>