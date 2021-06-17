<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="review.dto.Seoul"%>
<%@include file="/WEB-INF/views/header/header.jsp" %>

<%	Seoul s = (Seoul) request.getAttribute("viewupso"); %>
<%	Seoul sn = (Seoul) request.getAttribute("upso_sno"); %>
<!DOCTYPE html>
<html>
<head>

<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.min.js"></script>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/fancyapps/fancybox@3.5.7/dist/jquery.fancybox.min.css" />
<script src="https://cdn.jsdelivr.net/gh/fancyapps/fancybox@3.5.7/dist/jquery.fancybox.min.js"></script>
<script>
$(document).ready(function(){
    $("#div1").load("review/list");
});

</script>
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

<body>
<!-- SNS 공유용 주소 연결 용 --> 


<br>
<br>

<img style="width: 600px; height:500px;"align="left" src="/Resources/se2/img/upso/M<%=sn.getUpso_sno() %>.jpg">

<h1 align="left" style="font-family: '바탕';">&nbsp;&nbsp;<%=s.getUpso_nm() %></h1>
<span class="btn-type1">
<img width=50; height=50; src="/Resources/se2/img/iconshare.png">
<!-- SNS버튼 시작 --> 
<div style="width: 100%; text-align: center; margin-bottom: 64px;"> 
<!-- 페이스북 공유 버튼 --> 
<a href="" onclick="window.open(url_combine_fb, '', 'scrollbars=no, width=600, height=600'); return false;"><img src="/Resources/se2/img/facebook.png" title="페이스북으로 공유하기" class="sharebtn_custom" style="width: 32px;"></a> 
<!-- 트위터 공유 버튼 --> <a href="" onclick="window.open(url_combine_tw, '', 'scrollbars=no, width=600, height=600'); return false;"><img src="/Resources/se2/img/twitter.png" title="트위터로 공유하기" class="sharebtn_custom" style="width: 32px;"></a> 
<!-- 카카오 스토리 공유 버튼 --> <a href="" onclick="window.open(url_combine_ks, '', 'scrollbars=no, width=600, height=600'); return false;"><img src="/Resources/se2/img/kakaostory.png" title="카카오스토리로 공유하기" class="sharebtn_custom" style="width: 32px;"></a> 
<!-- 네이버 공유 버튼 --> <a href="" onclick="window.open(url_combine_naver, '', 'scrollbars=no, width=600, height=600'); return false;"><img src="/Resources/se2/img/naver.jpg" title="네이버로 공유하기" class="sharebtn_custom" style="width: 32px;"></a> 
<!-- SNS버튼 끝 -->
</div>

</span>
<hr>
<br>
<table class="01">
<tbody>
<tr>
<td style="padding: 10px;">업종</td>
<td><%=s.getBizcnd_code_nm() %></td>
</tr>
<tr>
<td style="padding: 10px;">주소</td>
<td><%=s.getRdn_code_nm() %></td>
</tr>
<tr>
<td style="padding: 10px;">전화번호</td>
<td><%=s.getTel_no() %></td>
</tr>
<tr>
<td style="padding: 10px;">메뉴</td>
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
<a href="/Resources/se2/img/upso/S1<%=sn.getUpso_sno() %>.jpg" 
data-fancybox data-caption="캡션"> <img style="float:left; width:200px; height:200px; padding-bottom: 30px;" src="/resources/se2/img/upso/S1<%=sn.getUpso_sno() %>.jpg" 
data-fancybox data-caption="캡션"> <img style="float:left; width:200px; height:200px; padding-bottom: 30px;" src="/Resources/se2/img/upso/S1<%=sn.getUpso_sno() %>.jpg" 
alt="이미지 설명"> </a>
<a href="/Resources/se2/img/upso/S1<%=sn.getUpso_sno() %>.jpg" 
data-fancybox data-caption="캡션"> <img style="float:left; width:200px; height:200px; padding-bottom: 30px;" src="/resources/se2/img/upso/S2<%=sn.getUpso_sno() %>.jpg" 
data-fancybox data-caption="캡션"> <img style="float:left; width:200px; height:200px; padding-bottom: 30px;" src="/Resources/se2/img/upso/S2<%=sn.getUpso_sno() %>.jpg" 
alt="이미지 설명"> </a>
<a href="/Resources/se2/img/upso/S1<%=sn.getUpso_sno() %>.jpg" 
data-fancybox data-caption="캡션"> <img style="float:left; width:200px; height:200px; padding-bottom: 30px;" src="/resources/se2/img/upso/S3<%=sn.getUpso_sno() %>.jpg" 
data-fancybox data-caption="캡션"> <img style="float:left; width:200px; height:200px; padding-bottom: 30px;" src="/Resources/se2/img/upso/S3<%=sn.getUpso_sno() %>.jpg" 
alt="이미지 설명"> </a>
<br>
<br>
<br>
<br>
<br>

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
 
        // 아래 코드는 지도 위의 마커를 제거하는 코드
        // marker.setMap(null);     
    </script>

	
<br>
<br>


<div id="div1" style="border: none; width:1100px; height:500x; "></div>







</body>

</html>



<%@include file="/WEB-INF/views/footer/footer.jsp" %>