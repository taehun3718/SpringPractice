<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>커맨드 객체를 이용한 데이터 전송 예제</title>
</head>
<body>
<h1>커맨드 객체를 이용한 데이터 전송 예제</h1>
	<form:form commandName="memberRegisterRequestVO"
				method="post" action="/ExampleOfParamTransmit/paramHttpServletRequest3">
	email:<input type="text" name="email" value="${memberRegisterVO.email }"/><br/>
	name:<input type="text" name="name" value="${memberRegisterVO.name}"/><br/>
	password:<input type="text" name="password" value="${memberRegisterVO.password }"/><br/>
	confirmPassword:<input type="text" name="confirmPassword" value="${memberRegisterVO.confirmPassword }"/><br/>
	<input type="submit" value="전송!"/>
	</form:form>
</body>
</html>