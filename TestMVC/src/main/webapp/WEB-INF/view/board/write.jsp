<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form:form commandName="articleVO" method="post" action="/TestMVC/doWrite">

	<input type="text" name="subject" placeholder="제목"/> 
		<form:errors path="subject"></form:errors><br/>
	<textarea rows="5" cols="20" name="content" placeholder="내용"></textarea>
		<form:errors path="content"></form:errors><br/>
	<input type="submit" value="저장!"/>

</form:form>

</body>
</html>