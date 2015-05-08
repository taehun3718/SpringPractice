<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시글 리스트입니다.</title>
</head>
<h1>게시글 리스트</h1>
<body>
	<table>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>삭제</th>
		</tr>
	<c:forEach var="article" items="${articleList }">
		<tr class="articleList">
			<td>${article.id }</td>
			<td>
				<a href="<c:url value="/board/articleDetail/${article.id}"/>">${article.subject }</a>
			</td>
			<td>
				<a href="<c:url value="/board/doDelete/${article.id}"/>">삭제</a>
			</td>
	</c:forEach>
	</table>
	<a href="<c:url value="/board/write"/>">글쓰기</a>
</body>
</html>