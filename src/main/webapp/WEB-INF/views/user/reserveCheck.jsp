<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${sessionScope.u_id != null }">
		<jsp:include page="../include/header2_user.jsp"></jsp:include>
	</c:if>
<%
	// 로그인 처리 -> 로그인 x (로그인페이지 이동)
	String u_id = (String) session.getAttribute("u_id");
	String AD_ID = (String) session.getAttribute("AD_ID");
	if( u_id != null || AD_ID != null){
	}else{%>
		<script> alert('로그인이 필요합니다.'); window.location.href="http://localhost:8088/trip/user/login.do"; </script>
<%}%>
 
	<h1>reserve Check Page</h1>
	<jsp:include page="../include/footer.jsp"></jsp:include>
</body>
</html>