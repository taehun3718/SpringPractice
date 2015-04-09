package com.ktds.christof_kim.chat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import ch.qos.logback.classic.Level;

// Echo는 처음에 웹소켓이 처음 나왔을때 공식으로 만들어진 서버가 Echo 서버였음!
// 그때부터 생기는것이 관례적으로 Echo를 적게 됬는데 지금까지 쓰게 됨.....

public class EchoHandler extends TextWebSocketHandler{
	
	//http://www.javacodegeeks.com/2012/04/using-slf4j-with-logback-tutorial.html
	private static Logger logger = LoggerFactory.getLogger(EchoHandler.class);
	/**
	 * 클라이언트 연결 이후에 실행되는 메소드
	 */
	@Override
	public void afterConnectionEstablished(WebSocketSession session)
			throws Exception {
		logger.info("{} 연결됨", session.getId());
	}
	
	/**
	 * 클라이언트가 웹소켓서버로 메세지를 전송했을 때 실행되는 메소드
	 */
	@Override
	protected void handleTextMessage(WebSocketSession session,
			TextMessage message) throws Exception {
		
		logger.info("{}로 부터 {} 받음", session.getId(), message.getPayload());
		logger.info("! : {}로 부터 {} 받음", new String[]{session.getId(), message.getPayload()});
		// 연결되어 있는 모든 클라이언트에게 메세지를 전송한다.
		session.sendMessage(new TextMessage("echo" + message.getPayload()) );
	}
	
	/**
	 * 클라이언트가 연결을 끊었을 때 실행되는 메소드
	 */
	@Override
	public void afterConnectionClosed(WebSocketSession session,
			CloseStatus status) throws Exception {
		logger.info("{} 연결 끊힘.", session.getId());
	}
}
