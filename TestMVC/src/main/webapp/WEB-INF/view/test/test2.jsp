<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<c:url value="/js/jquery-1.11.2.js"/>"></script>
<script type="text/javascript">
	$(document).ready(function() {
		/* alert("jQuery 로드 완료!"); */
		$.post("<c:url value="/hello"/>", {}, function (data) {
			/* alert(data); */
			console.log("Data:" + data)
		});
		$.post("<c:url value="/getJson"/>", {}, function (data) {
			/* alert(data); */
		});
	});
</script>
</head>
<body>
${helloMessage } <br/>
${byeMessage }
<a href="/TestMVC/test5">전송!</a>
<form method="post" action="/TestMVC/test5">
	<input type="submit" value="전송"/>
</form>


<a href="/TestMVC/test7?id=abc">전송test7!</a>
<form method="post" action="/TestMVC/test7">
	<input type="text" name="id"/>
	<input type="submit" value="전송!"/>
</form>


<a href="/TestMVC/test7?id=abc">전송test9!</a>
<!-- <form method="post" action="/TestMVC/test9"> -->
	<form:form commandName="memberRegisterRequestVO"
				method="post" action="/TestMVC/test9">
	체크드<input type="checkbox" name="isCheck" value="true"/><br>

	Names:<input type="text" name="names" value="${memberRegisterVO.names[0] }"/><br/>
	Names:<input type="text" name="names" value="${memberRegisterVO.names[1] }"/><br/>
	Names:<input type="text" name="names" value="${memberRegisterVO.names[2] }"/><br/>
	Names:<input type="text" name="names"/><br/>
				

	Email:<input type="text" name="email" value="${memberRegisterVO.email }"/>
	<form:errors path="email"></form:errors><br/>
	
	name:<input type="text" name="name" value="${memberRegisterVO.name }"/>
	<form:errors path="name"></form:errors><br/>
	
	Password:<input type="text" name="password"/><br/>
	Confirm Password:<input type="text" name="password"/><br/>
	<input type="submit" value="전송!"/>
<!-- </form> -->
</form:form>

	<%-- 	<form method="post" enctype="multipart/form-data" action="<c:url value="/doUpload"/>">
		<input type="text" name="name"/>
		<input type="file" name="file"/>
		<input type="submit" value="전송"/>
	</form>
	 --%>
	<form:form commandName="uploadVO"
			   method="post" 
			   enctype="multipart/form-data"
			   action="/TestMVC/doUpload2">
		<input type="text" name="name"/>
			<form:errors path=""></form:errors>
		<input type="file" name="file"/>
		    <form:errors path=""></form:errors>
		    
		<input type="submit" value="전송"/>
	</form:form>
	
</body>
</html>