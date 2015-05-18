<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>보드 상세뷰 입니다.</title>
</head>
<style>

tr th .id{
	width:100px;
}

</style>
<h1>보드 상세 뷰</h1>
<body>
	<table border="1">
		<tr>
			<th class="id">번호:</th>
			<td>${boardVO.id }</td>
		</tr>
		<tr>
			<th class="id" style="width:50px;">제목:</th>
			<td>${boardVO.subject }</td>
		</tr>
		<tr>
			<th class="content">내용:</th>
			<td  style="width:400px;">${boardVO.content }</td>
		</tr>
		<tr>
			<th class="id">파일1:</th>
			
			<td>
				<c:if test="${ empty boardVO.originalFileOne }">
					파일이 비엇어요 ㅠㅠ
				</c:if>
				${boardVO.originalFileOne }
				<img src="<c:url value="/board/download/${boardVO.id }/0"/>" width="100" height="200"/>
				<a href="<c:url value="/board/download/${boardVO.id }/0"/>"><img src="http://cdn-img.easyicon.net/png/5099/509904.png"/></a>
			</td>
		</tr>
		<tr>
			<th class="id">파일2:</th>
			<td>
				<c:if test="${ empty boardVO.originalFileTwo }">
					파일이 비엇어요 ㅠㅠ
				</c:if>
				${boardVO.originalFileTwo }
				<img src="<c:url value="/board/download/${boardVO.id }/1"/>" width="100" height="200"/>
				<a href="<c:url value="/board/download/${boardVO.id }/1"/>"><img src="http://cdn-img.easyicon.net/png/5099/509904.png"/></a>
			</td>
		</tr>
	</table>
	<a href="<c:url value="/board/modify/${boardVO.id }"/>">수정</a>/
	<a href="<c:url value="/board/doDelete/${boardVO.id }"/>">삭제</a>/
	<a href="<c:url value="/board/articleList"/>">리스트 페이지</a>
</body>
</html>