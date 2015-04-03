<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/resources/css/bootstrap.min.css"/>
<link rel="stylesheet" type="text/css" href="/resources/css/bootstrap-theme.min.css"/>
<script type="text/javascript" src="/resources/js/jquery-1.11.2.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<style>

	.table .num{
		background:lime;
		width:50px;
	}
	
	.table .title{
		background:orange;
		width:200px;
	}

</style>

<body>
<script type="text/javascript">
	$(document).ready(function(){
		console.log("ready to jQuery");
	});
</script>
<table class="table" border="1">
	<tr >
		<th class="num">번호</th>
		<th class="title">제목</th>
	</tr>
	
	<c:if test= "${empty allArticleList }" >
	<tr>
		<td colspan="2">게시글이 없어요!</td>
	</tr>
	</c:if>
	
	
	<c:forEach var="article" items="${allArticleList }">
		<tr>
			<td><c:out value="${article.id}"/></td>
		<td>
			<a href="<c:url value="/detail/${article.id }"/>">
			<c:out value="${article.subject}"/>
			</a>
		</td>
	</c:forEach>
</table>
<a href ="<c:url value="/write"/>">쓰기</a>
</body>
</html>