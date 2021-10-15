<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>1대1문의 상세보기 페이지</title>
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
          <!-- ============================================================================@@ 1:1 관리자 답변 10/14 한보영 -->  
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

        .form-control {
            border: 0;
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
        <div style="float:right; width: 1500px;height: auto;">
            <div
                style="margin-top: 40px; margin-bottom: 40px; width: 1000px; height: auto; border-radius: 20px; box-shadow: 0 0 20px #ededed;">
                <div class="adminMainDiv1">
                    <p>1대1문의 상세보기</p>
                </div>
                <table id="adminMemtable1" style="width: 100%; border-top: 2px solid #343a40;">
                    <tr>
                        <th colspan="2">1대1문의 내용</th>
                    </tr>
                    <tr>
                        <th>문의 번호</th>
                        <td>${cl_dto.cl_seq  }</td>
                    </tr>
                    <tr>
                        <th>회원 아이디</th>
                        <td>${cl_dto.u_id  }</td>
                    </tr>
                    <tr>
                        <th>회원 닉네임</th>
                        <td> ${cl_dto.u_nickName  }</td>
                    </tr>
                    <tr>
                        <th>제목</th>
                        <td> ${cl_dto.cl_title  }</td>
                    </tr>
                    <tr>
                        <th>작성일</th>
                        <td>${cl_dto.cl_Date  }</td>
                    </tr>
                    <tr>
                        <th>문의 유형 </th>
                        <td>${cl_dto.cl_type  } </td>
                    </tr>
                    <tr style="height: 100px;">
                        <th>내용</th>
                        <td>${cl_dto.cl_content  }</td>
                    </tr>
                </table>
                <div style="text-align: right;">
                
                 	<a class="btn btn-secondary"  role="button" onclick="location.href='list.do'"
                        style="margin-top:10px; margin-bottom: 10px;">목록으로</a>
                    <a class="btn btn-secondary" href="#" role="button"
                        style="margin-top:10px; margin-bottom: 10px;">수정</a>
                    <a class="btn btn-secondary" href="#" role="button"
                        style="margin-top:10px; margin-bottom: 10px;">삭제</a>
                    <a class="btn btn-primary" href="#" role="button" onclick="location.href='input.do?cl_seq=${cl_dto.cl_seq}' "
                        style="margin-top:10px; margin-bottom: 10px; margin-right: 10px;">답변등록</a>
                </div>
                <div id="IF_answer">
	                <table id="adminMemtable1" style="width: 100%; border-top: 2px solid #343a40;">
	                    <tr>
	                        <th colspan="2">답변</th>
	                    </tr>
	                    <tr>
	                        <th>관리자 아이디</th>
	                        <td>${ans_dto.ad_id }<input type="hidden" id="ans_seq" name="ans_seq" value="${ans_dto.ans_seq }"> </td>
	                    </tr>
	                    <tr>
	                        <th>답변 작성 날짜</th>
	                        <td>${ans_dto.ans_Date }</td>
	                    </tr>
	                    <tr style="height: 100px;">
	                        <th>답변 내용</th>
	                        <td>${ans_dto.ans_content  }</td>
	                    </tr>
	                </table>
	                <div style="text-align: right;">	                
	                    <a class="btn btn-primary"  role="button" onclick="location.href='modify.do?cl_seq=${cl_dto.cl_seq}' "
	                        style="margin-top:10px; margin-bottom: 10px;">답변수정</a>
	                    <a class="btn btn-primary" href="#" role="button" onclick="ad_btn_delete(${ans_dto.ans_seq })"
	                        style="margin-top:10px; margin-bottom: 10px; margin-right: 10px;">답변삭제</a>
	                </div>
				</div>
            </div>
        </div>
    </div>
</body>


<script type="text/javascript">
$(document).ready(function(){  //아직 답변하지 않았으면 보이지 않게 !
	console.log($('#ans_seq').val())
	if($('#ans_seq').val() ==''){		
		$('#IF_answer').css("display", "none")
	}
})//document

//========================================================================@한보영 삭제하기 구현 10/14 
function ad_btn_delete(ans_seq){  
    	var ad_delete = confirm('답변을 삭제하시겠습니까?');						    	
    	if(!ad_delete){
    		return false;
    	}else{
	    	var seqdata ={"ans_seq":ans_seq};
	    	console.log(seqdata)
		    $.ajax({
		        url:"delete.do",
		        type:'POST',
		        data: seqdata,
		        success:function(data){
		            alert("삭제되었습니다.");
		            location.href = "./list.do";							            	            
		        },
		        error:function(){
		            alert("에러");
		        }
		    });	//ajax 끝
    	}//if끌						    	
    };//ad_btn_delete  끝=============================================@삭제하기 	


</script>
</html>