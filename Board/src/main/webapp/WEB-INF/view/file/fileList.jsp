<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>데이터베이스 파일 조회</title>
</head>
<body>
<table>
		<tr>
			<th>번호</th>
			<th>UUID_1</th>
			<th>File_1</th>
			<th>UUID_2</th>
			<th>File_2</th>
		</tr>
	<c:forEach var="board" items="${boardList }">
		<tr class="boardList">
			<td>${board.id }</td>
			<td>${board.originalFileOne }</td>
			<td>${board.UUIDFileOne }</td>
			<td>${board.originalFileTwo }</td>
			<td>${board.UUIDFileTwo }</td>
	</c:forEach>
	</table>
</body>
</html>