<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
${helloMessage } <br/>
${byeMessage }
<a href="/TestMVC/test5">전송!</a>
<form method="post" action="/TestMVC/test5">
	<input type="submit" value="전송"/>
</form>


<a href="/TestMVC/test7?id=abc">전송test7!</a>
<form method="post" action="/TestMVC/test7">
	<input type="text" name="id"/>
	<input type="submit" value="전송!"/>
</form>


<a href="/TestMVC/test7?id=abc">전송test9!</a>
<form method="post" action="/TestMVC/test9">

	체크드<input type="checkbox" name="isCheck" value="true"/><br>

	Names:<input type="text" name="names"/><br/>
	Names:<input type="text" name="names"/><br/>
	Names:<input type="text" name="names"/><br/>
	Names:<input type="text" name="names"/><br/>
				

	Email:<input type="text" name="email"/><br/>
	name:<input type="text" name="name"/><br/>
	Password<input type="text" name="password"/><br/>
	
	<input type="submit" value="전송!"/>
</form>

</body>
</html>