<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<c:url value="/js/jquery-1.11.2.js"/> "></script>
<script type="text/javascript">
	
	var tableCreateFlag = false;
	$(document).ready(function(){
		console.log("ready");
		$("#boardGrade").change(function(){
			var optionKey = $(this).val();
			console.log("OptionKey:" + optionKey);
			if(optionKey == "4"){
				$("#boardSecondGrade").removeAttr("disabled");
			}
			else{
				$("#boardSecondGrade").attr("disabled","disabled");
				$("#boardSecondGrade").val("");
			}
		});
		
		$("#btn").click(function() {
			
			if( $("#boardCode").val() == "") {
				
				alert("코드를 작성해주세요!");
				return;
				
			}
			if( $("#boardName").val() == "") {
				
				alert("이름을 작성해주세요!");
				return;
				
			}
			if( $("#boardGrade").val() == "") {
				
				alert("등급을 선택해주세요!");
				return;
				
			}
			if( $("#boardGrade").val() == "4") {
				if( $("#boardSecondGrade").val() == "") {
					alert("두 번째 등급을 선택해주세요!");
					return;
				}
				
			}
			
			$("#boardMakeForm").attr("action", "<c:url value="/board/domake/"/>");
			$("#boardMakeForm").attr("method", "post");
			if(!tableCreateFlag){
				
				alert("테이블 이름은 중복되서는 안됩니다.!");
				return;
			}
				
			$("#boardMakeForm").submit();

		});
		
		
		$("#boardCode").keyup(function() {
			$.post("<c:url value="/board/isDuplicateTable"/>"
					,{"tableCode" : $("#boardCode").val()}
					, function(data) {
				console.log(data);
				
				if(data=="true") {
					$("#isDuplicateCodeMsg").text("이미 사용중인 Code 입니다.");
					tableCreateFlag = false;
				}
				else {
					$("#isDuplicateCodeMsg").text("사용 가능한 Code 입니다.");
					tableCreateFlag = true;
				}
			});
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
					<input type="text" name="boardCode" id="boardCode"/>
				</td>
				<td>
					<input type="text" name="boardName" id="boardName"/>
				</td>
				<td>
					<select name="boardGrade" id="boardGrade">
						<option value="">선택해주세요.</option>
						<c:forEach var="grade" items="${gradeList }">
							<option value="${grade.gradeIdx }">${grade.gradeName }</option>
						</c:forEach>
					</select>
				</td>
				
				<td>
					<select name="boardSecondGrade" id="boardSecondGrade" disabled="disabled">
						<option value="">선택해주세요</option>
						<c:forEach var="grade" items="${memberGradeList }">
							<option value="${grade.gradeIdx }">${grade.gradeName }</option>
						</c:forEach>
					</select>
				</td>
				
			</tr>
		</table>
		<table>
			<tr>
				<td>메세지:</td>
				<td><span id="isDuplicateCodeMsg"></span></td>
			</tr>
		</table>
		<input type="button" id="btn" value="생성"/>
	</form>
</body>
</html>