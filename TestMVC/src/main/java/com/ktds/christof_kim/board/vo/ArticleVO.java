package com.ktds.christof_kim.board.vo;

import org.hibernate.validator.constraints.NotEmpty;

public class ArticleVO {

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
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
	
}
