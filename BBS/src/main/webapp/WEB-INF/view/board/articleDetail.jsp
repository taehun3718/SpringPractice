<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판 상세뷰 입니다.</title>
</head>
<style>

tr th .id{
	width:100px;
}

</style>
<h1>게시판 상세 뷰</h1>
<body>
	<table border="1">
		<tr>
			<th class="id">번호:</th>
			<td>${articleVO.id }</td>
		</tr>
		<tr>
			<th class="id" style="width:50px;">제목:</th>
			<td>${articleVO.subject }</td>
		</tr>
		<tr>
			<th class="content">내용:</th>
			<td  style="width:400px;">${articleVO.content }</td>
		</tr>
		<tr>
			<th class="id">파일1:</th>
			
			<td>
				<c:if test="${ empty articleVO.uploadFileOne }">
					파일이 비엇어요 ㅠㅠ
				</c:if>
				${articleVO.uploadFileOne }
				<a href="<c:url value="/board/download/${articleVO.id }/0"/>"><img src="http://cdn-img.easyicon.net/png/5099/509904.png"/></a>
			</td>
		</tr>
		<tr>
			<th class="id">파일2:</th>
			<td>
				<c:if test="${ empty articleVO.uploadFileTwo }">
					파일이 비엇어요 ㅠㅠ
				</c:if>
				${articleVO.uploadFileTwo }
				<img src="http://cdn-img.easyicon.net/png/5099/509904.png"/><a href="<c:url value="/board/download/${articleVO.id }/1"/>"><img src="http://cdn-img.easyicon.net/png/5099/509904.png"/></a>
			</td>
		</tr>
	</table>
	<a href="<c:url value="/board/modify/${articleVO.id }"/>">수정</a>/
	<a href="<c:url value="/board/doDelete/${articleVO.id }"/>">삭제</a>/
	<a href="<c:url value="/board/articleList"/>">리스트 페이지</a>
</body>
</html>