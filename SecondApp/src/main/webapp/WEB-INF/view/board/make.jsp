<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<c:url value="/js/jquery-1.11.2.js"/>"></script>
<script type="text/javascript">
	
	$(document).ready(function() {
		$("#boardGrade").change(function() {
			
			var optionKey = $(this).val();

			if ( optionKey == 4 ) {
				$("#boardSecondGrade").removeAttr("disabled");
			}
			
			else {
				$("#boardSecondGrade").attr("disabled", "disabled");
				$("#boardSecondGrade").val("");
			}
			
		});
		
		$("#btn").click(function() {
			
			if( $("#boardCode").val() == "" ) {
				alert("코드를 작성해주세요!");
				return;
			}
			if( $("#boardName").val() == "" ) {
				alert("이름을 작성해주세요!");
				return;
			}
			if( $("#boardGrade").val() == "" ) {
				alert("등급을 선택해주세요!");
				return;
			}
			if( $("#boardGrade").val() == 4 ) {
				if ( $("#boardSecondGrade").val() == "" ) {
					alert("두 번째 등급을 선택해주세요!");
					return;
				}
			}
			
			$("#boardMakeForm").attr("action", "<c:url value="/board/table/domake"/>");
			$("#boardMakeForm").attr("method", "post");
			$("#boardMakeForm").submit();
		});
		
	});
	
</script>
</head>
<body>
	
	<form name="boardMakeForm" id="boardMakeForm">
		<table>
			<tr>
				<td>Table Code</td>
				<td>Table Name</td>
				<td>Table Access Grade 1</td>
				<td>Table Access Grade 2</td>
			</tr>
			<tr>
				<td>
					<input type="text" name="boardCode" id="boardCode" />
				</td>
				<td>	
					<input type="text" name="boardName" id="boardName" />
				</td>
				<td>	
					<select name="boardGrade" id="boardGrade"> 
						<option value="">선택해주세요.</option>
						<c:forEach var="grade" items="${gradeList}">
							<option value="${grade.gradeIndex}">${grade.gradeName}</option>
						</c:forEach>
					</select>
				</td>	
				<td>
					<select name="boardSecondGrade" id="boardSecondGrade" disabled="disabled"> 
						<option value="">선택해주세요.</option>
						<c:forEach var="grade" items="${memberGradeList}">
							<option value="${grade.gradeIndex}">${grade.gradeName}</option>
						</c:forEach>
					</select>
				</td>	
			</tr>
		</table>
		<input type="button" id="btn" value="생성" />
	</form>
	
</body>
</html>