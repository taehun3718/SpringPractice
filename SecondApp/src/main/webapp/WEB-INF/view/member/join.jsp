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
		
		if ( $("#usrId").val() != "" ) {
			$("#usrId").keyup();
		}
		
		$("#usrId").keyup(function() {
			$.post("<c:url value="/member/checkDuplicateUserIdAjax"/>", 
					{"usrId" : $("#usrId").val()}, function(data) {
						console.log(data);
						if ( data == true ) {
							$("#duplicateResult").text("이미 사용중인 ID 입니다.");
						}
						
						else {
							$("#duplicateResult").text("사용 가능한 ID 입니다.");
						}
					});
		});
		
		// 회원 가입 클릭
		$("#joinMember").click(function() {
			
			if ( $("#usrId").val() == "" ) {
				alert("ID를 입력하세요!");
				return;
			}
			if ( $("#emailId").val() == "" ) {
				alert("Email를 입력하세요!");
				return;
			}
			if ( $("#emailHost").val() == "" ) {
				alert("EmaiHost를 입력하세요!");
				return;
			}
			if ( $("#usrPwd").val() == "" ) {
				alert("Password를 입력하세요!");
				return;
			}
			if ( $("#usrPwd2").val() == "" ) {
				alert("Password를 입력하세요!");
				return;
			}
			
			if ( $("#usrPwd").val() != $("#usrPwd2").val() ) {
				alert("비밀번호가 일치하지 않습니다!");
				return;
			}
			
			if ( $("#usrNickName").val() == "" ) {
				alert("NickName를 입력하세요!");
				return;
			}
			
			var idCheckResult = $("#duplicateResult").text();
			if ( idCheckResult == "이미 사용중인 ID 입니다." ) {
				alert("다른 ID를 사용해 주세요.")
				return;
			}
			
			$("#joinForm").attr("method", "post");
			$("#joinForm").attr("action", "<c:url value="/member/doJoin"/>");
			$("#joinForm").submit();
			
		});
		
	});

</script>
</head>
<body>
	<!-- 아이디, 이메일, 비밀번호, 닉네임, 회원정보 노출 여부 -->
	
	<h1>회원 가입</h1>
	
	<form:form commandName="memberInfoVO" id="joinForm" name="joinForm">
		ID : <input type="text" name="usrId" id="usrId" maxlength="20" value="${memberInfoVO.usrId }"/> 
			<span id="duplicateResult">
				<c:out value="${duplicateUserId }" />
			</span>
			<form:errors path="usrId"/> <br/>
		Email : <input type="text" name="emailId" id="emailId" value="${memberInfoVO.emailId}"/> @ 
				<input type="text" name="emailHost" id="emailHost" value="${memberInfoVO.emailHost}"> 
			<form:errors path="emailId"/>
			<form:errors path="emailHost"/>
			<c:out value="${emailError}" />
			<br/>
		Password : <input type="password" name="usrPwd" id="usrPwd"/> 
			<form:errors path="usrPwd"/> <br/>
		Re-Password : <input type="password" name="usrPwd2" id="usrPwd2"/>
			<form:errors path="usrPwd2"/> <br/>
		NickName : <input type="text" name="usrNickName" id="usrNickName" value="${memberInfoVO.usrNickName}"/> 
			<form:errors path="usrNickName"/> <br/>
		Show My Info :
			<c:if test="${memberInfoVO.showMyInfo eq 'Y' || empty memberInfoVO}">
			예 <input type="radio" name="showMyInfo" class="showMyInfo" value="Y" checked="checked"/>
		아니오 <input type="radio" name="showMyInfo" class="showMyInfo" value="N" />
			</c:if>
			<c:if test="${memberInfoVO.showMyInfo eq 'N' }">
			예 <input type="radio" name="showMyInfo" class="showMyInfo" value="Y" />
		아니오 <input type="radio" name="showMyInfo" class="showMyInfo" value="N" checked="checked"/>
			</c:if>
			<form:errors path="showMyInfo"/>
	<input type="button" value="회원가입" id="joinMember" />
	</form:form>
</body>
</html>