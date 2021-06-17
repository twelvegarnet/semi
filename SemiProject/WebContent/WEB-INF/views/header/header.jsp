<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%	String userGrade = (String)session.getAttribute("grade"); %>

<!DOCTYPE html>
<html lang="en">


    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title> : : : 맛객 : : : </title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/img/favicon.ico" />
        
        <!-- Font Awesome icons (free version)-->
<!--         <script src="./Resources/startboots/js/all.min.js" crossorigin="anonymous"></script> -->
        <!-- Google fonts-->
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css" />
        <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="/Resources/startboots/css/styles.css" rel="stylesheet" />
    	<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>


		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
		
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
		
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
		
		<style>
		.bg-oranged {
			background-color: #FAA600 !important;
		}
		
		.fill {
			width: 100%;
			height: 360px;
			margin-top: 80px;
		}
		.size {
			width: 250px;
			height: 140px;
		}
		.padding-top{
			padding-top: 0;
		}
		.float {
			float: left;
		}
		.navbar2 {
			padding-bottom: 0;
		}
		.bodysize {
			width: 1200px;
			margin: 0 auto;
			text-align: center;
		}
		
		
		</style>
		    
    </head>
    
    
    
    
    <body id="page-top" class="bodysize">
        <!-- Navigation-->
        <nav class="navbar2 navbar-expand-lg bg-oranged text-uppercase fixed-top" id="mainNav">
            <div class="container">
                <a class="navbar-brand js-scroll-trigger" href="/">맛객</a>
                <button class="navbar-toggler navbar-toggler-right text-uppercase font-weight-bold bg-primary text-white rounded" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                    Menu
                    <i class="fas fa-bars"></i>
                </button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ml-auto">
<!--                         <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="/faq/view">게시판</a></li> -->
<%--                         <%if(session.getAttribute("login") == null || !(boolean)session.getAttribute("login")){ %>  --%>
<!--                         <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="/member/login">로그인</a></li> -->
                    	
<%--                     	<%} else { %> --%>
<!--                         <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="/mypage">마이페이지</a></li> -->
<%--                         <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger"><%=session.getAttribute("usernick") %> 님,</a></li> --%>
<!--                         <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="/member/logout">로그아웃</a></li> -->
<%-- 						<%} %> --%>
						
						
						                    
                        <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="/recipe/list">게시판</a></li>
                        <%if(session.getAttribute("login") == null || !(boolean)session.getAttribute("login")){ %> 
                        <!-- 로그인 X -->
                        <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="/member/login">로그인</a></li>
                    	
                    	<%} else { %>
                    	<!-- 로그인 O -->
                    		<% if ( "관리자".equals(userGrade) ) { %>
                    		<!-- 로그인 O, 관리자일 때 -->
                        <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger"><%=session.getAttribute("usernick") %> 님,</a></li>
                        <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="/member/logout">로그아웃</a></li>
                        <li class="nav-item mx-0 mx-lg-1"><button type="button" onclick="location.href='/admin'" style="margin-top: 10px;">관리자페이지</button></li>
						
							<%} else { %>
							<!-- 로그인 O, 관리자 아닐 때 -->
                        <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="/mypage">마이페이지</a></li>
                        <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger"><%=session.getAttribute("usernick") %> 님,</a></li>
                        <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="/member/logout">로그아웃</a></li>
							<%} %>
						<%} %>
                    </ul>
                
                </div>
            </div>
        </nav>

       