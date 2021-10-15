<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원 예약관리 리스트 페이지</title>
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

        .table th {
            font-size: 80%;
            writing-mode: tb-rl;
        }

        .table td,
        .btn001 {
            font-size: 80%;
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
                    <p>회원 예약관리 리스트</p>
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th scope="col">순번</th>
                                <th scope="col">RES_SEQ</th>
                                <th scope="col">USERS_SEQ</th>
                                <th scope="col">PD_SEQ</th>
                                <th scope="col">PD_NAME</th>
                                <th scope="col">PD_STARTDATE</th>
                                <th scope="col">PD_ENDDATE</th>
                                <th scope="col">ADULT_NUM</th>
                                <th scope="col">TEENAGER_NUM</th>
                                <th scope="col">PET_NUM</th>
                                <th scope="col">ADULT_PRICE</th>
                                <th scope="col">TEENAGER_PRICE</th>
                                <th scope="col">PET_PRICE</th>
                                <th scope="col">RES_PRICE</th>
                                <th scope="col">RES_PEOPLE</th>
                                <th scope="col">RES_NAME</th>
                                <th scope="col">RES_BIRTH</th>
                                <th scope="col">RES_EMAIL</th>
                                <th scope="col">U_ID</th>
                                <th scope="col">RES_COMMENT</th>
                                <th scope="col">수정/삭제</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!-- forEach 문 시작--------------------------------------------------------------------------------------------------------------------------------------->
                            <tr style="cursor: pointer;" onclick="">
                                <td data-bs-toggle="modal" data-bs-target=".bd-example-modal-lg" onclick="">1</td>
                                <td data-bs-toggle="modal" data-bs-target=".bd-example-modal-lg" onclick="">Mark</td>
                                <td data-bs-toggle="modal" data-bs-target=".bd-example-modal-lg" onclick="">Mark</td>
                                <td data-bs-toggle="modal" data-bs-target=".bd-example-modal-lg" onclick="">Mark</td>
                                <td data-bs-toggle="modal" data-bs-target=".bd-example-modal-lg" onclick="">Mark</td>
                                <td data-bs-toggle="modal" data-bs-target=".bd-example-modal-lg" onclick="">Mark</td>
                                <td data-bs-toggle="modal" data-bs-target=".bd-example-modal-lg" onclick="">Mark</td>
                                <td data-bs-toggle="modal" data-bs-target=".bd-example-modal-lg" onclick="">Mark</td>
                                <td data-bs-toggle="modal" data-bs-target=".bd-example-modal-lg" onclick="">Mark</td>
                                <td data-bs-toggle="modal" data-bs-target=".bd-example-modal-lg" onclick="">Mark</td>
                                <td data-bs-toggle="modal" data-bs-target=".bd-example-modal-lg" onclick="">Mark</td>
                                <td data-bs-toggle="modal" data-bs-target=".bd-example-modal-lg" onclick="">Mark</td>
                                <td data-bs-toggle="modal" data-bs-target=".bd-example-modal-lg" onclick="">Mark</td>
                                <td data-bs-toggle="modal" data-bs-target=".bd-example-modal-lg" onclick="">Mark</td>
                                <td data-bs-toggle="modal" data-bs-target=".bd-example-modal-lg" onclick="">Mark</td>
                                <td data-bs-toggle="modal" data-bs-target=".bd-example-modal-lg" onclick="">Mark</td>
                                <td data-bs-toggle="modal" data-bs-target=".bd-example-modal-lg" onclick="">Mark</td>
                                <td data-bs-toggle="modal" data-bs-target=".bd-example-modal-lg" onclick="">Mark</td>
                                <td data-bs-toggle="modal" data-bs-target=".bd-example-modal-lg" onclick="">Mark</td>
                                <td data-bs-toggle="modal" data-bs-target=".bd-example-modal-lg" onclick="">Mark</td>

                                <td>
                                    <a class="btn btn-secondary btn001" href="#" role="button"
                                        style="padding: 5px;">수정</a>
                                    <a class="btn btn-secondary btn001" href="#" role="button"
                                        style="padding: 5px;">삭제</a>
                                </td>
                            </tr>
                            <!-- forEach 문 끝--------------------------------------------------------------------------------------------------------------------------------------->
                        </tbody>
                    </table>
                    <div style="width: 100%;">
                        <!--페이징 tag----------------------------------------------------------------------------------------------------------------------------------------->
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
                                <li class="page-item">
                                    <a class="page-link" href="#" aria-label="Next"
                                        style="color: gray;border:1px solid #ededed">
                                        <span aria-hidden="true">&raquo;</span>
                                        <!-- <span class="sr-only">Next</span> -->
                                    </a>
                                </li>
                            </ul>
                        </div>
                        <!--페이징 tag----------------------------------------------------------------------------------------------------------------------------------------->
                        <div style="float: right; margin-right: 10px;">
                            <div class="input-group mb-3" style="width: 300px; float: left; margin-right: 10px;">
                                <input type="text" class="form-control" placeholder="검색할 단어를 입력하세요"
                                    aria-label="Recipient's username" aria-describedby="button-addon2"
                                    style="border:1px solid #ededed;">
                                <button class="btn btn-outline-secondary" type="button" id="button-addon2"
                                    style="border:1px solid #ededed">검색</button>
                            </div>
                            <a class="btn btn-secondary" href="#" role="button">등록</a>
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
                    <h5 class="modal-title" id="exampleModalLabel">예약 내역 상세 보기</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <table id="adminMemtable1" style="width: 100%; border-top: 2px solid #343a40;">
                    <tr>
                        <th>순번</th>
                        <td>1 [db에서 가져오는것이 아닌 뷰페이지에서 자동으로 순번 설정되게]</td>
                    </tr>
                    <tr>
                        <th>RES_SEQ</th>
                        <td>RES_SEQ</td>
                    </tr>
                    <tr>
                        <th>USERS_SEQ</th>
                        <td>USERS_SEQ</td>
                    </tr>
                    <tr>
                        <th>PD_SEQ</th>
                        <td>PD_SEQ</td>
                    </tr>
                    <tr>
                        <th>PD_NAME</th>
                        <td>PD_NAME</td>
                    </tr>
                    <tr>
                        <th>PD_STARTDATE</th>
                        <td>PD_STARTDATE</td>
                    </tr>
                    <tr>
                        <th>PD_ENDDATE</th>
                        <td>PD_ENDDATE</td>
                    </tr>
                    <tr>
                        <th>ADULT_NUM</th>
                        <td>ADULT_NUM</td>
                    </tr>
                    <tr>
                        <th>TEENAGER_NUM</th>
                        <td>TEENAGER_NUM</td>
                    </tr>
                    <tr>
                        <th>PET_NUM</th>
                        <td>PET_NUM</td>
                    </tr>
                    <tr>
                        <th>ADULT_PRICE</th>
                        <td>ADULT_PRICE</td>
                    </tr>
                    <tr>
                        <th>TEENAGER_PRICE</th>
                        <td>TEENAGER_PRICE</td>
                    </tr>
                    <tr>
                        <th>PET_PRICE</th>
                        <td>PET_PRICE</td>
                    </tr>
                    <tr>
                        <th>RES_PRICE</th>
                        <td>RES_PRICE</td>
                    </tr>
                    <tr>
                        <th>RES_PEOPLE</th>
                        <td>RES_PEOPLE</td>
                    </tr>
                    <tr>
                        <th>RES_NAME</th>
                        <td>RES_NAME</td>
                    </tr>
                    <tr>
                        <th>RES_BIRTH</th>
                        <td>RES_BIRTH</td>
                    </tr>
                    <tr>
                        <th>RES_EMAIL</th>
                        <td>RES_EMAIL</td>
                    </tr>
                    <tr>
                        <th>U_ID</th>
                        <td>U_ID</td>
                    </tr>
                    <tr>
                        <th>RES_COMMENT</th>
                        <td>RES_COMMENT</td>
                    </tr>
                </table>
                <div style="text-align: right;">
                    <a class="btn btn-secondary" href="#" role="button"
                        style="margin-top:10px; margin-bottom: 10px;">삭제</a>
                    <a class="btn btn-secondary" href="#" role="button"
                        style="margin-top:10px; margin-bottom: 10px; margin-right: 10px;">수정</a>
                </div>
            </div>
        </div>
    </div>
    <!--Modal 끝----------------------------------------------------------------------------------------------------------------->
    
</body>

</html>