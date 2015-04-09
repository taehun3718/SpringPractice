<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<title>데이터 전송 예제1) with httpServletRequest</title>
<head></head>
<body>
<H1>데이터 전송 예제1) with httpServletRequest</H1>
<form method="post" action="/ExampleOfParamTransmit/paramHttpServletRequest">
	<input type="text" name="id"/>
	<input type="submit" value="전송"/>
</form>
</body>
</html>