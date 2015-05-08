package com.ktds.christof_kim.chat;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
	private List<WebSocketSession> sessionList = new ArrayList<WebSocketSession>();
	/** 클라이언트 연결 이후에 실행되는 메소드 */
	@Override
	public void afterConnectionEstablished(WebSocketSession session)
			throws Exception {
		sessionList.add(session);
	}
	/** 클라이언트가 웹소켓서버로 메세지를 전송했을 때 실행되는 메소드 */
	@Override
	protected void handleTextMessage(WebSocketSession session,
			TextMessage message) throws Exception {
		//연결되어 있는 모든 클라이언트들에게 메세지를 전송한다.
		for(WebSocketSession sess : sessionList) {
			sess.sendMessage(new TextMessage(message.getPayload()));
		}
	}
	/** 클라이언트가 연결을 끊었을 때 실행되는 메소드*/
	@Override
	public void afterConnectionClosed(WebSocketSession session,
			CloseStatus status) throws Exception {
		sessionList.remove(session);
	}
}
