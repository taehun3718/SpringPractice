<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>세부 맴버 정보</title>
<script type="text/javascript" src="<c:url value="/js/jquery-1.11.2.js" />"></script>
<script type="text/javascript">
	$(document).ready(function() {
		console.log("ready");
	});
</script>
</head>
<style>

h1{
	font-size: 20px;
}

</style>
<h1>세부 멤버 정보</h1>
<body>
	<table>
		<tr>
			<td>ID:</td>
			<td>${memberInfoVO.usrId }</td>
		</tr>
		<tr>
			<td>EMAIL:</td>
			<td>${memberInfoVO.emailId }</td>
		</tr>
		<tr>
			<td>NICK NAME:</td>
			<td>${memberInfoVO.usrNickName }</td>
		</tr>
		<tr>
			<td>USER_POINT:</td>
			<td>${memberInfoVO.grdPnt }</td>
		</tr>
		<tr>
			<td>registeredDate:</td>
			<td>${memberInfoVO.rgstDT}</td>
		</tr>
		
	
	</table>
</body>
</html>