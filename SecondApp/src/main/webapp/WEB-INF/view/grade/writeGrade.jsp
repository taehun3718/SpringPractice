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

	$(document).ready(function(data) {
		
		$("#writeGrade").click(function() {
			$("#writeForm").attr("method", "post");
			
			<c:if test="${ empty gradeVO.gradeIndex }">
				$("#writeForm").attr("action", "<c:url value="/grade/doWrite"/>");
			</c:if>	
			<c:if test="${ not empty gradeVO.gradeIndex }">
				$("#writeForm").attr("action", "<c:url value="/grade/doModify"/>");
			</c:if>	
			$("#writeForm").submit();
		});
	});

</script>
</head>
<body>
	<form:form commandName="gradeVOInfo" id="writeForm" name="writeForm">
					<input type="hidden" name="gradeIndex" id="gradeIndex" value="<c:out value="${gradeVO.gradeIndex }"/>"/>
		등급 이름 : <input type="text" name="gradeName" id="gradeName" value="<c:out value="${gradeVO.gradeName }"/>"/> <br/> <br/>
		등급 포인트 : <input type="text" name="conditionPoint" id="conditionPoint" value="<c:out value="${gradeVO.conditionPoint }"/>"/> <br/> <br/>
	<input type="button" value="등록" id="writeGrade" />
	</form:form>
</body>
</html>