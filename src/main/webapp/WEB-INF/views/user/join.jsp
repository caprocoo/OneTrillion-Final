<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- 유효성 검사를 위한 taglib 3개 -->
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<!-- 우편번호 API -->
<script
	src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<jsp:include page="../include/header2.jsp"></jsp:include>
</head>
<style>
*{
	margin: 0;
	padding: 0;
	text-decoration: none;
	}

#joinDiv001 {
	margin: auto;
	width: 500px;
	height: 800px;
	}

#joinDiv001>input {
	border: 0;
	width: 500px;
	height: 50px;
	font-size: 110%;
	background-color: gainsboro;
	text-align: center;
	}

.regex {
	font-size: 12px;
	text-align: center;
	}
.joinLine{height: 2px;}

#joinDiv001>input:hover{background-color: #f8f8fa;}
#zipBtn, #signupbtn, #resignupbtn{color: white;}
#zipBtn:hover, #signupbtn:hover, #resignupbtn:hover{cursor: pointer; color: red;}

</style>

<body>
	<h1 style="margin-top: 70px; text-align: center;">OneTrillion Member Join</h1>
	<%-- <form:form modelAttribute="userDTO" method="post" id="signform"> --%>
	<form action="join.do" method="POST" id="signform">
		<div id="joinDiv001">
			<div style="height: 70px;"></div>
			<!-- 아이디 입력칸 --------------------------------------------------------------------->
			<input type="text" name="u_id" id="id" value="" placeholder="아이디를 입력하세요" style="border-radius: 15px 15px 0px 0px;">
			<div class="id regex"></div>
			<div class="joinLine"></div>
			<%-- <form:input path="u_id" id="u_id" name="u_id" type="text"/>
			<form:errors path="u_id" /> --%>
			<!-- 비밀번호 입력 칸 --------------------------------------------------------------------->
			<input type="password" name="u_pwd" id="pw" placeholder="비밀번호를 입력하세요">
			<div class="pw regex"></div>
			<div class="joinLine"></div>
			<%-- <form:input path="u_pwd" id="u_pwd" name="u_pwd" type="password"/>
			<form:errors path="u_pwd" /> --%>
			<!-- 비밀번호 확인 입력 칸 --------------------------------------------------------------------->
			<input type="password" id="repw" placeholder="비밀번호를 다시한번 입력하세요">
			<div class="repw regex"></div>
			<div class="joinLine"></div>
			<!-- 이름 입력 칸 --------------------------------------------------------------------->
			<input type="text" name="u_nickName" id="name" placeholder="성함을 입력하세요">
			<div class="name regex"></div>
			<div class="joinLine"></div>
			<!-- 이메일 입력 칸 --------------------------------------------------------------------->
			<input type="text" name="u_email" id="email" placeholder="이메일을 입력하세요">
			<div class="email regex"></div>
			<div class="joinLine"></div> 
			<!-- 전화번호 입력 칸 --------------------------------------------------------------------->
			<!-- <input class=joinDiv001_input001 type="text" name="u_tel" id="phone" placeholder="전화번호를 입력하세요">
			<div class="phone regex"></div>
			<div class="joinLine"></div>
            우편번호 입력 칸 -------------------------------------------------------------------
	        <input type="text" id="postcode" placeholder="우편번호" name="zipcode" style="float:left; width:249px; " readonly><input id="zipBtn" type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기" style="float:right;width:249px; background-color: black;">
	        <div class="regex" style="clear:both"></div>
	        <div class="joinLine"></div>
	        <input type="text" id="roadAddress" placeholder="도로명주소" name="u_address1" readonly>
	        <div class="regex"></div>
	        <div class="joinLine"></div>
	        <input type="text" id="detailAddress" placeholder="상세주소를 입력하세요" name="u_address2">
	        <div class="regex"></div>
	        <div class="joinLine"></div> -->
			<input type="submit" name="signup" value="작성완료" id="signupbtn" style="float:left; width:249px; background-color: black; border-radius: 0px 0px 0px 15px;"><input type="reset" value="다시입력" id="resignupbtn" style="float:right;width:249px; background-color: black; border-radius: 0px 0px 15px 0px;">
		</div>
	 </form> 
	<%-- </form:form> --%>

	<script>

		$('input#id').keyup(function() {
			
			var inputId = $(this).val();
			var regex = /^[A-Za-z\d]{8,15}$/;
			var result = regex.exec(id);
			var sendUrl = "http://localhost:8088/trip/user/idCheckAjax.do?id=" + inputId;
			$(".id.regex").html("영어 대소문자와 숫자를 혼합하여 8-15자리로 입력하세요.");
			$(".id.regex").css("color", "red");
			
			if(inputId.length > 7 && inputId.length < 16){
				
				$.get(sendUrl, function(data, status) {
					if(status === 'success') {
						if(data === 'possible') {
							$(".id.regex").html("사용가능한 아이디입니다!");
							$(".id.regex").css("color", "red");
						} else if(inputId.length > 7 && inputId.length < 16){
							$(".id.regex").html("영어 대소문자와 숫자를 혼합하여 8-15자리로 입력하세요.");
							$(".id.regex").html("이미 존재하는 아이디입니다!");
							$(".id.regex").css("color", "red");
						}
					} else{
						$(".id.regex").html("영어 대소문자와 숫자를 혼합하여 8-15자리로 입력하세요.");
						$(".id.regex").css("color", "red");
					}
				});
			}
		});// keyup 종료
		
		

		// 실행함수 ----------------------------------------------------------------------
		$(function() {

			//비밀번호 유효성검사
			$("#pw").on("input", function() {
				var regex = /^[A-Za-z\d]{8,15}$/;
				var result = regex.exec($("#pw").val())

				if (result != null) {
					$(".pw.regex").html("");
				} else {
					$(".pw.regex").html("영어 대소문자와 숫자를 혼합하여 8-15자리로 입력하세요.");
					$(".pw.regex").css("color", "red");
				}
			});

			// 입력한 비밀번호끼리 맞는지 확인 (이중체크)  
			$("#repw").on("keyup", function() {
				if ($("#pw").val() == $("#repw").val()) {
					$(".repw.regex").html("비밀번호가 일치합니다");
					$(".repw.regex").css("color", "red");
				} else {
					$(".repw.regex").html("비밀번호가 일치하지않습니다");
					$(".repw.regex").css("color", "red");
				}
			})

			//이름 유효성검사
			$("#name").on("input", function() {
				var regex = /[가-힣]{2,}/;
				var result = regex.exec($("#name").val());

				if (result != null) {
					$(".name.regex").html("");
				} else {
					$(".name.regex").html("한글만 입력 가능합니다.");
					$(".name.regex").css("color", "red");
				}

			})

		

			// 이메일 유효성 검사
			$("#email").on("input", function() {
				var regex = /.+@[a-z]+(\.[a-z]+){1,2}$/;
				var result = regex.exec($("#email").val());

				if (result != null) {
					$(".email.regex").html("");
				} else {
					$(".email.regex").html("올바른 이메일이 아닙니다");
					$(".email.regex").css("color", "red");
				}
			})

			//회원가입 버튼 눌렀을 때, 빈칸 있으면 다시 유효성 검사 진행    
			$("#signupbtn").on("click", function() {
				var id = $("#id").val();
				var pw = $("#pw").val();
				var name = $("#name").val();
				var email = $("#email").val();

				var idregex = /^[A-Za-z\d]{8,15}$/;
				var pwregex = /^[A-Za-z\d]{8,15}$/;
				var nameregex = /[가-힣]{2,}/;
				var emailregex = /.+@[a-z]+(\.[a-z]+){1,2}$/;

				
				
				var idregexc = idregex.exec(id);
				if (idregexc == null) {
					alert("아이디 양식을 다시 확인해주세요");
					return;
				}
				
				var pwregexc = pwregex.exec(pw);
				if (pwregexc == null) {
					alert("비밀번호 양식을 다시 확인해주세요");
					return;
				}

				var nameregexc = nameregex.exec(name);
				if (nameregexc == null) {
					alert("이름 양식을 다시 확인해주세요");
					return;
				}

				var emailregexc = emailregex.exec(email);
				if (emailregexc == null) {
					alert("이메일 양식을 다시 확인해주세요");
					return;
				}

				//빈칸이 없으면 제출~
				$("#signform").submit();
				alert("회원가입 성공");
			})
		})
	</script>
<jsp:include page="../include/footer.jsp"></jsp:include>
</body>
</html>