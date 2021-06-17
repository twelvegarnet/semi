<%@page import="dto.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% Member member = (Member)request.getAttribute("member"); %>
    <% String str = member.getUserid(); %>
    <% int strCnt = str.length() - 3; %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<style type="text/css">

h3{
	background-color: orange;
	margin-top: 0px;
	padding: 20px;
	color: white;

}
body {

	margin: 0 auto;
}
button {
	position: absolute;
	top: 50%;
	left: 44%;
}



</style>
</head>
<body>


<div>
<h3>아이디 찾기</h3>

<h4 style="text-align: center; margin-top: 100px;">고객님의 아이디는<%=str.charAt(0)%><%=str.charAt(1) %><%=str.charAt(2) %>
<%for(int i=0;i<strCnt;i++){ %>
*
<%} %>

, 입니다.</h4>


<button onclick="self.close()" class="btn btn-default">창닫기</button>


</div>

</body>
</html>