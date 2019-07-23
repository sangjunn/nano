<%@page import="ncs.memberList.model.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberVOList.jsp</title>
<style type="text/css">
table {
   border: 1px solid gray;
   border-collapse: collapse;
}

th, td {
   border: 1px solid gray;
   padding: 5px 10px 5px 10px;
}
</style>
</head>
<body>
   <h2>회원정보</h2>
   <table>
      <thead>
         <tr>
            <th>번호</th>
            <th>아이디</th>
            <th>성명</th>
            <th>나이</th>
            <th>성별</th>
         </tr>
      </thead>

      <tbody>
      <c:forEach items="${requestScope.aList }" var="mvo" varStatus="status" step="1">
         <%-- (요구사항 10) 번호, 아이디, 성명, 나이, 성별이 보여지도록 하시오. --%>
         <tr>
         <td><c:out value="${status.count}" /></td>
         <td><c:out value="${mvo.getUserId() }"/></td>
         <td><c:out value="${mvo.getUserName() }"/></td>
         <td><c:out value="${mvo.getAge() }"/></td>
         <td><c:out value="${mvo.getSexual() }"/></td>
         </tr>
      </c:forEach>
      </tbody>
   </table>
</body>
</html>