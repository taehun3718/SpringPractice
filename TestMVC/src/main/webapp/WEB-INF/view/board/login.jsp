<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인 페이지</title>
</head>
<body>
패스워드는 1234입니다.ㅋㅋ
<form:form method="post" action="/TestMVC/doLogin">
	아이디  :<input type="text"><br/>
	패스워드:<input type="text" id="pwd"><br/>
</form:form>
</body>
</html>