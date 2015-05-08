<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>등급을 넣는 페이지</title>
<script type="text/javascript" src="<c:url value="/js/jquery-1.11.2.js" />"></script>
<script type="text/javascript">
	
	$(document).ready(function(){
		
		console.log("ready");
		$("#btnSubmit").click(function(){
			console.log("clicked");
			//TODO:Ajax통신
			var grade = $("#grade").val();
			var gradePoint = $("#gradePoint").val();
			
			console.log(grade + "/" + gradePoint)
			
			$("#gradeForm").attr("method", "post");
			$("#gradeForm").attr("action", "<c:url value="/grade/doGrade"/>")
			$("#gradeForm").submit();
			
		});
		
	});
	
</script>
</head>
<body>
<form:form	commandName="gradeInfoVO"
			id="gradeForm"
			name="gradeForm">
	<table>
		<tr>
			<th>등급명</th>
			<td>
			<input	type="text"
					id="gradeName" 
					name="gradeName"
					required="required"
					placeholder="등급 이름을 입력해주세요!!"/></td>
		</tr>
		<tr>
			<th>포인트</th>
			<td><input	type="text" 
						id="gradePoint"
						name="gradePoint"
						required="required"
						placeholder="포인트를 입력해주세요!!"/></td>
		</tr>
	</table>
	<input type="button" id="btnSubmit" value="등록"/>
</form:form>
<a href="./listGrade">조회 페이지로</a>
</body>
</html>