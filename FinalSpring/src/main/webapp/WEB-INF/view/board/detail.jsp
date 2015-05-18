<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib 	prefix="c"
			uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<body>

	<table border="1">
		<tr>
			<th>Subject</th>
			<td>
				<c:out value="${articleVO.subject }" />
			</td>
		</tr>
		<tr>
			<th>Author</th>
			<td>
				<c:out value="${articleVO.userName }" />
				(<c:out value="${articleVO.emailId }" />)
			</td>
		</tr>
		<tr>
			<th>Hit</th>
			<td>
				<c:out value="${articleVO.hit }" />
			</td>
		</tr>
		<tr>
			<th>Created Date</th>
			<td>
				<c:out value="${articleVO.createdDate }" />
			</td>
		</tr>
		<tr>
			<th>Latest Modified Date</th>
			<td>
				<c:out value="${articleVO.modifiedDate }" />
			</td>
		</tr>
		<tr>
			<th>Secret</th>
			<td>
				<c:out value="${articleVO.isSecret }" />
			</td>
		</tr>
		<tr>
			<th>Content</th>
			<td>
				${articleVO.content }
			</td>
		</tr>
	</table>
	<a href="<c:url value="/board/modify/${articleVO.articleId }"/>">수정</a> | <a href="<c:url value="/board/delete/${articleVO.articleId }"/>">삭제</a>


</body>
</html>