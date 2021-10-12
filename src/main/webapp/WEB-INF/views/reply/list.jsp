<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Reply List Page</h1>
              <table id="resListTab1" style="width: 100%; margin-top: 40px; border-top:2px solid #343a40">
                <tr style="height: 70px; background-color: #ededed; text-align: center;">
                  <th>댓글 번호</th>
                  <th>아이디</th>
                  <th>상품번호</th>
                  <th>상품명</th>
                  <th>댓글 쓴 날짜</th>
                  <th>내용</th>
                  <th>별점</th>
                </tr>
                <!---------forEach 시작-------------------------------------------------------------------------------------------------------------------------->
                <!--아래 onclick 회원 예약 상세 보기 페이지로 설정 해주세요-->
                <c:forEach var="board" items="${replyList }">
                <tr>
                  <td>${board.reply_seq }</td>
                  <td>${board.u_id}</td>
                  <td>${board.pd_seq}</td>
                  <td>${board.pd_name}</td>
                  <td>${board.reply_date}</td>
                  <td>${board.reply_content}</td>
                  <td>${board.reply_rate}</td>
                </tr>
                </c:forEach> 
                <!---------forEach 끝-------------------------------------------------------------------------------------------------------------------------->
              </table>
</body>
</html>