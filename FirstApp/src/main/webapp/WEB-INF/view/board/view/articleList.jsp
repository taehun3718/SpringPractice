<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>리스트</title>
</head>
<body>
	<table>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>사용자</th>
		</tr>
	<c:forEach var="article" items="${articleList }">
		<tr class="article">
			<td>${article.index }</td>
			<td>${article.subject }</td>
			<td>${article.memberId }</td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>