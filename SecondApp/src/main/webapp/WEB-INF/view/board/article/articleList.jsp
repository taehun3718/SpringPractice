<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<c:url value="/js/jquery-1.11.2.js"/>"></script>
<script type="text/javascript">
</script>
</head>
<body>
		<table>
		<tr>
			<th>ID</th>
			<th>제목</th>
			<th>작성 날짜</th>
			<th>조회수</th>
		</tr>
		<c:forEach var="article" items="${allArticleList}" >
			<tr>
				<td><c:out value="${article.memberId }"/></td>
				<td>
				<a href="<c:url value="/board/${tableName}/detail/${article.tableId}"/>">
					<c:out value="${article.subject }" />
				</a>
				</td>
				<td><c:out value="${article.createdDate }" /></td>
				<td><c:out value="${article.hitCount }" /></td>
			</tr>
		</c:forEach>
		</table>
		
</body>
</html>