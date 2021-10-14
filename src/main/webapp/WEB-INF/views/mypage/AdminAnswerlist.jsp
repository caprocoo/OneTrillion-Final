<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="//code.jquery.com/jquery.min.js"></script>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
   <!-- @@ 1:1 문의 답변 CRUD   [10/13 수 한보영]  -->
<h1>모든 회원의 문의글에대한 답변 CRUD (임시)관리자페이지 입니다</h1> 
<h2>myPage/list.do에 반영되도록 할 것</h2>



<table style="undefined;table-layout: fixed; width: 159px" border="1px">
<colgroup>
<col style="width: 110px">
<col style="width: 260px">
<col style="width: 310px">
<col style="width: 110px">
<col style="width: 110px">
<col style="width: 110px">
</colgroup>
<thead>
  <tr>
    <th>문의 번호</th>
    <th>회원 정보</th>
    <th>문의 내용</th>
    <th>문의 작성일</th>
    <th>답변</th>
    <th>문의 관리</th>
  </tr>
</thead>
<tbody>
<c:forEach var="client" items="${clientQueList }" varStatus="status"> 
  <tr>
    <td>${client.cl_seq  }</td>
    <td>
    	<ul>
    		<li>회원 아이디 : ${client.u_id  }</li>
    		<li>회원 닉네임 : ${client.u_nickName  }</li>
    	</ul>
    </td>
    <td>
        <ul>
    		<li>문의 제목 : ${client.cl_title  }</li>
    		<li>문의 유형 : ${client.cl_type  }</li>
    		<li>문의 내용 : ${client.cl_content  }</li>
    		
    	</ul>	
    </td>
    <td>${client.cl_Date  }</td>
    <td>
   			
   	    <c:forEach var="adAns" items="${adminAnsList }" > <!-- for문~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~` -->    	
	   	    <c:set var="admin" value="${adAns.cl_seq  }" /> 
			<c:choose>		
			 	<c:when test="${admin eq client.cl_seq}">
				    <div id="btn_div_suc">       	 
				    	<button onclick="location.href='detail.do?cl_seq=${client.cl_seq}' ">답변 완료</button><br/> 
				  	</div>
				</c:when>	 
			 </c:choose>  	
  		</c:forEach>
    </td>
    <td>
    	<button onclick="location.href='<%=request.getContextPath() %>/admin/input.do?cl_seq=${client.cl_seq}' ">답글 입력</button><br/>
		<button>답글 수정</button><br/>
		<button>답글 삭제</button><br/>
    </td>
  </tr>
 </c:forEach> 
</tbody>
</table>


<script>

$(document).ready(function () {    
	var list=$(".cl_seqoo").val();
	console.log(list);
	var list3=$(".cl_seqoo").text();
	console.log(list3);
	var list4=$(".cl_seqoo").html();
	console.log(list4);
	
	var list2=$("#cl_seqoo").val();
	console.log(list2);
})           



</script>
</body>
</html>