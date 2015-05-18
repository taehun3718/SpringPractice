package com.ktds.mcjang.bbs.board.vo;

import org.springframework.web.multipart.MultipartFile;

public class ArticleVO {
	
	private int	index;
	private String subject;
	private String content;
	private String memberId;
	private MultipartFile uploadFile;
	private String realFileName;
	private String randomFileName;
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
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
	public MultipartFile getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}
	public String getRealFileName() {
		return realFileName;
	}
	public void setRealFileName(String realFileName) {
		this.realFileName = realFileName;
	}
	public String getRandomFileName() {
		return randomFileName;
	}
	public void setRandomFileName(String randomFileName) {
		this.randomFileName = randomFileName;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	
}
