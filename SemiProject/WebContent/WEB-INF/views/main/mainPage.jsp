<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    
<%@include file="/WEB-INF/views/header/header.jsp" %>


			<link href="/Resources/se2/css/slider/slider.css" rel="stylesheet"/>
			<script type="text/javascript" src ="/Resources/se2/js/slider_edit.js"></script>

		<style>
			h3{
				font-size: 30px;
				font-weight: bold;
				color: white;
			
			}
			h3 + span{
				font-size: 16px;
				font-weight: bold;
				color: white;
				
			}
			#followquick{
				position:absolute;
				top: 80px;
				right: 48.5%;
				margin-right:-800px;
				padding: 10px;
				font-size: 20px;
				color: white;
				font-weight: bold;
				line-height: 180px;
				border-radius: 20px;
				z-index: 90999;
			
			}
			#followquick div a {
				color: #1abc9c;
				background-color: #FBF5EF;
				border: 5px solid #1abc9c;
				border-radius: 15px;
				padding: 15px;
				
			}
			
		</style>
		
		<script type="text/javascript">
		$(window).scroll(function(){
			var scrollTop = $(document).scrollTop();
			if (scrollTop < 80) {
			 scrollTop = 80;
			}
			$("#followquick").stop();
			$("#followquick").animate( { "top" : scrollTop });
			});
		</script>
		

        <!-- Masthead-->
        <header class="padding-top bg-oranged text-white text-center">
        	<div style="position: relative;">
        		<img class="fill" src="Resources/img/headerImg.jpg" alt="" />
        	</div>
        	<div style="position: relative;" class="">
            	<img class="size" src="Resources/img/logo1.png" alt="" />
        	</div>
        	
            <div class="container d-flex align-items-center flex-column">
                <!-- Masthead Avatar Image-->
            </div>
        </header>
        <!--  -->
       <div id="followquick">
       
       <div><a href="#" style="padding-left: 60px; padding-right: 60px">맛객</a></div>
		<div><a href="#foodmap" style="padding-left: 50px; padding-right: 50px">맛지도</a></div>       
		<div><a href="#theme" style="padding-left: 22px; padding-right: 22px">테마별리스트</a></div>       
		<div><a href="#foodlist" style="padding-left: 30px; padding-right: 30px">맛집리스트</a></div>       
       
       </div>

     
       <!-- 본문입니다! -->
       <section id="foodmap">
<!-- 	      	 <h1 style="margin-top: 100px; text-align: left; color: orange;">맛지도</h1> -->
	      	 <img alt="" src="/Resources/img/mapLogo.png" style="width: 20%; margin:0 auto;">
			<div id="wrapper" style="margin: 0 auto; width: 830px; height: 650px;">
				<br><br>
			
			<div class="swiper-wrapper">
		      <div class="img_write">
				<h3>서울시</h3>
				<span>K-FOOD</span>
		      </div>
		      <a href="/main/map"><img style="
