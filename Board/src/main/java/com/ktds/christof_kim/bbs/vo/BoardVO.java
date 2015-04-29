package com.ktds.christof_kim.bbs.vo;

import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;


public class BoardVO {

	private int id;
	private String subject;
	private String content;
	
	private String originalFileOne;
	private String originalFileTwo;

	private String UUIDFileOne;
	private String UUIDFileTwo;
	
	private MultipartFile fileOne;	
	private MultipartFile fileTwo;	
	
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
	public MultipartFile getFileOne() {
		return fileOne;
	}
	public void setFileOne(MultipartFile fileOne) {
		this.originalFileOne = fileOne.getOriginalFilename();
		this.UUIDFileOne = UUID.randomUUID().toString();
		this.fileOne = fileOne;
	}
	public MultipartFile getFileTwo() {
		return fileTwo;
	}
	public void setFileTwo(MultipartFile fileTwo) {
		this.originalFileTwo = fileTwo.getOriginalFilename();
		this.UUIDFileTwo = UUID.randomUUID().toString();
		
		this.fileTwo = fileTwo;
	}
	public String getOriginalFileOne() {
		return originalFileOne;
	}
	public void setOriginalFileOne(String originalFileOne) {
		this.originalFileOne = originalFileOne;
	}
	public String getOriginalFileTwo() {
		return originalFileTwo;
	}
	public void setOriginalFileTwo(String originalFileTwo) {
		this.originalFileTwo = originalFileTwo;
	}
	public String getUUIDFileOne() {
		return UUIDFileOne;
	}
	public void setUUIDFileOne(String uUIDFileOne) {
		UUIDFileOne = uUIDFileOne;
	}
	public String getUUIDFileTwo() {
		return UUIDFileTwo;
	}
	public void setUUIDFileTwo(String uUIDFileTwo) {
		UUIDFileTwo = uUIDFileTwo;
	}
}
