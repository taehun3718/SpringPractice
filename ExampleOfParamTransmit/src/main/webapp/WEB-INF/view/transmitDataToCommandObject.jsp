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
						method="post" 
						action="/ExampleOfParamTransmit/paramHttpServletRequest3">
			<table>
				<tr>
					<td>email:</td>
					<td>
						<input	type="text" 
								name="email" 
								value="${memberRegisterVO.email }"/>
					</td>
				</tr>
				
				<tr>
					<td>name:</td>
					<td>
						<input	type="text"
								name="name" 
								value="${memberRegisterVO.name}"/>
					</td>
				</tr>
				
				<tr>
					<td>password:</td>
					<td>
						<input	type="text" 
								name="password"
								value="${memberRegisterVO.password }"/>
					</td>
				</tr>
				
				<tr>
					<td>confirmPassword:</td>
					<td>
						<input	type="text"
								name="confirmPassword"
								value="${memberRegisterVO.confirmPassword }"/>
					</td>
				</tr>
			</table>
			<input type="submit" value="전송!"/>
		</form:form>
			<br/><br/><br/><br/>Validation Check
		<form:form commandName="memberRegisterRequestVO"
						method="post" 
						action="/ExampleOfParamTransmit/paramHttpServletRequestValidChk">
			<table>
				<tr>
					<td>email:</td>
					<td>
						<input	type="text" 
								name="email" 
								value="${memberRegisterVO.email }"/>
						<form:errors path="email"></form:errors>
					</td>
				</tr>
				
				<tr>
					<td>name:</td>
					<td>
						<input	type="text"
								name="name" 
								value="${memberRegisterVO.name}"/>
						<form:errors path="name"></form:errors>
					</td>
				</tr>
				
				<tr>
					<td>password:</td>
					<td>
						<input	type="password" 
								name="password"
								value="${memberRegisterVO.password }"/>
						<form:errors path="password"></form:errors>
					</td>
				</tr>
				
				<tr>
					<td>confirmPassword:</td>
					<td>
						<input	type="password"
								name="confirmPassword"
								value="${memberRegisterVO.confirmPassword }"/>
						<form:errors path="confirmPassword"></form:errors>
					</td>
				</tr>
			</table>
			<input type="submit" value="전송!"/>
		</form:form>
</body>
</html>