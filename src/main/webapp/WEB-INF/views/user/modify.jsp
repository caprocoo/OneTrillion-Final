<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- 우편번호 API -->
<script
	src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>

<title>Insert title here</title>
</head>
<style>
* {
	margin-top:500px;
	text-align: center;
}


</style>

<body>
	<c:if test="${sessionScope.u_id != null }">
		<jsp:include page="../include/header2_user.jsp"></jsp:include>
	</c:if>

<br>
<br>
<br>
<br>
<br>
<br>

<%
	// 로그인 처리 -> 로그인 x (로그인페이지 이동)
	String u_id = (String) session.getAttribute("u_id");
	String AD_ID = (String) session.getAttribute("AD_ID");
	if( u_id != null || AD_ID != null){
	}else{%>
		<script> alert('로그인이 필요합니다.'); window.location.href="http://localhost:8088/trip/user/login.do"; </script>
<%}%>
  


		<form action="modify.do" method="POST" id="success">
			<div >
				아이디 : <input type="text" id="id" name="u_id" value="${u_id}" readonly="readonly" />
			</div> 
			<div>
				비밀번호 : <input type="password" id="pw" name="u_pwd" />
				<div class="pw regex"></div>
			</div>
			<div>
				비밀번호 확인 : <input type="password" id="repw"/>
				<div class="repw regex"></div>
			</div>
			<div>
				이름 : <input type="text" id="name" name="u_name" value="${dto.u_name}" />
				<div class="name regex"></div>
			</div>
			<div>
				전화번호 : <input type="text" id="phone" name="u_tel" value="${dto.u_tel}" />
				<div class="phone regex"></div>
			</div>
			<div>
				우편번호 : <input type="text" id="postcode" name="zipcode" value="${dto.zipcode}" />
				  		<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기"><br>
			</div>
			<div>
				도로명주소 : <input type="text"  id="roadAddress" placeholder="도로명주소" name="u_address1" value="${dto.u_address1}" />
			</div>
			<div>
				상세주소 : <input type="text" id="detailAddress" name="u_address2" value="${dto.u_address2}" />
			</div>
	
			<div>
				이메일 : <input type="email" id="email" name="u_email" value="${dto.u_email}" />
				<div class="email regex"></div>
			</div>
			
			<div>
				<input type="submit" value="회원정보수정" id="modifyBtn">
				<input type="button" id="cancle" value="돌아가기" onclick="location.href='myPage.do?u_id=${u_id}'">
			</div>
		</form>


<script>

//다음 우편번호 API
function sample4_execDaumPostcode() {
	new daum.Postcode({
		oncomplete : function(data) {
			// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분
			// 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
			// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
			var roadAddr = data.roadAddress; // 도로명 주소 변수
			var extraRoadAddr = ''; // 참고 항목 변수
			// 법정동명이 있을 경우 추가한다. (법정리는 제외)
			// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
			if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
				extraRoadAddr += data.bname;
			}
			// 건물명이 있고, 공동주택일 경우 추가한다.
			if (data.buildingName !== '' && data.apartment === 'Y') {
				extraRoadAddr += (extraRoadAddr !== '' ? ', '
						+ data.buildingName : data.buildingName);
			}

			// 우편번호와 주소 정보를 해당 필드에 넣는다.
			document.getElementById('postcode').value = data.zonecode;
			document.getElementById("roadAddress").value = roadAddr;
		}
	}).open();
}





	
	
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

			//전화번호 유효성검사
			$("#phone").on("input", function() {
				var regex = /^01\d\d{3,4}\d{4}$/;
				var result = regex.exec($("#phone").val());

				if (result != null) {
					$(".phone.regex").html("");
				} else {
					$(".phone.regex").html("올바른 전화번호가 아닙니다");
					$(".phone.regex").css("color", "red");
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

			//수정버튼 눌렀을 때, 빈칸 있으면 다시 유효성 검사 진행    
			$("#modifyBtn").on("click", function() {
				var pw = $("#pw").val();
				var name = $("#name").val();
				var phone = $("#phone").val();
				var email = $("#email").val();

				var pwregex = /^[A-Za-z\d]{8,15}$/;
				var nameregex = /[가-힣]{2,}/;
				var phoneregex = /^01\d\d{3,4}\d{4}$/;
				var emailregex = /.+@[a-z]+(\.[a-z]+){1,2}$/;

				//var idregex = idregex.exec(id);
				//if (idregex == null) {
					//alert("아이디 양식을 다시 확인해주세요");
					//return;
				//}

				var pwregex = pwregex.exec(pw);
				if (pwregex == null) {
					alert("비밀번호 양식을 다시 확인해주세요");
					retrun;
				}

				var nameregex = nameregex.exec(name);
				if (nameregex == null) {
					alert("이름 양식을 다시 확인해주세요");
					retrun;
				}

				var phoneregex = phoneregex.exec(phone);
				if (phoneregex == null) {
					alert("전화번호 양식을 다시 확인해주세요");
					retrun;
				}

				var emailregex = emailregex.exec(email);
				if (emailregex == null) {
					alert("이메일 양식을 다시 확인해주세요");
					retrun;

				}

				//빈칸이 없으면 제출~
				$("#success").submit();
				alert("회원정보 수정 성공!");
			})
		})
	
	
	
	
</script>
</body>

</html>