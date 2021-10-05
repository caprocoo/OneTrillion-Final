<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/Swiper/4.5.1/css/swiper.min.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/Swiper/4.5.1/js/swiper.min.js"></script>
<style type="text/css">
.mySlides img {
	width: 100%;
	height: 500px;
	object-fit: cover;
}

.mySlides>img:hover {
	cursor: pointer;
}
/* Slideshow container */
.slideshow-container {
	max-width: 100%;
	position: relative;
	margin: auto;
	z-index: 1;
}

/* Next & previous buttons */
.prev, .next {
	cursor: pointer;
	position: absolute;
	top: 50%;
	width: auto;
	padding: 16px;
	margin-top: -22px;
	color: white;
	font-weight: bold;
	font-size: 18px;
	transition: 0.6s ease;
	border-radius: 0 3px 3px 0;
	user-select: none;
}

/* Position the "next button" to the right */
.next {
	right: 0;
	border-radius: 3px 0 0 3px;
}

/* On hover, add a black background color with a little bit see-through */
.prev:hover, .next:hover {
	background-color: rgba(0, 0, 0, 0.8);
}

/* Caption text */
.text {
	width: 100%;
	padding: 8px 12px;
	position: absolute;
	bottom: 10px;
}

.text>div:nth-child(1) {
	position: relative;
	width: 1000px;
	margin: auto;
	color: white;
	font-size: 40px;
	font-weight: bold;
	text-shadow: 0 0 15px black;
}

.text, .text>div:hover {
	cursor: pointer;
}
/* Number text (1/3 etc) */
.numbertext {
	color: #f2f2f2;
	font-size: 12px;
	padding: 8px 12px;
	position: absolute;
	top: 0;
}

/* The dots/bullets/indicators */
.dot {
	cursor: pointer;
	height: 15px;
	width: 15px;
	margin: 0 2px;
	background-color: #bbb;
	border-radius: 50%;
	display: inline-block;
	transition: background-color 0.6s ease;
}

.active, .dot:hover {
	background-color: #717171;
}

/* Fading animation */
.fade {
	-webkit-animation-name: fade;
	-webkit-animation-duration: 1.5s;
	animation-name: fade;
	animation-duration: 1.5s;
}

@
-webkit-keyframes fade {
	from {opacity: .4
}

to {
	opacity: 1
}

}
@
keyframes fade {
	from {opacity: .4
}

to {
	opacity: 1
}

}

/* On smaller screens, decrease text size */
@media only screen and (max-width: 300px) {
	.prev, .next, .text {
		font-size: 11px
	}
}

#swiper {
	width: 100%;
	height: 500px;
}

.swiper-container {
	width: 1000px;
	height: 200px;
}

.swiper-slide {
	display: flex; /* 내용을 중앙정렬 하기위해 flex 사용 */
	align-items: center; /* 위아래 기준 중앙정렬 */
	justify-content: center; /* 좌우 기준 중앙정렬 */
	background-color: white;
	border-radius: 10px;
	box-sizing: border-box; /* 이 설정을 하지 않으면 슬라이드드가 틀어짐 */
	/* 아래에 있는 실행가능한 소스를 가지고 실험해 보세요 */
	;
}

.swiper-slide>img {
	width: 195px;
	height: 200px;
	object-fit: cover;
	border-radius: 10px;
}

.swiper-slide>img:hover {
	cursor: pointer;
}

li.slider>imgs {
	width: 200px;
	height: 200px;
	object-fit: cover;
}

#themebox {
	margin-left: 150px;
	margin-top: 0;
	width: 1000px;
}

#first {
	background-color: white;
	margin-top: 0px;
	margin-bottom: 0;
	margin-left: 0%;
	display: block;
}

#second {
	background-color: rgb(250, 250, 250);
	margin: top 0px;
	margin-left: 0%;
	margin-bottom: 0;
	display: block;
}

.hiddentext {
	font-size: 20px;
	color: white;
	display: none;
	z-index: 2;
	cursor: pointer;
}

