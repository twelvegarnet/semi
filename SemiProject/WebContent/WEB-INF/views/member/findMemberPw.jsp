<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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



</style>

</head>
<body>
<h3>비밀번호 찾기</h3>
<div class="container" style="margin: 0 auto; margin-top: 50px;">
<form action="/member/find/loginPw" method="post">
  <div class="form-group form-group-sm ">
    <label for="name">아이디</label>
    <input type="text" class="form-control" id="id" name="id" placeholder="아이디를 입력하세요">
  </div>
  <div class="form-group form-group-sm">
    <label for="nick">닉네임</label>
    <input type="text" class="form-control" id="nick" name="nick" placeholder="닉네임을 입력하세요">
  </div>
  
  <button type="submit" class="btn btn-default">확인</button>
</form>
</div>

</body>
</html>