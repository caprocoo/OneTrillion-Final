<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>관리자 메인 페이지</title>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"
        integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"
        integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13"
        crossorigin="anonymous"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>    
    <style>
        * {
            margin: 0;
            padding: 0;
        }

        .list-group-item:hover {
        	cursor: pointer;
            background-color: #f8f9fa;
        }

        .adminMainDiv1 {
            width: 450px;
            height: 300px;
            border-radius: 20px;
            box-shadow: 0 0 20px #ededed;
            margin-top: 40px;
            display: inline-block;
        }

        .adminMainDiv1 p {
            margin-bottom: 0;
            line-height: 45px;
            text-align: center;
            font-weight: bold;
            background-color: #ededed;
            border-radius: 20px 20px 0 0;
        }
    </style>
</head>

<body>
	<script type="text/javascript">
		function userResList(){ //회원예약
			location.href = "http://localhost:8088/trip/adminUserRes/list.do"
		}		
		function userManagement(){ // 회원관리
			location.href = "http://localhost:8088/trip/adminUserManagement/userList"
		}
		function priQueList(){ //1:1문의
			location.href = "http://localhost:8088/trip/admin/list.do"
		}
		function noticeList(){ //공지사항
			location.href = "http://localhost:8088/trip/adminNotice/list.do"
		}
		function oftenList(){ //자주묻는질문
			location.href = "http://localhost:8088/trip/adminOften/list.do"
		}
	
