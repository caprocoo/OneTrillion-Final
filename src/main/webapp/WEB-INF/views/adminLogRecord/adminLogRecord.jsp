<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<!--<jsp:include page="../include/adminInclude.jsp"></jsp:include>-->

	<h1>Reply List Page</h1>
	<table id="resListTab1"
		style="width: 100%; margin-top: 40px; border-top: 2px solid #343a40">
		<tr
			style="height: 70px; background-color: #ededed; text-align: center;">
			<th>SEQ</th>
			<th>AD_ID</th>
			<th>PART</th>
			<th>PER_SEQ</th>
			<th>PER_TITLE</th>
			<th>CONTENT</th>
			<th>DATE</th>

		</tr>
		<!---------forEach 시작-------------------------------------------------------------------------------------------------------------------------->
		<!--아래 onclick 회원 예약 상세 보기 페이지로 설정 해주세요-->
		<c:forEach var="board" items="${logRecordList }">
			<tr>
				<td>${board.log_seq }</td>
				<td>${board.ad_id}</td>
				<td>${board.log_part}</td>
				<td>${board.per_seq}</td>
				<td>${board.per_title}</td>
				<td>${board.log_content}</td>
				<td>${board.log_date}</td>


			</tr>
		</c:forEach>
		<!---------forEach 끝-------------------------------------------------------------------------------------------------------------------------->
	</table>
	<div style="width: 100%;">
		<!--페이징 tag----------------------------------------------------------------------------------------------------------------------------------------->
		<div style="float: left; margin-left: 10px;">
			<ul class="pagination">
				<c:if test="${pageMaker.prev}">
					<li class="page-item"><a class="page-link"
						href="list.do${pageMaker.makeQuery(pageMaker.startPage - 1)}"
						aria-label="Previous"
						style="color: gray; border: 1px solid #ededed"> <span
							aria-hidden="true">&laquo;</span>
					</a></li>
				</c:if>
				<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}"
					var="idx">
					<li class="page-item"><a class="page-link"
						href="list.do${pageMaker.makeQuery(idx)}"
						style="color: gray; border: 1px solid #ededed">${idx}</a></li>
				</c:forEach>

				<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
					<li class="page-item"><a class="page-link"
						href="list.do${pageMaker.makeQuery(pageMaker.endPage + 1)}"
						aria-label="Next" style="color: gray; border: 1px solid #ededed">
							<span aria-hidden="true">&raquo;</span>
					</a></li>
				</c:if>
			</ul>
		</div>
	</div>
</body>
</html>