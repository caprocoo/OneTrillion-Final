<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>찜 리스트 페이지</title>
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
    <style>
        * {
            margin: 0;
            padding: 0;
        }

        .list-group-item:hover {
            cursor: pointer;
            background-color: #f8f9fa;
        }

        .adminMainDiv1 p {
            margin-bottom: 0;
            line-height: 45px;
            text-align: center;
            font-weight: bold;
            background-color: #ededed;
            border-radius: 20px 20px 0 0;
        }

        #adminMemtable1 th {
            width: 25%;
            height: 40px;
            background-color: #ededed;
            border-bottom: 1px solid white;
            text-align: center;
        }

        #adminMemtable1 td {
            border-bottom: 1px solid #ededed;
            padding-left: 20px;
        }
        .table-hover th, .table-hover td{
        text-align:center;}

        table {
            table-layout: fixed;
            word-break: break-all;

        }

        td {
            overflow: hidden;
            white-space: nowrap;
            text-overflow: ellipsis;
        }
    </style>
</head>

<body>
    <div style="width: 1800px; height: 100vh;">
        <div style="float: left; width: 250px; height: 100%; box-shadow: 0 0 20px #ededed; position: fixed;">
            <div style="margin:auto; width: 80%;"><img style="width: 100%; margin-top: 40px; margin-bottom: 40px;"
                    src="http://jjcom0214.cafe24.com/web/OneTrillion/logo02.png" alt="logo01"></div>
            <div>
                <ul class="list-group list-group-flush">
                    <li class="list-group-item" onclick="">메인</li>
                    <li class="list-group-item" onclick="">회원예약</li>
                    <li class="list-group-item" onclick="">비회원예약</li>
                    <li class="list-group-item" onclick="">문의</li>
                    <li class="list-group-item" onclick="">리뷰</li>
                    <li class="list-group-item" onclick="">회원</li>
                    <li class="list-group-item" onclick="">상품</li>
                    <li class="list-group-item" onclick="">관리자</li>
                    <li class="list-group-item" onclick="">찜</li>
                    <li class="list-group-item" onclick="">공지사항</li>
                    <li class="list-group-item" onclick="">자주질문</li>
                    <li class="list-group-item" onclick="">로그기록</li>
                    <li class="list-group-item" onclick="">메모장</li>

                </ul>
            </div>
        </div>
        <div style="float:right; width: 1500px;height: 100%;">
            <div
                style="margin-top: 40px; width: 1500px; height: 90%; border-radius: 20px; box-shadow: 0 0 20px #ededed;">
                <div class="adminMainDiv1">
                    <p>찜 리스트</p>
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th scope="col" style="width:80px">순번</th>
                                <th scope="col" style="width:80px">찜번호</th>
                                <th scope="col" style="width:80px">상품번호</th>
                                <th scope="col" style="width:200px">상품명</th>
                                <th scope="col" style="width:120px">출발일</th>
                                <th scope="col" style="width:120px">도착일</th>
                                <th scope="col" style="width:120px">상품가격</th>
                                <th scope="col">상품이미지</th>
                                <th scope="col" style="width:200px">회원ID</th>
                                <th scope="col" style="width:200px">수정/삭제</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!-- forEach 문 시작--------------------------------------------------------------------------------------------------------------------------------------->
                        <c:forEach var="wish" items="${wishList }" varStatus="status">   
                        <%-- <c:set var="i" value="${i+1}" /> <!-- jsp 페이지 내 순번 적용 코드 --> --%>
                            <tr style="cursor: pointer;" class="detail tr01"> 
                            <th>${fn:length(wishList) - status.index}</th>  <!-- jsp 페이지 내 순번 적용 코드 --> 
                                <%-- <th data-bs-toggle="modal" data-bs-target=".bd-example-modal-lg" onclick="">${i }</th> --%>
                                <td data-bs-toggle="modal" data-bs-target=".bd-example-modal-lg" onclick="">${wish.w_seq}</td>
                                <td data-bs-toggle="modal" data-bs-target=".bd-example-modal-lg" onclick="">${wish.pd_seq}</td>
                                <td data-bs-toggle="modal" data-bs-target=".bd-example-modal-lg" onclick="">${wish.pd_name}</td>
                                <td data-bs-toggle="modal" data-bs-target=".bd-example-modal-lg" onclick="">${wish.pd_startDate}</td>
                                <td data-bs-toggle="modal" data-bs-target=".bd-example-modal-lg" onclick="">${wish.pd_endDate}</td>
                                <td data-bs-toggle="modal" data-bs-target=".bd-example-modal-lg" onclick="">${wish.pd_price}</td>
                                <td data-bs-toggle="modal" data-bs-target=".bd-example-modal-lg" onclick="">${wish.pd_image}</td>
                                <td data-bs-toggle="modal" data-bs-target=".bd-example-modal-lg" onclick="">${wish.u_id}</td>
                                <td>
                                    <a class="btn btn-secondary btn001" href="<%=request.getContextPath() %>/adminWishlist/modify.do?w_seq=${wish.w_seq}" role="button" 
                                        style="padding: 5px;">수정</a>
                                    <a class="btn btn-secondary btn001" href="#" role="button" onclick="del_btn('${wish.w_seq}','${wish.pd_name}','${wish.u_id}')"
                                    	style="padding: 5px;">삭제</a>
                                </td>
                            </tr>
                         </c:forEach>   
                            <!-- forEach 문 끝--------------------------------------------------------------------------------------------------------------------------------------->
                        </tbody>
                    </table>
                    <div style="width: 100%;">
                        <!--페이징 tag 시작----------------------------------------------------------------------------------------------------------------------------------------->
                        <div style="float: left; margin-left: 10px;">
                            <ul class="pagination">
                                <li class="page-item">
                                    <a class="page-link" href="#" aria-label="Previous"
                                        style="color: gray; border:1px solid #ededed">
                                        <span aria-hidden="true">&laquo;</span>
                                        <!-- <span class="sr-only">Previous</span> -->
                                    </a>
                                </li>
                                <li class="page-item"><a class="page-link" href="#"
                                        style="color: gray;border:1px solid #ededed">1</a></li>
                                <li class="page-item"><a class="page-link" href="#"
                                        style="color: gray;border:1px solid #ededed">2</a></li>
                                <li class="page-item"><a class="page-link" href="#"
                                        style="color: gray;border:1px solid #ededed">3</a></li>
                                <li class="page-item"><a class="page-link" href="#"
                                        style="color: gray;border:1px solid #ededed">4</a></li>
                                <li class="page-item"><a class="page-link" href="#"
                                        style="color: gray;border:1px solid #ededed">5</a></li>
                                <li class="page-item">
                                    <a class="page-link" href="#" aria-label="Next"
                                        style="color: gray;border:1px solid #ededed">
                                        <span aria-hidden="true">&raquo;</span>
                                        <!-- <span class="sr-only">Next</span> -->
                                    </a>
                                </li>
                            </ul>
                        </div>
                        <!--페이징 tag 끝----------------------------------------------------------------------------------------------------------------------------------------->
                        <div style="float: right; margin-right: 10px;">
                            <div class="input-group mb-3" style="width: 300px; float: left; margin-right: 10px;">
                                <input type="text" class="form-control keyword" placeholder="검색할 단어를 입력하세요"
                                    aria-label="Recipient's username" aria-describedby="button-addon2"
                                    style="border:1px solid #ededed;">
                                <button class="btn btn-outline-secondary" type="button" id="button-addon2"
                                    style="border:1px solid #ededed">검색</button>
                            </div>
                            <a class="btn btn-secondary" href="<%=request.getContextPath() %>/adminWishlist/input.do" role="button">등록</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!--Modal----------------------------------------------------------------------------------------------------------------->
    <div class="modal fade bd-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel"
        aria-hidden="true">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">상세 보기</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <table id="adminMemtable1" style="width: 100%; border-top: 2px solid #343a40;">
                    <tr>
                        <th>순번</th>
                        <td id="list_seq"></td>
                    </tr>
                    <tr>
                        <th>찜번호</th>
                        <td id="w_seq"></td>
                    </tr>
                    <tr>
                        <th>상품번호</th>
                        <td id="pd_seq"></td>
                    </tr>
                    <tr>
                        <th>상품명</th>
                        <td id="pd_name"></td>
                    </tr>
                    <tr>
                        <th>출발일</th>
                        <td id="pd_startDate"></td>
                    </tr>
                    <tr>
                        <th>도착일</th>
                        <td id="pd_endDate"></td>
                    </tr>
                    <tr>
                        <th>상품가격</th>
                        <td id="pd_price"></td>
                    </tr>
                    <tr>
                        <th>상품이미지 URL</th>
                        <td id="pd_image"></td>
                    </tr>
                    <tr>
                        <th>상품이미지</th>
                        <td style=" padding-left:0;margin-left:0; text-align:center"><img id="pd_image2" src="" alt="" style="width:90%;" height="400px" /></td>
                    </tr>
                    <tr>
                        <th>회원ID</th>
                        <td id="u_id"></td>
                    </tr>
                </table>
                <div style="text-align: right;">
                    <a class="btn btn-secondary" href="#" role="button"
                        style="margin-top:10px; margin-bottom: 10px;" onclick="modi_modal()">수정</a>
                    <a class="btn btn-secondary" href="#" role="button"
                        style="margin-top:10px; margin-bottom: 10px; margin-right: 10px;" onclick="del_modal()">삭제</a>
                </div>
            </div>
        </div>
    </div>
    <!--Modal 끝----------------------------------------------------------------------------------------------------------------->