>>>>>>> cf9ad493eb8776f56cd9a5906d2bef327e19e787
	</script>

    <div style="width: 1800px; height: 100vh;">
        <div style="float: left; width: 250px; height: 100%; box-shadow: 0 0 20px #ededed; position: fixed;">
            <div style="margin:auto; width: 80%;"><img style="width: 100%; margin-top: 40px; margin-bottom: 40px;"
                    src="http://jjcom0214.cafe24.com/web/OneTrillion/logo02.png" alt="logo01"></div>
            <div>            		
                <ul class="list-group list-group-flush">
                    <li class="list-group-item" onclick="">메인</li>
                    <li class="list-group-item" onClick="userResList()">회원예약리스트</li>
                    <li class="list-group-item" onclick="">비회원예약</li>
                    <li class="list-group-item" onclick="priQueList()">문의</li>
                    <li class="list-group-item" onclick="">리뷰</li>
                    <li class="list-group-item" onclick="userManagement()">회원</li>
                    <li class="list-group-item" onclick="">상품</li>
                    <li class="list-group-item" onclick="">관리자</li>
                    <li class="list-group-item" onclick="">찜</li>
                    <li class="list-group-item" onclick="noticeList()">공지사항</li>
                    <li class="list-group-item" onclick="oftenList()">자주질문</li>
                    <li class="list-group-item" onclick="">로그기록</li>
                    <li class="list-group-item" onclick="">메모장</li>

                </ul>
            </div>
            <c:if test="${sessionScope.AD_ID != null }">
				<a id="adminLogout" style="cursor: pointer; color: purple; padding: 30px;">${AD_ID } 로그아웃</a>
			</c:if>
        </div>
        <div style="float:right; width: 1500px;height: 100%;">
            <div style="width: 1500px; column-count: 3;">
            
            
                <div class="adminMainDiv1">
                    <p>예약</p>
                    <table class="table">
                        <thead>
                            <tr>
                                <th scope="col">예약번호</th>
                                <th scope="col">등록날짜</th>
                                <th scope="col">확인상태</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!--예약 forEach 문 시작 최신 날짜기준으로 4개만 노출 시켜야 함 ------->
                            <tr>
                                <td>Otto</td>
                                <td>@mdo</td>
                                <td>New</td>
                            </tr>
                            <tr>
                                <td>Thornton</td>
                                <td>@fat</td>
                                <td>Checked</td>
                            </tr>
                            <tr>
                                <td>the Bird</td>
                                <td>@twitter</td>
                                <td>Checked</td>
                            </tr>
                            <tr>
                                <td>the Bird</td>
                                <td>@twitter</td>
                                <td>Checked</td>
                            </tr>
                            <!--예약 forEach 문 끝--------------------------------------------->
                        </tbody>
                    </table>
                </div>
                <div class="adminMainDiv1">
                    <p>문의</p>
                    <table class="table">
                        <thead>
                            <tr>
                                <th scope="col">고객 ID</th>
                                <th scope="col">등록날짜</th>
                                <th scope="col">답변상태</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!--문의 forEach 문 시작 최신 날짜기준으로 4개만 노출 시켜야 함 ------->
                            <tr>
                                <td>Mark</td>
                                <td>Otto</td>
                                <td>New</td>
                            </tr>
                            <tr>
                                <td>Jacob</td>
                                <td>Thornton</td>
                                <td>Checked</td>
                            </tr>
                            <tr>
                                <td>Larry</td>
                                <td>the Bird</td>
                                <td>Checked</td>
                            </tr>
                            <tr>
                                <td>Larry</td>
                                <td>the Bird</td>
                                <td>Checked</td>
                            </tr>
                            <!--문의 forEach 문 끝--------------------------------------------->
                        </tbody>
                    </table>
                </div>
                <div class="adminMainDiv1">
                    <p>상품</p>
                    <table class="table">
                        <thead>
                            <tr>
                                <th scope="col">상품번호</th>
                                <th scope="col">등록날짜</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!--상품 forEach 문 시작 최신 날짜기준으로 4개만 노출 시켜야 함 ------->
                            <tr>
                                <td>Mark</td>
                                <td>Otto</td>
                            </tr>
                            <tr>
                                <td>Jacob</td>
                                <td>Thornton</td>
                            </tr>
                            <tr>
                                <td>Larry</td>
                                <td>the Bird</td>
                            </tr>
                            <tr>
                                <td>Larry</td>
                                <td>the Bird</td>
                            </tr>
                            <!--상품 forEach 문 끝--------------------------------------------->
                        </tbody>
                    </table>
                </div>
                <div class="adminMainDiv1">
                    <p>관리자</p>
                    <table class="table">
                        <thead>
                            <tr>
                                <th scope="col">관리자 ID</th>
                                <th scope="col">로그인날짜</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!--관리자 forEach 문 시작 최신 날짜기준으로 4개만 노출 시켜야 함 ------->
                            <tr>
                                <td>Otto</td>
                                <td>@mdo</td>
                            </tr>
                            <tr>
                                <td>Thornton</td>
                                <td>@fat</td>
                            </tr>
                            <tr>
                                <td>the Bird</td>
                                <td>@twitter</td>
                            </tr>
                            <tr>
                                <td>the Bird</td>
                                <td>@twitter</td>
                            </tr>
                            <!--관리자 forEach 문 끝--------------------------------------------->
                        </tbody>
                    </table>
                </div>
                <div class="adminMainDiv1">
                    <p>리뷰</p>
                    <table class="table">
                        <thead>
                            <tr>
                                <th scope="col">고객 ID</th>
                                <th scope="col">등록날짜</th>
                                <th scope="col">확인상태</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!--리뷰 forEach 문 시작 최신 날짜기준으로 4개만 노출 시켜야 함 ------->
                            <tr>
                                <td>Mark</td>
                                <td>Otto</td>
                                <td>New</td>
                            </tr>
                            <tr>
                                <td>Jacob</td>
                                <td>Thornton</td>
                                <td>Checked</td>
                            </tr>
                            <tr>
                                <td>Larry</td>
                                <td>the Bird</td>
                                <td>Checked</td>
                            </tr>
                            <tr>
                                <td>Larry</td>
                                <td>the Bird</td>
                                <td>Checked</td>
                            </tr>
                            <!--리뷰 forEach 문 끝--------------------------------------------->
                        </tbody>
                    </table>
                </div>
                <div class="adminMainDiv1">
                    <p>회원</p>
                    <table class="table">
                        <thead>
                            <tr>
                                <th scope="col">고객 ID</th>
                                <th scope="col">가입날짜</th>
                                <th scope="col">확인상태</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!--회원 forEach 문 시작 최신 날짜기준으로 4개만 노출 시켜야 함 ------->
                            <tr>
                                <td>Mark</td>
                                <td>Otto</td>
                                <td>New</td>
                            </tr>
                            <tr>
                                <td>Jacob</td>
                                <td>Thornton</td>
                                <td>Checked</td>
                            </tr>
                            <tr>
                                <td>Larry</td>
                                <td>the Bird</td>
                                <td>Checked</td>
                            </tr>
                            <tr>
                                <td>Larry</td>
                                <td>the Bird</td>
                                <td>Checked</td>
                            </tr>
                            <!--회원 forEach 문 끝--------------------------------------------->
                        </tbody>
                    </table>
                </div>
                <div class="adminMainDiv1">
                    <p>자주질문</p>
                    <table class="table">
                        <thead>
                            <tr>
                                <th scope="col">제목</th>
                                <th scope="col">등록날짜</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!--자주질문 forEach 문 시작 최신 날짜기준으로 4개만 노출 시켜야 함 ------->
                            <tr>
                                <td>Otto</td>
                                <td>@mdo</td>
                            </tr>
                            <tr>
                                <td>Thornton</td>
                                <td>@fat</td>
                            </tr>
                            <tr>
                                <td>the Bird</td>
                                <td>@twitter</td>
                            </tr>
                            <tr>
                                <td>the Bird</td>
                                <td>@twitter</td>
                            </tr>
                            <!--자주질문 forEach 문 끝--------------------------------------------->
                        </tbody>
                    </table>
                </div>
                <div class="adminMainDiv1">
                    <p>공지사항</p>
                    <table class="table">
                        <thead>
                            <tr>
                                <th scope="col">제목</th>
                                <th scope="col">등록날짜</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!--공지사항 forEach 문 시작 최신 날짜기준으로 4개만 노출 시켜야 함 ------->
                            <tr>
                                <td>Otto</td>
                                <td>@mdo</td>
                            </tr>
                            <tr>
                                <td>Thornton</td>
                                <td>@fat</td>
                            </tr>
                            <tr>
                                <td>the Bird</td>
                                <td>@twitter</td>
                            </tr>
                            <tr>
                                <td>the Bird</td>
                                <td>@twitter</td>
                            </tr>
                            <!--공지사항 forEach 문 끝--------------------------------------------->
                        </tbody>
                    </table>
                </div>
                <div class="adminMainDiv1">
                    <p>찜</p>
                    <table class="table">
                        <thead>
                            <tr>
                                <th scope="col">고객 ID</th>
                                <th scope="col">등록날짜</th>
                                <th scope="col">확인상태</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!--찜 forEach 문 시작 최신 날짜기준으로 4개만 노출 시켜야 함 ------->
                            <tr>
                                <td>Mark</td>
                                <td>Otto</td>
                                <td>New</td>
                            </tr>
                            <tr>
                                <td>Jacob</td>
                                <td>Thornton</td>
                                <td>Checked</td>
                            </tr>
                            <tr>
                                <td>Larry</td>
                                <td>the Bird</td>
                                <td>Checked</td>
                            </tr>
                            <tr>
                                <td>Larry</td>
                                <td>the Bird</td>
                                <td>Checked</td>
                            </tr>
                            <!--찜 forEach 문 끝--------------------------------------------->
                        </tbody>
                    </table>
                </div>
                <div class="adminMainDiv1">
                    <p>로그기록</p>
                    <table class="table">
                        <thead>
                            <tr>
                                <th scope="col">관리자 ID</th>
                                <th scope="col">이벤트날짜</th>
                                <th scope="col">이벤트내용</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!--로그기록 forEach 문 시작 최신 날짜기준으로 4개만 노출 시켜야 함 ------->
                            <tr>
                                <td>Mark</td>
                                <td>Otto</td>
                                <td>@mdo</td>
                            </tr>
                            <tr>
                                <td>Jacob</td>
                                <td>Thornton</td>
                                <td>@fat</td>
                            </tr>
                            <tr>
                                <td>Larry</td>
                                <td>the Bird</td>
                                <td>@twitter</td>
                            </tr>
                            <tr>
                                <td>Larry</td>
                                <td>the Bird</td>
                                <td>@twitter</td>
                            </tr>
                            <!--로그기록 forEach 문 끝--------------------------------------------->
                        </tbody>
                    </table>
                </div>
                <div class="adminMainDiv1" style="height: 640px; margin-bottom: 40px;">
                    <p>메모장</p>
                    <textarea class="form-control text11" id="exampleFormControlTextarea1" rows="10"
                        placeholder="메모를 입력하세요" style="background-color: #f8f9fa; border: 0; resize: none; "></textarea>
                    <div style="text-align: right;"><button type="button" class="btn btn-secondary"
                            style="margin-top: 10px; ">메모등록</button></div>
                    <p style="background-color: white;">메모 List</p>
                    <table class="table">
                        <thead>
                            <tr>
                                <th scope="col">관리자 ID</th>
                                <th scope="col">내용</th>
                                <th scope="col">등록날짜</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!--메모장 forEach 문 시작 최신 날짜기준으로 4개만 노출 시켜야 함 ------->
                            <tr>
                                <td>Mark</td>
                                <td>Otto</td>
                                <td>Otto</td>
                            </tr>
                            <tr>
                                <td>Jacob</td>
                                <td>Otto</td>
                                <td>Thornton</td>
                            </tr>
                            <tr>
                                <td>Larry</td>
                                <td>Otto</td>
                                <td>the Bird</td>
                            </tr>
                            <tr>
                                <td>Larry</td>
                                <td>Otto</td>
                                <td>the Bird</td>
                            </tr>
                            <!--메모장 forEach 문 끝--------------------------------------------->
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</body>


<script type="text/javascript">
$("#adminLogout").on("click", function(){
    if(confirm("관리자 로그아웃 하시겠습니까?")){
    location.href = "<%=request.getContextPath()%>/adminLogin/logout.do";
    alert("로그아웃되었습니다.");
    }
 });



</script>
</html>