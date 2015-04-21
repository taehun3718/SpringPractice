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
	$(document).ready(function() {
		
		$("#allCheck").click(function(){
			var isAllCheck = $(this).prop("checked");
			$("input.userCheck").prop("checked", isAllCheck);
		});

		$("#btn").click(function() {
			
			var checkedCount = 0;
			
			// 1. 체크박스가 하나라도 선택이 되어 있는지 확인한다
			$(".userCheck").each(function(index, data) {
				/*
				alert("data :" + data);
				alert("index : " + index); 
				alert($(data).prop("checked"));
				*/
				if ( $(data).prop("checked") ) {
					checkedCount++;
				}
			});
			
			if ( checkedCount == 0 ) {
				alert("한 명 이상의 회원을 선택해주세요!");
				return;
			}
			// 2. 등급을 선택했는지 확인한다
			if ( $("#grade").val() == 0 ) {
				alert("일괄적용할 등급을 선택하세요!");
				return;
			}
			
			// 3. 이상이 없다면, submit 한다
			$("#changeGradeForm").attr("method", "post");
			$("#changeGradeForm").attr("action", "<c:url value="/member/grade/injection" />");
			$("#changeGradeForm").submit();
			
		});
		
	 });
</script>
</head>
<body>
	<form id="changeGradeForm" name="chanegeGradeForm">
		<table>
		<tr>
			<th><input type="checkbox" name="allCheck" id="allCheck"></th>
			<th>ID</th>
			<th>닉네임</th>
			<th>등급</th>
			<th>가입일자</th>
		</tr>
		<c:forEach var="member" items="${memberList}" >
			<tr>
				<c:if test="${member.userGrade eq '1'}" >
					<td><input type="checkbox" class="userCheck" name="checkedId" value="${member.usrId }" disabled="disabled"></td>
				</c:if>
				<c:if test="${member.userGrade ne '1'}" >
					<td><input type="checkbox" class="userCheck" name="checkedId" value="${member.usrId }"></td>
				</c:if>
				<td><a href="<c:url value="/member/detail/${member.usrId}"/>"><c:out value="${member.usrId }"/></a></td>
				<td><c:out value="${member.usrNickName }" /></td>
				<td><c:out value="${member.userGrade }" /></td>
				<td><c:out value="${member.registDate }" /></td>
			</tr>
		</c:forEach>
		</table>
		
		<select name="grade" id="grade"> 
			<option value="">선택해주세요.</option>
			<c:forEach var="grade" items="${gradeList}">
				<option value="${grade.gradeIndex}">${grade.gradeName}</option>
			</c:forEach>
		</select>
		
		<input type="button" id="btn" value="일괄적용" />
	</form>
</body>
</html>