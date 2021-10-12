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
<!-- 1대1문의 리스트 페이지입니다 (보영 10/12) -->

<h1>1대1문의 리스트 페이지입니다 (보영 10/12)</h1>
 		  <table border="1px">
                <tr>
                    <th>No</th>
                    <th>제목</th>
                    <th>이름</th>
                    <th>작성일자</th>
                </tr>
                
             <c:forEach var="client" items="${clientQueList }">        
                <tr >
                    <td>${client.cl_seq  }</td>
                    <td>${client.cl_title  }</td>
                    <td>${client.u_nickName  }</td>
                    <td>${client.cl_Date  }</td>
                </tr>
              </c:forEach>      
          </table>
</body>
</html>