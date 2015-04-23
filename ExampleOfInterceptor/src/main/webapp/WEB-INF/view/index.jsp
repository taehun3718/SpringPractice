<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>예제에요 ㅋㅋ</title>
</head>
<c:if test="${not empty memberVO }">
	<table>
		<tr>
			<td>Login ID : </td>
			<td> ${memberVO.id }</td>
		</tr>
		<tr>
			<td colspan="1">환영합니다.</td>
		</tr>
	</table>
</c:if>
<a href="<c:url value="/doLogout"/>">로그아웃</a>
<body>
</body>
</html>