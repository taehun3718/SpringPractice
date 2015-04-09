package com.ktds.christof_kim.chat.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ChatController {

	@RequestMapping("/chat")
	public String viewChatPage() {
		return "chat/chat";
	}
}
