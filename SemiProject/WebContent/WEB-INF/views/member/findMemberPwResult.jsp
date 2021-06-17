<%@page import="dto.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% Member member = (Member)request.getAttribute("member"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<script type="text/javascript">

$(document).ready(function () {
<%-- 	<%if(member == null){%> --%>
// 		alert("등록된 정보를 찾을 수 없습니다!")
// 		self.close();
<%-- 	<%} else {%> --%>
// 		alert("등록된 이메일로 발송합니다.")
// 		self.close();
<%-- 	<%}%> --%>

	$("#findPW").click(function(){
		alert("등록된 이메일로 발송합니다.")
		self.close();
	})

})


</script>


</head>
<body>
<% if(member != null){ %>
<h1>비밀번호찾기</h1>

임시 비밀번호를 회원가입 시 등록한 메일로 보내드립니다.
<br><br>
<button id="findPW" onclick="location.href='/send?userid=<%=member.getUserid()%>&email=<%=member.getEmail()%>'">메일보내기</button>

<%} else{ %>
이메일 전송에 실패했습니다. 고객센터에 문의해주세요.
<%} %>

</body>
</html>