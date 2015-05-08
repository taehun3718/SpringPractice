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
		
		$(".gradeList").on("click", ".gradeRow .modify", function(){
			
			//데이터를 수정하기 위한 id(PK)를 구하는 jQuery
			var idx  		= $(this).parent().parent().children(":eq(0)").text();
			var gradeName	= $(this).parent().parent().children(":eq(1)").children().val();
			var gradePoint	= $(this).parent().parent().children(":eq(2)").children().val();
			
			var redirectSite;
			console.log(idx + "/" + gradeName + "/" + gradePoint);
			$.post("<c:url value="/grade/modifyGradeAjax"/>"
					,{"idx" : idx
					,"gradeName" : gradeName
					,"gradePoint" : gradePoint}
					, function(data) {
			});
			//jQuery로 구현하고 싶은데 일딴 redirect로 구현
		});
		
		$(".gradeList").on("click", ".gradeRow .delete", function(){
			
			//데이터를 수정하기 위한 id(PK)를 구하는 jQuery
				//데이터를 수정하기 위한 id(PK)를 구하는 jQuery
			var idx  		= $(this).parent().parent().children(":eq(0)").text();
			var gradeName	= $(this).parent().parent().children(":eq(1)").children().val();
			var gradePoint	= $(this).parent().parent().children(":eq(2)").children().val();
			console.log("data삭제:" + idx);
			if(confirm("데이터[" + idx + "]째를 삭제할까여?" )){
				
				//jQuery로 구현하고 싶은데 일딴 redirect로 구현
				$.post("<c:url value="/grade/deleteGradeAjax"/>"
						,{"idx" : idx}
						, function(data) {
				});
				
			}
			//window.location="/FirstApp/grade/listGrade";
			location.href = "/FirstApp/grade/listGrade";
		});
	});
	
</script>
</head>
<style>

	.modify, .delete{
		cursor:pointer;
	}

</style>
<body>
<h1>등록된 등급 리스트</h1>
<table class="gradeList">
	<tr>
		<th>순번</th>
		<th>등급이름</th>
		<th>포인트</th>
		<th>수정버튼</th>
		<th>삭제버튼</th>
	</tr>
	<c:forEach var="grade" items="${allGradeList }">
		<tr class="gradeRow">
			<td><c:out value="${grade.gradeIdx}"/></td>
			<td><input type="text" name="gradeName" value="${grade.gradeName }"/></td>
			<td><input type="text" name="gradePoint" value="${grade.gradePoint }"/></td>
			<td><span class="modify">수정</span>
			<td><span class="delete">삭제</span>
		<td>
	</c:forEach>
</table>
TODO : 삭제하고 싶거나, 수정하고 싶은 목록 1가지를 수정하거나 삭제할 수 있습니다.
<a href="./insertGrade">추가 페이지로</a>
</body>
</html>