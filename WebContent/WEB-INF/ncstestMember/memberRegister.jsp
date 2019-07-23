<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String ctxPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberRegister.jsp</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>


<style type="text/css">
.layer {
	width: 60%;
	margin: 0 auto;
}

ul {
	list-style-type: none;
}

li {
	margin: 20px 0 0 0;
}

button#btnOK {
	margin: 0 0 0 50px;
	padding: 5px 10px 5px 10px;
	font-size: 12pt;
	font-weight: bolder;
}
</style>
<script type="text/javascript"> 
function goRegister() { 
var frm = document.registerFrm; 
frm.action = "<%=ctxPath%>/ncstest/memberRegister.do";
		frm.method = "POST";
		frm.submit();
	}
</script>
</head>
<body>
	<form name="registerFrm">
	<div class="layer">
		<h2>회원가입</h2>
		<%-- *** (요구사항 1) JSP 입력폼 페이지를 작성 하시오. *** --%>
			<ul>
			<li>아이디<br/>
			<input type="text" id="userId" name="userId"></li>
			<li>성명<br/>
			<input type="text" id="userName" name="userName"></li>
			<li>생년원일(예:19950402)<br/>
			<input type="text" id="birthday" name="birthday" ><li>
			<li>남<input type="radio" name="gender" value="1" checked="checked"><li>
			<li>여<input type="radio" name="gender" value="2"><li>
			</ul>
			<button id=btnOK onclick="goRegister();">확인</button>
	</form>
	</div>
</body>
</html>