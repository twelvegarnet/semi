<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.awt.Image"%>
<%@page import="com.sun.jimi.core.Jimi"%>
<%@page import="com.sun.jimi.core.JimiException"%>
<%@page import="com.sun.jimi.core.JimiUtils"%>
<%
        String filePath ="";
 
        String orgImg = filePath+"test.jpg";//원본파일
        String thumbImg = filePath+"thum_test.jpg";//썸네일파일
        int thumbWidth = 160 ;//썸네일 가로
        int thumbHeight = 160 ;//썸네일 세로
 
        Image thumbnail = JimiUtils.getThumbnail(orgImg, thumbWidth, thumbHeight, Jimi.IN_MEMORY);// 썸네일 설정
        Jimi.putImage(thumbnail, thumbImg);// 썸네일 생성
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>