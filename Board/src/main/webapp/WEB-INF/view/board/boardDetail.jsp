<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>보드 상세뷰 입니다.</title>
</head>
<h1>보드 상세 뷰</h1>
<body>
	<table>
		<tr>
			<th>번호:</th>
			<td>${boardVO.id }</td>
		</tr>
		<tr>
			<th>제목:</th>
			<td>${boardVO.subject }</td>
		</tr>
		<tr>
			<th>내용:</th>
			<td>${boardVO.content }</td>
		</tr>
		<tr>
			<th>파일:</th>
			<td>${boardVO.uploadFile }</td>
		</tr>
	</table>
	<a href="<c:url value="/board/modify/${boardVO.id }"/>">수정</a>/
	<a href="<c:url value="/board/doDelete/${boardVO.id }"/>">삭제</a>/
	<a href="<c:url value="/board/list"/>">리스트 페이지</a>
</body>
</html>