</body>
<script>

// 삭제
function del_btn(w_seq, pd_name, u_id){
	//console.log(w_seq);
	//console.log(pd_name);
	var deleteConfirm = confirm(u_id+ " 회원의 [" + pd_name + "] 상품을 삭제하시겠습니까?");
	if(!deleteConfirm){
		return false;
	}else{
	    $.ajax({
	        url:"delete.do",
	        type:'POST',
	        data: {"w_seq":w_seq},
	        success:function(data){
	            alert("정상적으로 삭제되었습니다.");
	            location.href = "http://localhost:8088/trip/adminWishlist/list.do";				            	            
	        }
	    });	//ajax 종료
	} // else 종료
} // function 종료

// 모달창 내 삭제
function del_modal(){
	var w_seq = $("#w_seq").text();
	var pd_name = $("#pd_name").text();
	var u_id = $("#u_id").text();
	
	console.log(w_seq);
	var deleteConfirm = confirm(u_id+ " 회원의 [" + pd_name + "] 상품을 삭제하시겠습니까?");
	if(!deleteConfirm){
		return false;
	}else{
	    $.ajax({
	        url:"delete.do",
	        type:'POST',
	        data: {"w_seq":w_seq},
	        success:function(data){
	            alert("정상적으로 삭제되었습니다.");
	            location.href = "http://localhost:8088/trip/adminWishlist/list.do";				            	            
	        }
	    });	//ajax 종료
	} // else 종료
}// function 종료

