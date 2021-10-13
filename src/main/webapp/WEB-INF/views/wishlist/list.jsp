<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
	<h1>찜 list Page</h1>
		<div>
      <c:forEach var="board" items="${wishList }">
	           <p>w_seq : ${board.w_seq }, pd_seq : ${board.pd_seq }, pd_name : ${board.pd_name }, pd_name : ${board.pd_name }, pd_startDate : ${board.pd_startDate }</p>
	           <p>pd_endDate : ${board.pd_endDate }, pd_price : ${board.pd_price }, pd_image : ${board.pd_image }, u_id : ${board.u_id }</p>

	           <hr />
      </c:forEach> 
      
                  <a href="<%=request.getContextPath() %>/noUserRes/check.do">비회원으로 예약조회하기</a>
      
   </div>
</body>
</html>