<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<c:url value="/js/jquery-1.11.2.js" />"></script>
<script type="text/javascript">
	$(document).ready(function() {
		console.log("ready");
		
		$("#grade").change(function(){
			$(".userCheck").each(function(index, data) {
				if($(data).attr("id")!=1) {
					$(data).prop("disabled", "");//회원 등급이 아니면 disabled로 처리
				}
			});
		});
		//세부 등급을 선택했을때 발생하는 이벤트
		$("#sndGrade").change(function(){
			console.log("CHANGED");
			$(".userCheck").each(function(index, data) {
				
				//회원리스트에서 등급이 회원이 경우인지 확인하는 로직
				if($(data).attr("id")!=4) {
					$(data).prop("disabled", "disabled");//회원 등급이 아니면 disabled로 처리
					
				}
			});
		});
		
		
		
		$("#allCheck").click(function(){
			var isAllCheck = $(this).prop("checked");
			$("input.userCheck").prop("checked", isAllCheck);
		});
		
		
		$("#btn").click(function(){
			var checkedCount = 0; 
			//1. 체크박스가 하나라도 선택이 되어 있는지 확인한다.
			$(".userCheck").each(function(index, data) {
				
				/*
				/* each:반복 */
				/*
				alert("data:" + data);
				alert("index:" + index);*/
				
				/* alert($(data).prop("checked")); */
				if($(data).prop("checked")){
					checkedCount++;
				}
			});
			
			if(checkedCount == 0){
				
				alert("한 명 이상의 회원을 선택하세요.");
				return;
				
			}
			//2. 등급을 선택했는지 확인한다.
			if( $("#grade").val() == "") {
				alert("일괄적용할 등급을 선택하세요!");
				return;
			}
			//3. 이상이 없다면. submit 한다.
			$("#changeGradeForm").attr("method", "post");
			$("#changeGradeForm").attr("action", "<c:url value="/member/grade/injection/"/>");
			$("#changeGradeForm").submit();
			
		});
		
		$("#btnSnd").click(function(){
		
			console.log("snd");
			var checkedCount = 0; 
			//1. 체크박스가 하나라도 선택이 되어 있는지 확인한다.
			$(".userCheck").each(function(index, data) {
				if($(data).prop("checked")){
					checkedCount++;
				}
			});
			
			if(checkedCount == 0){
				
				alert("한 명 이상의 회원을 선택하세요.");
				return;
				
			}
			//2. 등급을 선택했는지 확인한다.
			if( $("#btnSnd").val() == "") {
				alert("일괄적용할 세부등급을 선택하세요!");
				return;
			}
			//3. 이상이 없다면. submit 한다.
			
			$("#changeGradeForm").attr("method", "post");
			$("#changeGradeForm").attr("action", "<c:url value="/member/grade/injectionSnd/"/>");
			$("#changeGradeForm").submit();
			
			
		});
		
	});
</script>
</head>
<style>

h1{
	font-size: 20px;
}

</style>

<body>
	<form id="changeGradeForm" name="changeGradeForm">
		<h1>회원정보</h1>
			<table>
				<tr>
					<th><input type="checkbox" name="allCheck" id="allCheck"></th>
					<th>ID</th>
					<th>닉네임</th>
					<th>등급</th>
					<th>세부등급</th>
					<th>가입날짜</th>
				</tr>
				<!-- attr:memberList -->
			<c:forEach var="member" items="${memberList }">
				<tr>
					<td>
						<c:if test="${member.usrGrd eq '1'}">
							<input	type="checkbox"
									class="userCheck" 
									disabled="disabled" 
									name="selectedId" 
									value="${member.usrId }" 
									id="${member.usrGrd }">
						</c:if>
						<c:if test="${member.usrGrd ne '1'}">
							<input type="checkbox"
								   class="userCheck" 
								   name="selectedId" 
								   value="${member.usrId }" 
								   id="${member.usrGrd }">
						</c:if>
					</td>
					<td><a href="<c:url value="/member/${member.usrId }"/>">${member.usrId}</a></td>
					<td>${member.usrNickName}</td>
					<td>${member.usrGrd}</td>
					<td>${member.usrSndGrd}</td>
					<td>${member.rgstDT}</td>
				</tr>
			</c:forEach>
			</table>
			<select name="grade" id="grade">
					<option value="">선택해주세요</option>
					<c:forEach var="grade" items="${gradeList}">
						<option value="${grade.gradeIdx }">${grade.gradeName }</option>
					</c:forEach>
			</select>
			<input type="button" id="btn" value="일괄적용(권한)"/>
			
			<select name="sndGrade" id="sndGrade">
					<option value="">선택해주세요</option>
					<c:forEach var="grade" items="${memberGradeList}">
						<option value="${grade.gradeIdx }">${grade.gradeName }</option>
					</c:forEach>
			</select>
			<input type="button" id="btnSnd" value="일괄적용(세부등급)"/>
	</form>
	경고/ 일괄 처리 기능은 각각 동작합니다.
</body>
</html>