// 모달창 내 수정
function modi_modal(){
	var w_seq = $("#w_seq").text();
	location.href = "http://localhost:8088/trip/adminWishlist/modify.do?w_seq="+w_seq;		
}

$(document).ready(function(){       
    $(".detail").on("click", function(){
    	 var list_seq = $(this).children("th:nth-child(1)").text(); 
    	 var w_seq = $(this).children("td:nth-child(2)").text(); 
    	 var pd_seq = $(this).children("td:nth-child(3)").text();
    	 var pd_name = $(this).children("td:nth-child(4)").text();
    	 var pd_startDate = $(this).children("td:nth-child(5)").text();  
    	 var pd_endDate = $(this).children("td:nth-child(6)").text(); 
    	 var pd_price = $(this).children("td:nth-child(7)").text();  
    	 var pd_image = $(this).children("td:nth-child(8)").text(); 
    	 var pd_image2 = $(this).children("td:nth-child(8)").text(); 
    	 var u_id = $(this).children("td:nth-child(9)").text(); 
    	 
    	 $('#list_seq').text(list_seq);
    	 $('#w_seq').text(w_seq);
    	 $('#pd_seq').text(pd_seq);
    	 $('#pd_name').text(pd_name);
    	 $('#pd_startDate').text(pd_startDate);
    	 $('#pd_endDate').text(pd_endDate);
    	 $('#pd_price').text(pd_price);
    	 $('#pd_image').text(pd_image);
    	 $('#pd_image2').prop("src",pd_image2);
    	 $('#u_id').text(u_id);
    });
          
              //검색2 ---------------------------------------------------
          $(".keyword").keyup(function () {
              $(".tr01").hide();
              $(".tr01:contains(" + $(this).val() + ")").show();
          });
          // 검색2 끝---------------------------------------------------
}); //document ready 종료
</script>

</html>