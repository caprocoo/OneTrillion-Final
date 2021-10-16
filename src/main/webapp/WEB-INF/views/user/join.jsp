<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!-- 유효성 검사를 위한 taglib 3개 -->
        <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
            <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
                <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
                    <!DOCTYPE html>
                    <html lang="en">

                    <head>
                        <meta charset="UTF-8">
                        <meta hloginp-equiv="X-UA-Compatible" content="IE=edge">
                        <meta name="viewport" content="width=device-width, initial-scale=1.0">
                        <title>회원가입 페이지</title>
                        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
                        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
                            rel="stylesheet"
                            integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
                            crossorigin="anonymous">
                        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
                            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
                            crossorigin="anonymous"></script>
                        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"
                            integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB"
                            crossorigin="anonymous"></script>
                        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"
                            integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13"
                            crossorigin="anonymous"></script>
                    </head>
                    <style>
                        * {
                            margin: 0;
                            padding: 0;
                            text-decoration: none;
                        }

                        #logindiv01 {
                            width: 100%;
                            height: 95vh;
                        }

                        #logintable01 {
                            margin: auto;
                            width: 400px;
                            height: 100%;
                        }

                        .input-group-sm {
                            width: 400px;
                            height: 45px;
                            margin-bottom: 5px;
                        }

                        .btn-dark {
                            width: 197px;
                            height: 45px;
                            margin-bottom: 40px;
                        }

                        .btn-secondary {
                            width: 197px;
                            height: 45px;
                            margin-bottom: 40px;
                        }

                        .btn-primary {
                            height: 45px;
                            width: 197px;
                            margin-bottom: 5px;
                        }

                        .btn-success {
                            height: 45px;
                            width: 197px;
                            margin-bottom: 5px;
                            margin-right: 5px;
                        }

                        .loginA01 {
                            color: gray;
                            text-decoration: none;
                        }

                        .loginA01:hover {
                            color: black;
                        }

                        .input-group {
                            height: 45px;
                            margin-bottom: 5px;
                        }

                        .input-group-text {
                            width: 70px;
                        }

                        .form-control {
                            height: 45px;
                            margin-bottom: 10px;
                        }

                        .regex {
                            font-size: 80%;
                        }
                    </style>

                    <body>
                        <% String u_id=(String) session.getAttribute("u_id"); if( u_id !=null){%>
                            <%}%>
                                <div id="logindiv01">
                                    <table id="logintable01">
                                        <tr>
                                            <td>
                                                <div>
                                                    <form action="join.do" method="POST" id="signform">
                                                        <div style="text-align: center;"><img
                                                                style="width: 300px; margin-bottom: 40px;"
                                                                src="http://jjcom0214.cafe24.com/web/OneTrillion/logo02.png"
                                                                alt="logo01">
                                                        </div>

                                                        <!-- 아이디 입력칸 --------------------------------------------------------------------->
                                                        <div class="">
                                                            <label for="formGroupExampleInput"
                                                                class="form-label">ID</label>
                                                            <span class="id regex" style="float: right;"></span>
                                                            <input type="text" id="id" name="u_id" class="form-control"
                                                                id="formGroupExampleInput" placeholder="아이디를 입력하세요">
                                                        </div>
                                                        <!-- 아이디 입력칸 --------------------------------------------------------------------->

                                                        <!-- 비밀번호 입력 칸 --------------------------------------------------------------------->
                                                        <div class="">
                                                            <label for="formGroupExampleInput"
                                                                class="form-label">Password</label>
                                                            <span class="u_pwd regex" style="float: right;"></span>
                                                            <input type="password" id="u_pwd" name="u_pwd"
                                                                class="form-control" id="formGroupExampleInput"
                                                                placeholder="비밀번호를 입력하세요">
                                                        </div>
                                                        <!-- 비밀번호 입력 칸 --------------------------------------------------------------------->

                                                        <!-- 비밀번호 확인 입력 칸 --------------------------------------------------------------------->
                                                        <div class="">
                                                            <label for="formGroupExampleInput"
                                                                class="form-label">Password</label>
                                                            <span class="repw regex" style="float: right;"></span>
                                                            <input type="password" id="repw" class="form-control"
                                                                id="formGroupExampleInput"
                                                                placeholder="비밀번호를 다시한번 입력하세요">
                                                        </div>
                                                        <!-- 비밀번호 확인 입력 칸 --------------------------------------------------------------------->

                                                        <!-- 닉네임 입력 칸 --------------------------------------------------------------------->
                                                        <div class="">
                                                            <label for="formGroupExampleInput"
                                                                class="form-label">NickName</label>
                                                            <span class="u_nickName regex" style="float: right;"></span>
                                                            <input type="text" id="u_nickName" name="u_nickName"
                                                                class="form-control" id="formGroupExampleInput"
                                                                placeholder="닉네임을 입력하세요">
                                                        </div>
                                                        <!-- 이름 입력 칸 --------------------------------------------------------------------->

                                                        <!-- 이메일 입력 칸 --------------------------------------------------------------------->
                                                        <div class="">
                                                            <label for="formGroupExampleInput"
                                                                class="form-label">Email</label>
                                                            <span class="email regex" style="float: right;"></span>
                                                            <input type="text" id="email" name="u_email"
                                                                class="form-control" id="formGroupExampleInput"
                                                                placeholder="이메일을 입력하세요">
                                                        </div>
                                                        <!-- 이메일 입력 칸 --------------------------------------------------------------------->

                                                        <div>
                                                            <input type="submit" class="btn btn-dark" name="signup"
                                                                id="signupbtn" value="Join">
                                                            <input type="reset" class="btn btn-secondary"
                                                                id="resignupbtn" value="다시입력">
                                                        </div>
                                                        <div
                                                            style="margin-bottom: 10px; font-size: 80%; color: gray; text-align: center;">
                                                            간편하게 가입하기
                                                        </div>
                                                        <button type="button"
                                                            class="btn btn-success">Naver</button><button type="button"
                                                            class="btn btn-primary">Google</button>
                                                    </form>
                                                </div>
                                            </td>
                                        </tr>
                                    </table>
                                </div>
                                <script>

                                    $("#resignupbtn").on("click", function () {
                                        if ($(".id").val() != null || $(".u_pwd").val() != null || $(".u_nickName").val() != null || $(".email").val() != null || $(".repw").val() != null)
                                            $(".id").html("");
                                        $(".u_pwd").html("");
                                        $(".repw").html("");
                                        $(".u_nickName").html("");
                                        $(".email").html("");
                                    });

                                    $('input#email').keyup(function () {
                                        var inputEmail = $(this).val();
                                        var sendUrl = "http://localhost:8088/trip/user/emailCheckAjax.do?email=" + inputEmail;
                                        var regex = /.+@[a-z]+(\.[a-z]+){1,2}$/;
                                        var result = regex.exec($("#email").val());
                                        $.get(sendUrl, function (data, status) {
                                            if (status == 'success') {
                                                if (result == null || data == 'impossible') {
                                                    $(".email").html("이메일 양식이 아니거나 존재하는 이메일 입니다.");
                                                    $(".email").css("color", "gray");
                                                } else if (result != null && data == 'possible') {
                                                    $(".email").html("사용 가능한 이메일입니다.");
                                                } else {
                                                    $(".email").html("");
                                                }
                                            } else {
                                                alert("오류가 생겼습니다!")
                                            }
                                        });
                                    });// keyup 종료





                                    $('input#id').keyup(function () {
                                        var inputId = $(this).val();
                                        var regex = /^[A-Za-z0-9\d]{8,15}$/;
                                        var regexspc = /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣~!@#$%^&*()_+|<>?:{}]/;
                                        var result = regex.exec($("#id").val());
                                        var resultspc = regexspc.exec($("#id").val());
                                        var sendUrl = "http://localhost:8088/trip/user/idCheckAjax.do?id=" + inputId;
                                        $.get(sendUrl, function (data, status) {
                                            if (status === 'success') {
                                                if (data === 'possible' && inputId != "") {
                                                    $(".id").html("영어 대소문자와 숫자를 혼합하여 8-15자리로 입력하세요 (특수문자 한글제외)");
                                                    $(".id").css("color", "gray");
                                                    if (inputId.length > 7 && inputId.length < 16 && resultspc == null && result != null) {
                                                        $(".id").html("사용가능한 아이디입니다!");
                                                    }
                                                } else if (data === "impossible") {
                                                    $(".id").html("이미 존재하는 아이디입니다!");
                                                    $(".id").css("color", "gray");
                                                } else {
                                                    $(".id").html("");
                                                }

                                            } else {
                                                alert("오류가 생겼습니다!")
                                            }
                                        });

                                    });// keyup 종료


                                    // 실행함수 ----------------------------------------------------------------------
                                    $(function () {

                                        //비밀번호 유효성검사
                                        $("#repw").prop("readonly", true)
                                        $("#u_pwd").keyup(function () {
                                            var regex = /^[a-zA-Z0-9\d]{8,15}$/;
                                            var regexspc = /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣~!@#$%^&*()_+|<>?:{}]/;
                                            var result = regex.exec($("#u_pwd").val());
                                            var resultspc = regexspc.exec($("#u_pwd").val());

                                            if (result == null && $("#u_pwd").val() != "") {
                                                $(".u_pwd").html("영어와 숫자를 혼합하여 8-15자리로 입력하세요");
                                                $(".u_pwd").css("color", "gray")
                                                $("#repw").prop("readonly", true)
                                                
                                            }else{
                                            	$(".u_pwd").html("");
                                                $("#repw").prop("readonly", false)

                                            }
							
                                        });

                                        // 입력한 비밀번호끼리 맞는지 확인 (이중체크)  
                                        $("#repw").on("keyup", function () {
                                            if ($("#u_pwd").val() == $("#repw").val()) {
                                                $(".repw").html("비밀번호가 일치합니다");
                                                $(".repw").css("color", "gray");
                                            } else if ($("#u_pwd").val() != $("#repw").val()) {
                                                $(".repw").html("비밀번호가 일치하지않습니다");
                                                $(".repw").css("color", "gray");
                                            } else if ($("#u_pwd").val() != "" && $("#repw").val() == "") {
                                                $(".repw").html("");
                                            } else if ($("#u_pwd").val() == "" && $("#repw").val() != "") {
                                                $(".repw").html("");
                                            }
                                        });
                                        
                                        $("#u_pwd").on("change", function(){
                                        	if($("#u_pwd").val() == ""){
                                        		$("#repw").prop("readonly", true)
                                        	}
                                        })


                                        //이름 유효성검사 진행중 10/08
                                        $("#u_nickName").on("input", function () {
                                            var regex = /[가-힣]{2,}/;
                                            var result = regex.exec($("#u_nickName").val());
                                            var result_empty = $("#u_nickName").val() == "";
                                            if (result != null) {
                                                $(".u_nickName").html("");
                                            } else if (result_empty) {
                                                $(".u_nickName").html("");
                                            } else if (result == null) {
                                                $(".u_nickName").html("한글로 2글자 이상 작성해주세요.");
                                                $(".u_nickName").css("color", "gray");
                                            }
                                        });

                                        //회원가입 버튼 눌렀을 때, 빈칸 있으면 다시 유효성 검사 진행    
                                        $("#signupbtn").on("click", function () {
                                            var id = $("#id").val();
                                            var pw = $("#u_pwd").val();
                                            var name = $("#u_nickName").val();
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

                    </body>

                    </html>