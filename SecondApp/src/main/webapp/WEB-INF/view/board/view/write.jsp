<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<c:url value="/js/jquery-1.11.2.js"/>"></script>
<script type="text/javascript">

	$(document).ready(function() {
		
		$("#btn").click(function() {
			
			if( $("#subject").val() == "" ) {
				alert("제목을 입력하세요!");
				return;
			}
			
			if( $("#content").val() == "" ) {
				alert("내용을 입력하세요!");
				return;
			}
			
			$("#writeForm").attr("action", "<c:url value="/board/${tableName}/doWrite"/>");
			$("#writeForm").attr("method", "post");
			$("#writeForm").submit();
			
		});
	});

</script>
</head>
<body>
	
	<form name="writeForm" id="writeForm" enctype="multipart/form-data">
		제목 : <input type="text" name="subject" id="subject"/> <br/><br/>
		내용 : <textarea name="content" id="content"></textarea> <br/><br/>
		<input type="file" name="uploadFile" id="uploadFile"/> <br/><br/>
		<input type="button" id="btn" value="등록" />
	</form>
	
</body>
</html>