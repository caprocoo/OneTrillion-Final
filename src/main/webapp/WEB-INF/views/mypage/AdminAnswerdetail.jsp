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
<h1>답변완료</h1>

<h2>문의 내용</h2>
<table style="undefined;table-layout: fixed; width: 853px" border="1px">
<colgroup>
<col style="width: 344px">
<col style="width: 509px">
</colgroup>
<tbody>
  <tr>
    <td>문의 번호</td>
    <td>${cl_dto.cl_seq  }</td>
  </tr>
  <tr>
    <td>회원 정보</td>
    <td> ${cl_dto.u_id  } (  ${cl_dto.u_nickName  })</td>
  </tr>
   <tr>
    <td>문의 유형</td>
    <td>${cl_dto.cl_type  }</td>
  </tr>
  <tr>
    <td>문의 내용</td>
    <td>제목 : ${cl_dto.cl_title  }<br>
    	내용 :${cl_dto.cl_content  }</td>
  </tr>
  <tr>
    <td>문의 작성일</td>
    <td>${cl_dto.cl_Date  }</td>
  </tr>
</tbody>
</table>


<br><br><br>
<h2>${cl_dto.cl_seq  }번 관리자 답변</h2>


<table style="undefined;table-layout: fixed; width: 853px" border="1px">
<colgroup>
<col style="width: 344px">
<col style="width: 509px">
</colgroup>

<tbody>
  <tr>
    <td>관리자 아이디</td>
    <td>${ans_dto.ad_id } </td>
  </tr>
  <tr  >
    <td  style=" height:200px" >답변 내용</td>
    <td>${ans_dto.ans_content  }</td>
  </tr>
    <tr>
    <td>답변 작성 날짜</td>
    <td>${ans_dto.ans_Date }</td>
  </tr>
  
</tbody>
</table>













			

</body>
</html>