package com.ktds.christof_kim.board.vo;

import org.hibernate.validator.constraints.NotEmpty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;;

public class ArticleVO {

	private static Logger logger = LoggerFactory.getLogger(ArticleVO.class);
	private int id;
	@NotEmpty(message="제목을 입력하세요")
	private String subject;
	@NotEmpty(message="내용을 입력하세요")
	private String content;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		logger.info("subject:{} 가져옴", subject);
		this.subject = subject;
	}
	public String getContent() {
		
		return content;
	}
	public void setContent(String content) {
		logger.info("content:{} 가져옴", content);
		this.content = content;
	}
	
	
	
}