border: 3px solid gold;
border-radius: 7px;
-moz-border-radius: 7px;
-khtml-border-radius: 7px;
-webkit-border-radius: 7px;
" class="slide_img" src="/Resources/img/map.jpg"></a>
		      </div>
			</div>
       </section>
      <hr size="10px" width="100%" style="border-top: 1px solid #ccc; margin-top: 100px;">


      
      
      
        <!-- Link Swiper's CSS -->
		 <script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
		 <link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css" />
		 <link href="/Resources/se2/css/slider/slider2.css" rel="stylesheet"/>
		 <%if("프리미엄".equals(userGrade)){ %>
        <section id="theme">
		
		  <!-- Swiper -->
		  <img alt="" src="/Resources/img/테마별맛집.png" style="width: 20%; margin:0 auto; margin-top: 10px;">


		  <div class="swiper-container">
		    <div class="swiper-wrapper">
		    
		      <div class="swiper-slide">
		      <div class="img_write">
		      	<h3>한식</h3>
				<span>K-FOOD</span>
		      </div>
		      <a href="/main/theme?theme=한식"><img class="slide_img" src="https://i.pinimg.com/564x/5d/06/59/5d0659b43a84e2962eba9ed3386928cb.jpg"></a>
		      </div>
		      
		      <div class="swiper-slide">
		      <div class="img_write">
		      	<h3>일식</h3>
				<span>J-FOOD</span>
		      </div>
		      <a href="/main/theme?theme=일식"><img class="slide_img" src="https://i.pinimg.com/564x/c2/71/00/c2710056bd8bcca6dfefa215d65bbb52.jpg"></a></div>
		      
		      <div class="swiper-slide">
		      <div class="img_write">
		      	<h3>중식</h3>
				<span>J-FOOD</span>
		      </div>
		      <a href="/main/theme?theme=중국식"><img src="https://i.pinimg.com/564x/78/39/60/783960c4de004668eae095f8949d5a30.jpg"></a></div>
		      
		      <div class="swiper-slide">
		      <div class="img_write">
		      	<h3>경양식</h3>
				<span>J-FOOD</span>
		      </div>
		      <a href="/main/theme?theme=경양식"><img class="slide_img" src="https://i.pinimg.com/564x/a3/7e/e2/a37ee2fc67697af8fc97d8d6ff66ac14.jpg"></a></div>
		      
		       <div class="swiper-slide">
		      <div class="img_write">
		      	<h3>뷔페식</h3>
				<span>J-FOOD</span>
		      </div>
		      <a href="/main/theme?theme=뷔페식"><img class="slide_img" src="https://i.pinimg.com/564x/f4/90/0f/f4900fe47b9db94b9438d448988555d9.jpg"></a></div>
		      
		       <div class="swiper-slide">
		      <div class="img_write">
		      	<h3>고기</h3>
				<span>J-FOOD</span>
		      </div>
		      <a href="/main/theme?theme=식육취급"><img class="slide_img" src="https://i.pinimg.com/564x/77/72/39/77723909a3129bd3c97245843409740f.jpg"></a></div>
		      
		      
		    </div>
		    <!-- Add Pagination -->
		    <div class="swiper-pagination"></div>
		    <!-- Add Arrows -->
		    <div class="swiper-button-next"></div>
		    <div class="swiper-button-prev"></div>
		  </div>
		
		  <!-- Initialize Swiper -->
		  <script>
		    var swiper = new Swiper('.swiper-container', {
		      slidesPerView: 3,
		      spaceBetween: 30,
		      slidesPerGroup: 3,
		      loop: true,
		      loopFillGroupWithBlank: true,
		      pagination: {
		        el: '.swiper-pagination',
		        clickable: true,
		      },
		      navigation: {
		        nextEl: '.swiper-button-next',
		        prevEl: '.swiper-button-prev',
		      },
		    });
		  </script>


       </section>
       
             <hr size="10px" width="100%" style="border-top: 1px solid #ccc; margin-top: 100px;">
        <%} %>
       
       <section id="foodlist">
		  <img alt="" src="/Resources/img/맛집리스트.png" style="width: 20%; margin:0 auto; margin-top: 10px;">
		<h3 ></h3>
		  <!-- Swiper -->
		  <div class="swiper-container">
		    <div class="swiper-wrapper">
		      <div class="swiper-slide">
		      <div class="img_write">
		      	<h3>#뜨끈한탕</h3>
				<span>#갈비탕#매운탕#설렁탕</span>
		      </div>
		      <a href="/main/foodlist?food=탕"><img class="slide_img" src="https://i.pinimg.com/564x/1f/79/67/1f7967d9949090d332cb5a6383da8514.jpg"></a>
		      </div>
		      
		       <div class="swiper-slide">
		      <div class="img_write">
		      	<h3>#칼칼한국수</h3>
				<span>#칼국수#메밀국수</span>
		      </div>
		      <a href="/main/foodlist?food=국수"><img class="slide_img" src="https://i.pinimg.com/564x/12/a8/9c/12a89cd40e778fa31fbaaca892717020.jpg"></a>
		      </div>
		      
		       <div class="swiper-slide">
		      <div class="img_write">
		      	<h3>#보글보글찌개</h3>
				<span>#된장찌개#부대찌개#김치찌개</span>
		      </div>
		      <a href="/main/foodlist?food=찌개"><img class="slide_img" src="https://i.pinimg.com/564x/e9/53/90/e953907735dae7ff61547fab84b7a91f.jpg"></a>
		      </div>
		      
		       <div class="swiper-slide">
		      <div class="img_write">
		      	<h3>#분위기좀 내볼까?</h3>
				<span>#스테이크#스프#샐러드</span>
		      </div>
		      <a href="/main/foodlist?food=스프"><img class="slide_img" src="https://i.pinimg.com/564x/1f/a4/cd/1fa4cdf0a100af43295db29f37757fee.jpg"></a>
		      </div>
		      
		       <div class="swiper-slide">
		      <div class="img_write">
		      	<h3>#중화요리어때?</h3>
				<span>#짬뽕#짜장면#탕수육</span>
		      </div>
		      <a href="/main/foodlist?food=짬뽕"><img class="slide_img" src="https://i.pinimg.com/564x/62/1f/c7/621fc70a243f0ea3c82f298c77220093.jpg"></a>
		      </div>
		      
		      
		      
		      
		      
		      
		      
		    </div>
		    <!-- Add Pagination -->
		    <div class="swiper-pagination"></div>
		    <!-- Add Arrows -->
		    <div class="swiper-button-next"></div>
		    <div class="swiper-button-prev"></div>
		  </div>
		
		  <!-- Initialize Swiper -->
		  <script>
		    var swiper = new Swiper('.swiper-container', {
		      slidesPerView: 3,
		      spaceBetween: 30,
		      slidesPerGroup: 3,
		      loop: true,
		      loopFillGroupWithBlank: true,
		      pagination: {
		        el: '.swiper-pagination',
		        clickable: true,
		      },
		      navigation: {
		        nextEl: '.swiper-button-next',
		        prevEl: '.swiper-button-prev',
		      },
		    });
		  </script>


       </section>
       <br>
       <br>
       <br>
       <br>
       <br>
       <br>
       <br>
       <br>
       <br>
       
     <%@include file="/WEB-INF/views/footer/footer.jsp" %> 
       
       
        
     
