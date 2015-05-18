<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Write페이지입니다.</title>
</head>
<script type="text/javascript" src="<c:url value="/js/jquery-1.11.2.js" />"></script>
<script type="text/javascript">
	$(document).ready(function() {
		
		console.log("ready to jQuery");
		
		$("#uploadFileOne").hide();
		$("#uploadFileTwo").hide();
		
		$("#btnSubmit").click(function(){
			console.log("clicked");
			if($("#subject").val()=="" ) {
				alert("제목을 입력하세요!");
				return;
			}
			if($("#content").val()=="" ) {
				alert("내용을 입력하세요!");
				return;
			}
		
			$("#modifyForm").attr("action", "<c:url value="/board/doModify"/>");
			$("#modifyForm").attr("method", "post");
			$("#modifyForm").submit();
		});
		
		$("#checkFileOne").click(function() {
			var isChecked = $(this).prop("checked");
			if(isChecked) {
				$("#fileOne").css({"text-decoration": "line-through"});
				$("#fileOne").css({"color": "red"});
				$("#uploadFileOne").show();
			}
			else {
				$("#fileOne").css({"text-decoration": "none"});
				$("#fileOne").css({"color": "black"});
				$("#uploadFileOne").hide();
			}
		});
		
		$("#checkFileTwo").click(function() {
			var isChecked = $(this).prop("checked");
			if(isChecked) {
				$("#fileTwo").css({"text-decoration": "line-through"});
				$("#fileTwo").css({"color": "red"});
				$("#uploadFileTwo").show();
			}
			else {
				$("#fileTwo").css({"text-decoration": "none"});
				$("#fileTwo").css({"color": "black"});
				$("#uploadFileTwo").hide();
			}
		});
	});
</script>
<body>
	<form:form	id="modifyForm"
				name="modifyForm"
				enctype="multipart/form-data"
				commandName="boardVO">
		<input type="hidden"	name="id"
								value="${boardVO.id }"/>
		<table>
			<tr>
				<td>제목 :</td>
				<td><input	type="text" 
							id="subject" 
							name="subject"
							value="${boardVO.subject } "/>
				</td>
			</tr>
			
			<tr>
				<td>내용:</td>
				<td>
					<textarea	id="content"
								rows="10"
								cols="40"
								name="content">${boardVO.content }</textarea>
				</td>
			</tr>	
			<tr>
				<td>파일1</td>
				<td>
					<c:if test="${not empty boardVO.originalFileOne }">
						not empty
						<span id="fileOne">${boardVO.originalFileOne}</span>
						<input type="checkbox" id="checkFileOne"/>
						<span id="uploadFileOne">
							<input type="file" name="uploadFileOne"/>
						</span>
	
					</c:if>
					
					<c:if test="${empty boardVO.originalFileOne }">
						empty
					</c:if>
					
				</td>
			</tr>	
			<tr>
				<td>파일2</td>
				<td>
					<c:if test="${not empty boardVO.originalFileTwo }">
						not empty
						<span id="fileTwo">${boardVO.originalFileTwo}</span>
						<input type="checkbox" id="checkFileTwo"/>
						<span id="uploadFileTwo">
							<input type="file" name="uploadFileTwo"/>
						</span>
					</c:if>
					
					<c:if test="${empty boardVO.originalFileTwo }">
						empty
					</c:if>
				</td>
			</tr>	
		</table>
		<input	type="button"	id="btnSubmit"	value="내용 수정!"/>
	</form:form>
	<a href="<c:url value="/board/list"/>">리스트로</a>
</body>
</html>