#textmargin {
	margin-top: 20px;
}
</style>
</head>
<body>
	<jsp:include page="../include/header2.jsp"></jsp:include>
	<div class="slideshow-container">

		<div class="mySlides fade" id="mySlides001">
			<img src="http://jjcom0214.cafe24.com/web/OneTrillion/busan.jpg"
				style="width: 100%">
			<div class="text">
				<div>해운대 최저가로?</div>
			</div>
		</div>

		<div class="mySlides fade" id="mySlides002">
			<img src="http://jjcom0214.cafe24.com/web/OneTrillion/jeju.jpg"
				style="width: 100%">
			<div class="text">
				<div>남친과 함께 성산 일출봉!</div>
			</div>
		</div>

		<div class="mySlides fade" id="mySlides003">
			<img src="http://jjcom0214.cafe24.com/web/OneTrillion/korea.jpg"
				style="width: 100%">
			<div class="text">
				<div>한국의 이모저모</div>
			</div>
		</div>

		<a class="prev" onclick="plusSlides(-1)">&#10094;</a> <a class="next"
			onclick="plusSlides(1)">&#10095;</a>

	</div>
	<script>
		$("#mySlides001").click(function(){
			location.href="<%=request.getContextPath()%>/board/detail.do?pd_seq=113";
		})
		$("#mySlides002").click(function(){
			location.href="<%=request.getContextPath()%>/board/detail.do?pd_seq=9";
		})
		$("#mySlides003").click(function(){
			location.href="<%=request.getContextPath()%>
		/board/search.do";
		})
	</script>
	<br>

	<div style="text-align: center">
		<span class="dot" onclick="currentSlide(1)"></span> <span class="dot"
			onclick="currentSlide(2)"></span> <span class="dot"
			onclick="currentSlide(3)"></span>
	</div>



	<div id="first">
		<div id="themebox"
			style="margin: auto; position: relative; top: 10px;">
			<div id="textmargin"
				style="text-align: left; font: bold; font-size: 130%;">
				마음편하게 떠나볼까? <strong> 혼자여행 🪂</strong>
			</div>
			<div
				style="text-align: right; font-size: 15px; position: relative; top: -20px;">
				<a href="searchTheme.do?pd_theme=alone">더보기</a>
			</div>
		</div>
		<div class="swiper-container">
			<div class="swiper-wrapper">
				<c:forEach var="board" items="${aloneList }">
					<div class="swiper-slide">
						<img style="position: absolute;" src="${board.pd_image } "
							onclick="location.href='<%=request.getContextPath() %>/board/detail.do?pd_seq=${board.pd_seq}' ">
						<div class="hiddentext">${board.pd_name }</div>
					</div>
				</c:forEach>
			</div>
			<!-- 네비게이션 버튼 지정 -->
			<div class="swiper-button-next"></div>
			<!-- 다음 버튼 (오른쪽에 있는 버튼) -->
			<div class="swiper-button-prev"></div>
			<!-- 이전 버튼 -->

			<!-- 페이징 -->
			<div class="swiper-pagination"></div>
		</div>
	</div>
	<br>
	<br>
	<div id="second">
		<div id="themebox"
			style="margin: auto; position: relative; top: 10px;">
			<div style="text-align: left; font: bold; font-size: 130%;">
				새로운곳에서 차곡차곡 특별한 기억을 <strong> 커플 여행 🚘 </strong>
			</div>
			<div
				style="text-align: right; font-size: 15px; position: relative; top: -20px;">
				<a href="searchTheme.do?pd_theme=couple">더보기</a>
			</div>
		</div>
		<div class="swiper-container">
			<div class="swiper-wrapper">
				<c:forEach var="board" items="${coupleList }">
					<div class="swiper-slide">
						<img style="position: absolute;" src="${board.pd_image } "
							onclick="location.href='<%=request.getContextPath() %>/board/detail.do?pd_seq=${board.pd_seq}' ">
						<div class="hiddentext">${board.pd_name }</div>
					</div>
				</c:forEach>
			</div>
			<!-- 네비게이션 버튼 지정 -->
			<div class="swiper-button-next"></div>
			<!-- 다음 버튼 (오른쪽에 있는 버튼) -->
			<div class="swiper-button-prev"></div>
			<!-- 이전 버튼 -->

			<!-- 페이징 -->
			<div class="swiper-pagination"></div>
		</div>
	</div>
	<br>
	<br>
	<div id="first">
		<div id="themebox"
			style="margin: auto; position: relative; top: 10px;">
			<div style="text-align: left; font: bold; font-size: 130%;">
				잊지못할 추억을 우리같이 <strong> 우정여행 🚅</strong>
			</div>
			<div
				style="text-align: right; font-size: 15px; position: relative; top: -20px;">
				<a href="searchTheme.do?pd_theme=friend ">더보기</a>
			</div>
		</div>
		<div class="swiper-container">
			<div class="swiper-wrapper">
				<c:forEach var="board" items="${friendList }">
					<div class="swiper-slide">
						<img style="position: absolute;" src="${board.pd_image } "
							onclick="location.href='<%=request.getContextPath() %>/board/detail.do?pd_seq=${board.pd_seq}' ">
						<div class="hiddentext">${board.pd_name }</div>
					</div>
				</c:forEach>
			</div>
			<!-- 네비게이션 버튼 지정 -->
			<div class="swiper-button-next"></div>
			<!-- 다음 버튼 (오른쪽에 있는 버튼) -->
			<div class="swiper-button-prev"></div>
			<!-- 이전 버튼 -->

			<!-- 페이징 -->
			<div class="swiper-pagination"></div>
		</div>
	</div>
	<br>
	<br>
	<div id="second">
		<div id="themebox"
			style="margin: auto; position: relative; top: 10px;">
			<div style="text-align: left; font: bold; font-size: 130%;">
				반려동물과 함께 <strong> 반려동물여행 🐶</strong>
			</div>
			<div
				style="text-align: right; font-size: 15px; position: relative; top: -20px;">
				<a href="searchTheme.do?pd_theme=pet ">더보기</a>
			</div>
		</div>
		<div class="swiper-container swiper5">
			<div class="swiper-wrapper">
				<c:forEach var="board" items="${petList }">
					<div class="swiper-slide">
						<img style="position: absolute;" src="${board.pd_image } "
							onclick="location.href='<%=request.getContextPath() %>/board/detail.do?pd_seq=${board.pd_seq}' ">
						<div class="hiddentext">${board.pd_name }</div>
					</div>
				</c:forEach>
			</div>

			<!-- 네비게이션 버튼 지정 -->
			<div class="swiper-button-next"></div>
			<!-- 다음 버튼 (오른쪽에 있는 버튼) -->
			<div class="swiper-button-prev"></div>
			<!-- 이전 버튼 -->

			<!-- 페이징 -->
			<div class="swiper-pagination"></div>
		</div>
	</div>
	<br>
	<br>
	<div id="first">
		<div id="themebox"
			style="margin: auto; position: relative; top: 10px;">
			<div style="text-align: left; font: bold; font-size: 130%;">
				특별한곳에 누구보다 특별한 사람들이랑 <strong>가족여행 🧳</strong>
			</div>
			<div
				style="text-align: right; font-size: 15px; position: relative; top: -20px;">
				<a href="searchTheme.do?pd_theme=family ">더보기</a>
			</div>
		</div>
		<div class="swiper-container">
			<div class="swiper-wrapper">
				<c:forEach var="board" items="${familyList }">
					<div class="swiper-slide">
						<img style="position: absolute;" src="${board.pd_image } "
							onclick="location.href='<%=request.getContextPath() %>/board/detail.do?pd_seq=${board.pd_seq}' ">
						<div class="hiddentext">${board.pd_name }</div>
					</div>
				</c:forEach>
			</div>
			<!-- 네비게이션 버튼 지정 -->
			<div class="swiper-button-next"></div>
			<!-- 다음 버튼 (오른쪽에 있는 버튼) -->
			<div class="swiper-button-prev"></div>
			<!-- 이전 버튼 -->

			<!-- 페이징 -->
			<div class="swiper-pagination"></div>
		</div>
	</div>
	<br>
	<br>
	<div id="second">
		<div id="themebox"
			style="margin: auto; position: relative; top: 10px;">
			<div style="text-align: left; font: bold; font-size: 130%;">
				살면서 가장 기억에남을 <strong> 신혼여행 🚆</strong>
			</div>
			<div
				style="text-align: right; font-size: 15px; position: relative; top: -20px;">
				<a href="searchTheme.do?pd_theme=honeymoon ">더보기</a>
			</div>
		</div>
		<div class="swiper-container swiper5">
			<div class="swiper-wrapper">
				<c:forEach var="board" items="${honeymoonList }">
					<div class="swiper-slide">
						<img style="position: absolute;" src="${board.pd_image } "
							onclick="location.href='<%=request.getContextPath() %>/board/detail.do?pd_seq=${board.pd_seq}' ">
						<div class="hiddentext">${board.pd_name }</div>
					</div>
				</c:forEach>
			</div>
			<!-- 네비게이션 버튼 지정 -->
			<div class="swiper-button-next"></div>
			<!-- 다음 버튼 (오른쪽에 있는 버튼) -->
			<div class="swiper-button-prev"></div>
			<!-- 이전 버튼 -->

			<!-- 페이징 -->
			<div class="swiper-pagination"></div>
		</div>
	</div>
	<div style="height: 30px; background-color: rgb(250, 250, 250);"></div>

	<c:if test="${sessionScope.AD_ID != null }">
		<button id="adminLogout">관리자로그아웃</button>
	</c:if>
	<jsp:include page="../include/footer.jsp"></jsp:include>
