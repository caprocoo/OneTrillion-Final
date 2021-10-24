<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>상품 등록 페이지</title>
     <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <!--  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"
        integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"
        integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13"
        crossorigin="anonymous"></script> -->
<!-- 텍스트 편집기  -->
<!-- <script src="https://cdn.ckeditor.com/ckeditor5/25.0.0/classic/ckeditor.js"></script> -->

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
}

#adminMemtable1 td:nth-child(3) {
	width: 20%;
}

#adminMemtable1 input {
	border: 0;
}

.form-control {
	border: 0;
}

.ck_warn {
	display: none;
	padding: 10px;
	color: highlight;
	font-weight: 700;
	font-size: 90%;
}

#pd_startDate, #pd_endDate {
	width: 200px
}
/* ckeditor 높이 */
.ck-content {
	height: 170px;
}
#uploadResult img {
	width: 200px;
	height: 200px;
	float: left;
}
</style>
</head>
<body>
	<div style="width: 1800px; height: auto;">
		<jsp:include page="../include/adminInclude.jsp"></jsp:include>
		<div
			style="float: right; width: 1500px; height: 100%; margin-bottom: 40px;">
			<div
				style="margin-top: 40px; width: 1500px; height: 90%; border-radius: 20px; box-shadow: 0 0 20px #ededed;">
				<div class="adminMainDiv1">
					<p>상품 등록</p>
				</div>
				<form action="input.do" method="POST" id="frm" name="frm" enctype="multipart/form-data">
					<table id="adminMemtable1"
						style="width: 100%; border-top: 2px solid #343a40;">
						<!--             <tr>
                        <th>상품번호</th>
                        <td><input type="text" class="form-control" placeholder="PD_SEQ" id="pd_seq"  name="pd_seq">
                        <span class="ck_warn pd_seq_warn">상품 번호를 입력해주세요.</span></td>
                    </tr> -->
						<tr>
							<th>상품명</th>
							<td><input type="text" class="form-control" placeholder=""
								id="pd_name" name="pd_name" value="1"></td>
							<td><span class="ck_warn pd_name_warn">상품명을 입력해주세요.</span></td>
						</tr>
						<tr>
							<th>상품가격</th>
							<td><input type="text" class="form-control"
								placeholder="숫자로만 입력해주세요 (ex. 200000)" id="pd_price"
								name="pd_price" value="1"></td>
							<td><span class="ck_warn pd_price_warn">상품 가격을
									입력해주세요.</span></td>

						</tr>
						<tr>
							<th>키워드</th>
							<td><input type="text" class="form-control"
								placeholder="한글로 입력해주세요 (ex. 한옥마을)" id="pd_keyword"
								name="pd_keyword" value="1"></td>
							<td><span class="ck_warn pd_keyword_warn">키워드를
									입력해주세요.</span></td>
						</tr>
						<tr>
							<th>출발일</th>
							<td><input type="date" class="form-control"
								placeholder="출발일을 선택해주세요" id="pd_startDate" name="pd_startDate" value="2021-10-01">

							</td>
							<td><span class="ck_warn pd_keyword_warn">출발일을
									선택해주세요.</span></td>
						</tr>
						<tr>
							<th>도착일</th>
							<td><input type="date" class="form-control"
								placeholder="도착일을 선택해주세요" id="pd_endDate" name="pd_endDate" value="2021-10-02">
							</td>
							<td><span class="ck_warn pd_endDate_warn">도착일을
									선택해주세요.</span></td>
						</tr>
						<tr>
							<th>조회수</th>
							<td><input type="text" class="form-control"
								placeholder="숫자로만 입력해주세요" id="pd_cnt" name="pd_cnt" value="1"></td>
							<td><span class="ck_warn pd_cnt_warn">조회수를 입력해주세요.</span></td>
						</tr>
						<tr>
							<th>테마</th>
							<td><input type="text" class="form-control"
								placeholder="영어 소문자로 입력해주세요 (ex. pet)" id="pd_theme"
								name="pd_theme" value="1"></td>
							<td><span class="ck_warn pd_theme_warn">테마를 입력해주세요.</span></td>
						</tr>
						<tr>
							<th>인원</th>
							<td><input type="text" class="form-control"
								placeholder="숫자로만 입력해주세요" id="pd_people" name="pd_people" value="1">
							</td>
							<td><span class="ck_warn pd_people_warn">인원을 입력해주세요.</span></td>
						</tr>
						<tr>
							<th>지역</th>
							<td><input type="text" class="form-control"
								placeholder="영어 소문자로 입력해주세요 (ex. seoul) " id="pd_location"
								name="pd_location" value="1"></td>
							<td><span class="ck_warn pd_location_warn">지역을
									입력해주세요.</span></td>
						</tr>
						<tr>
							<th>성인 인원</th>
							<td><input type="text" class="form-control"
								placeholder="숫자로만 입력해주세요" id="adult_num" name="adult_num" value="1">
							</td>
							<td><span class="ck_warn adult_num_warn">성인 인원을
									입력해주세요.</span></td>
						</tr>
						<tr>
							<th>미성년자 인원</th>
							<td><input type="text" class="form-control"
								placeholder="숫자로만 입력해주세요" id="teenager_num" name="teenager_num" value="1">
							</td>
							<td><span class="ck_warn teenager_num_warn">미성년자 인원을
									입력해주세요.</span></td>
						</tr>
						<tr>
							<th>반려동물 수</th>
							<td><input type="text" class="form-control"
								placeholder="숫자로만 입력해주세요" id="pet_num" name="pet_num" value="1"></td>
							<td><span class="ck_warn pet_num_warn">반려동물 수를
									입력해주세요.</span></td>
						</tr>
						<tr>
							<th>성인 추가요금</th>
							<td><input type="text" class="form-control"
								placeholder="숫자로만 입력해주세요 (ex. 200000)" id="adult_price"
								name="adult_price" value="1"></td>
							<td><span class="ck_warn adult_price_warn">성인 추가요금을
									입력해주세요.</span></td>
						</tr>
						<tr>
							<th>미성년자 추가요금</th>
							<td><input type="text" class="form-control"
								placeholder="숫자로만 입력해주세요 (ex. 200000)" id="teenager_price"
								name="teenager_price" value="1"></td>
							<td><span class="ck_warn teenager_price_warn">미성년자
									추가요금을 입력해주세요.</span></td>
						</tr>
						<tr>
							<th>반려동물 추가요금</th>
							<td><input type="text" class="form-control"
								placeholder="숫자로만 입력해주세요 (ex. 200000)" id="pet_price"
								name="pet_price" value="1"></td>
							<td><span class="ck_warn pet_price_warn">반려동물 추가요금을
									입력해주세요.</span></td>
						</tr>
						<tr>
							<th>컨텐츠 1</th>
							<td colspan="2" style="padding: 0;"><textarea
									class="form-control" id="exampleFormControlTextarea1" rows="4"
									placeholder="컨텐츠을 입력해주세요"
									style="border: 0; resize: none; background-color: white;"
									name="pd_content1">asdf</textarea></td>
						</tr>
						<tr>
							<th>컨텐츠2</th>
							<td colspan="2" style="padding: 0;"><textarea
									class="form-control" id="exampleFormControlTextarea2" rows="4"
									placeholder="컨텐츠를 입력해주세요"
									style="border: 0; resize: none; background-color: white;"
									name="pd_content2" >asdf</textarea></td>
						</tr>
						<tr>
							<th>컨텐츠3</th>
							<td colspan="2" style="padding: 0;"><textarea
									class="form-control" id="exampleFormControlTextarea3" rows="4"
									placeholder="컨텐츠을 입력해주세요"
									style="border: 0; resize: none; background-color: white;"
									name="pd_content3" >asdf</textarea></td>

						</tr>
						<tr>
							<th>컨텐츠4</th>
							<td colspan="2" style="padding: 0;"><textarea
									class="form-control" id="exampleFormControlTextarea4" rows="4"
									placeholder="컨텐츠를 입력해주세요"
									style="border: 0; resize: none; background-color: white;"
									name="pd_content4" >asdf</textarea></td>
						</tr>
						<tr>
							<th>컨텐츠5</th>
							<td colspan="2" style="padding: 0;"><textarea
									class="form-control" id="exampleFormControlTextarea5" rows="4"
									placeholder="컨텐츠를 입력해주세요"
									style="border: 0; resize: none; background-color: white;"
									name="pd_content5" >asdf</textarea></td>
						</tr> 
						<tr>
		                    <th>대표이미지</th>
		                    <td><input type="file" class="form-control" id="pd_image"
								name="uploadFile" style="height: 30px;"></td>
							<td><span class="ck_warn pd_image_warn">대표이미지를
									선택해주세요.</span></td>
									
									
              			</tr>
						<tr>
							<th>상품이미지1</th>
	                  		<td colspan="2"><input type="file" class="form-control"
								id="pd_contentImage1" name="uploadFile1"></td>
						</tr>
						<tr>
							<th>상품이미지2</th>
							<td colspan="2"><input type="file" class="form-control"
								id="pd_contentImage2" name="uploadFile2"></td>
						</tr>
						<tr>
							<th>상품이미지3</th>
							<td colspan="2"><input type="file" class="form-control"
								id="pd_contentImage3" name="uploadFile3"></td>
						</tr>
						<tr>
							<th>상품이미지4</th>
							<td colspan="2"><input type="file" class="form-control"
								id="pd_contentImage4" name="uploadFile4"></td>
						</tr>
						<tr>
							<th>상품이미지5</th>
							<td colspan="2"><input type="file" class="form-control"
								id="pd_contentImage5" name="uploadFile5"></td>
						</tr>
					</table>
					<div style="text-align: right;">
						<a class="btn btn-secondary" href="#" role="button"
							style="margin-top: 10px; margin-bottom: 10px;"
							onclick="moveTop()">상단으로 이동</a> <a class="btn btn-secondary"
							href="http://localhost:8088/trip/adminProduct/list.do"
							role="button" style="margin-top: 10px; margin-bottom: 10px;">취소</a>
						<input class="btn btn-secondary" type="submit" value="저장"
							style="margin-right: 10px;" id="submitbtn" name="input">
					</div>
				</form>
			</div>
		</div>
	</div>
</body>

</html>