<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	번호 : <c:out value="${article.id }"/> <br/>
	제목 : <c:out value="${article.subject }"/> <br/>
	내용 : ${article.content }<br/>

<a href ="<c:url value="/list"/>">목록</a>
<a href ="<c:url value="/write"/>">쓰기</a>
<a href ="<c:url value="/doDelete?id=${article.id }"/>">삭제</a>
</body>
</html>