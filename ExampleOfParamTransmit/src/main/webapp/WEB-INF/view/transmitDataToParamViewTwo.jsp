<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<title>데이터 전송 예제2) with @RequestMapping</title>
<head></head>
<body>
<H1>데이터 전송 예제2) with @RequestMapping</H1>
아래는 defaultValue가 없을 경우의 처리
<form method="post" action="/ExampleOfParamTransmit/paramHttpServletRequest2">
	<input type="text" name="id"/>
	<input type="submit" value="전송"/>
</form>
아래는 defaultValue가 있을 경우의 처리
</body>
</html>