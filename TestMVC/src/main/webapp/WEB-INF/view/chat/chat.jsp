<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>채팅서버</title>
</head>
<script type="text/javascript" 
	src="<c:url value="js/jquery-1.11.2.js"/>"></script>
<script type="text/javascript" 
	src="<c:url value="socket/sockjs-0.3.4.js"/>"></script>
<script type="text/javascript">
	$(document).ready(function() {
		console.log("ready to jQuery");
		$("#sendBtn").click(function() {
			sendMessage();
		});
	});
	
	//WebSocket을 지정한 URL로 연결
	var sock = new SockJS("<c:url value="/echo"/>");
	//WebSocket 서버에서 메세지를 보내면 자동으로 실행된다.
	sock.onmessage = onMessage;
	//WebSocket과 연결을 끊고 싶을 때 실행하는 메소드이다.
	sock.onclose = onClose();
	
	
	function sendMessage() {
		//WebSocket 으로 메세지를 전달한다.
		sock.send($("#message").val());	
	}
	//evt 파라미터는 WebSocket이 보내준 데이터 이다.
	function onMessage(evt) {
		var data = evt.data;
		$("#data").append(data +"<br/>");
	}
	
	function onClose(evt) {
		$("#data").append("연결 끊힘");
	}
	
</script>
<!-- var onMessage = function onMessage(evt) {
		var data = evt.data;
		$("#data").append(data+"<br/>");
} -->
<body>
	<input type="text" id="message"/>
	<input type="button" id="sendBtn" value="전송"/>
	<div id="data"></div>
</body>
</html>