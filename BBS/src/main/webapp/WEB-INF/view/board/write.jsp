<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글쓰기</title>
</head>
<body>
<h1>글쓰기</h1>
	<form	id="writeForm" 
			name="writeForm"
			method="post"
			enctype="multipart/form-data"
			action="<c:url value="/board/doWrite"/>">
		<table>
	
			<tr>
				<td>제목:</td>
				<td><input type="text" name="subject" /></td>
			</tr>
	
			<tr>
				<td>내용:</td>
				<td><textarea name="content" ></textarea></td>
			</tr>
			
			<tr>
				<td>파일1:</td>
				<td>
					<input type="file" name="fileOne" />
				</td>
			</tr>
			
			<tr>
				<td>파일2:</td>
				<td>
					<input type="file" name="fileTwo" />
				</td>
			</tr>
			
		</table>
		<input	type="submit" 
				value="글쓰기">
				
	</form>
</body>
</html>