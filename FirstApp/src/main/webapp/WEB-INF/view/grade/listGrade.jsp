<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>등급리스트를 확인하는 페이지</title>
<script type="text/javascript" src="<c:url value="/js/jquery-1.11.2.js" />"></script>
<script type="text/javascript">
	
	$(document).ready(function(){
		
	});
	
</script>
</head>
<body>
<table>
	<tr>
		<th>순번</th>
		<th>등급이름</th>
		<th>포인트</th>
	</tr>
	<c:forEach var="grade" items="${allGradeList }">
		<tr>
			<td><c:out value="${grade.gradeIdx}"/></td>
			<td><c:out value="${grade.gradeName}"/></td>
			<td><c:out value="${grade.gradePoint}"/></td>
		<td>
	</c:forEach>
</table>
</body>
</html>