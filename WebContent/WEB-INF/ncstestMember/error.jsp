<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%String path=request.getContextPath(); %>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
	<h1>${errorMsg }</h1>
	<a href="<%=path%>/ncstest/memberRegister.do">
	입력페이지로 돌아가기</a>
</body>
</html>	