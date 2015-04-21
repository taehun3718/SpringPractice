<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>zzz</title>
<script type="text/javascript" src="<c:url value="/js/jquery-1.11.2.js"/>"></script>
<script type="text/javascript">

	$(document).ready(function(data) {
		
		$("#submit").click(function() {
			location.href("<c:url value="/grade/write"/>");
		});
		
		$(".delete").click(function() {
			
			alert($(".delete").val());
			
		});
		
	});

</script>
</head>
<body>
	<table border="1">
	<c:forEach var="grade" items="${allGradeList}" >
		<tr>
			<td><c:out value="${grade.gradeIndex }"/></td>
			<td><c:out value="${grade.gradeName }" /></td>
			<td><c:out value="${grade.conditionPoint }" /></td>
			<%-- <td>
				<input type="hidden" class="gradeName" value="${grade.gradeName }" />
				<input type="button" class="modify" value="수정" />
			</td> --%>
			<td>
				<%-- <input type="hidden" class="gradeIndex" value="${grade.gradeIndex }" /> --%>
				<!-- <input type="button" class="delete" value="삭제" /> -->
				<span class="modify"><a href="<c:url value="/grade/modify/${grade.gradeIndex}"/>">수정</a></span>
				<span class="delete"><a href="<c:url value="/grade/${grade.gradeIndex}"/>">삭제</a></span>
			</td>
		</tr>
	</c:forEach>
	</table>
	<span id="submit">등록</span>
</body>
</html>