</body>
<script>
$("#adminLogout").on("click", function(){
    if(confirm("정말 로그아웃 하시겠습니까?")){
    location.href = "<%=request.getContextPath()%>/admin/adminlogout.do";
    alert("로그아웃되었습니다");
    }
 });


	var coverflowSetting = {
		slideShadows : false, // 슬라이더 그림자 : 3D 효과를 강조하기 위한 회전시 흐릿한 효과
		rotate : 20, // 슬라이더 회전 각 : 클수록 슬라이딩시 회전이 커짐
		stretch : 0, // 슬라이더간 거리(픽셀) : 클수록 슬라이더가 서로 많이 겹침
		depth : 10, // 깊이 효과값 : 클수록 멀리있는 느낌이 강해짐
		modifier : 1, // 효과 배수 : 위 숫자값들에 이 값을 곱하기 처리하여 효과를 강하게 처리함
	}

	var myswiper = null;

	$(function() {
		var idHtml = $('A element: not("#testId")').html
		console.log(idHtml)
	});

	function init() {
		if (myswiper != null)
			myswiper.destroy();

		myswiper = new Swiper('.swiper-container', {
			slidesPerView : 5, // 동시에 보여줄 슬라이드 갯수
			spaceBetween : 5, // 슬라이드간 간격
			slidesPerGroup : 1, // 그룹으로 묶을 수, slidesPerView 와 같은 값을 지정하는게 좋음
			loopFillGroupWithBlank : true,
			loop : true, // 슬라이드 반복

			autoplay : { // 자동 재생
				delay : 3000, // 딜레이 0
			},
			speed : 1000, // 슬라이드 속도 2초

			navigation : {
				nextEl : '.swiper-button-next', // 다음 버튼 클래스명
				prevEl : '.swiper-button-prev', // 이번 버튼 클래스명
			},
		});
	}
	var slideIndex = 1;
	showSlides(slideIndex);

	function plusSlides(n) {
		showSlides(slideIndex += n);
	}

	function currentSlide(n) {
		showSlides(slideIndex = n);
	}

	function showSlides(n) {
		var i;
		var slides = document.getElementsByClassName("mySlides");
		var dots = document.getElementsByClassName("dot");
		if (n > slides.length) {
			slideIndex = 1
		}
		if (n < 1) {
			slideIndex = slides.length
		}
		for (i = 0; i < slides.length; i++) {
			slides[i].style.display = "none";
		}
		for (i = 0; i < dots.length; i++) {
			dots[i].className = dots[i].className.replace(" active", "");
		}
		slides[slideIndex - 1].style.display = "block";
		dots[slideIndex - 1].className += " active";
	}
	var slideIndex = 0;
	carousel();

	function carousel() {
		var i;
		var x = document.getElementsByClassName("mySlides");
		for (i = 0; i < x.length; i++) {
			x[i].style.display = "none";
		}
		slideIndex++;
		if (slideIndex > x.length) {
			slideIndex = 1
		}
		x[slideIndex - 1].style.display = "block";
		setTimeout(carousel, 2000); // Change image every 2 seconds
	}
	//$(".mySlides img").mouseover(function() {

	init();
	$(".swiper-container").hover(function() {
		(this).swiper.autoplay.stop();
	}, function() {
		(this).swiper.autoplay.start();
	});
	$(document).ready(function() {
		$(".swiper-slide>img").mouseover(function() {
			$($(this).next()).css("display", "block");
			$(this).css("filter", "brightness(60%)");
		});
		$(".swiper-slide>img").mouseout(function() {
			$($(this).next()).css("display", "none");
			$(this).css("filter", "brightness(100%)");
		});
		$(".hiddentext").mouseover(function() {
			$(this).css("display", "block");
			$($(this).prev()).css("filter", "brightness(60%)");
		});
		$(".hiddentext").mouseout(function() {
			$(this).css("display", "none");
			$($(this).prev()).css("filter", "brightness(100%)");
		});
	});
</script>
</html>