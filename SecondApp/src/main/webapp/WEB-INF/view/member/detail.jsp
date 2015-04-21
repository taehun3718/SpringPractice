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

</script>
</head>
<body>
	
	<table>
	<tr>
		<th>ID</th>
		<td><c:out value="${member.usrNickName }" /></td>
	</tr>
	<tr>
		<th>닉네임</th>
		<td><c:out value="${member.usrNickName }" /></td>
	</tr>
	<tr>
		<th>등급</th>
		<td><c:out value="${member.userGrade }" /></td>
	</tr>
	<tr>
		<th>가입일자</th>
		<td><c:out value="${member.registDate }" /></td>
	</tr>
	<tr>
		<th>이메일</th>
		<td><c:out value="${member.emailId }" /></td>
	</tr>	
	<tr>
		<th>포인트</th>
		<td><c:out value="${member.usrPoint }" /></td>
	</tr>
	<tr>	
		<th>정보공개 여부</th>
		<td><c:out value="${member.showMyInfo }" /></td>
	</tr>
	</table>
	
</body>
</html>