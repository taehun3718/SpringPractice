<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>보드 리스트입니다.</title>
</head>
<h1>보드 리스트</h1>
<body>
	<table>
		<tr>
			<th>번호</th>
			<th>제목</th>
		</tr>
	<c:forEach var="board" items="${boardList }">
		<tr class="boardList">
			<td>${board.id }</td>
			<td><a href="<c:url value="/board/detail/${board.id}"/>">${board.subject }</a></td>
	</c:forEach>
	</table>
	<a href="<c:url value="/board/write"/>">글쓰기</a>
</body>
</html>