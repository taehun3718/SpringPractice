package com.ktds.christof.bbs.vo;

import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

public class ArticleVO {
	private String id;
	private String subject;
	private String content;
	private String uploadFileOne;
	private String uploadFileTwo;
	private String uploadFileUUIDOne;
	private String uploadFileUUIDTwo;
	
	private MultipartFile fileOne;	
	private MultipartFile fileTwo;	

	public ArticleVO() {
		fileOne = null;
		fileTwo = null;
		
		uploadFileOne = "n/a";
		uploadFileTwo = "n/a";
		uploadFileUUIDOne = "n/a";
		uploadFileUUIDTwo = "n/a";
	}

	public MultipartFile getFileOne() {
		return fileOne;
	}

	public void setFileOne(MultipartFile fileOne) {
		this.fileOne = fileOne;
		this.uploadFileOne = fileOne.getOriginalFilename();
		this.uploadFileUUIDOne = UUID.randomUUID().toString();
	}
	
	public MultipartFile getFileTwo() {
		return fileTwo;
	}
	
	public void setFileTwo(MultipartFile fileTwo) {
		this.fileTwo = fileTwo;
		this.uploadFileTwo = fileTwo.getOriginalFilename();
		this.uploadFileUUIDTwo = UUID.randomUUID().toString();
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
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
	public String getUploadFileOne() {
		return uploadFileOne;
	}
	public void setUploadFileOne(String uploadFileOne) {
		this.uploadFileOne = uploadFileOne;
	}
	public String getUploadFileTwo() {
		return uploadFileTwo;
	}
	public void setUploadFileTwo(String uploadFileTwo) {
		this.uploadFileTwo = uploadFileTwo;
	}
	public String getUploadFileUUIDOne() {
		return uploadFileUUIDOne;
	}
	public void setUploadFileUUIDOne(String uploadFileUUIDOne) {
		this.uploadFileUUIDOne = uploadFileUUIDOne;
	}
	public String getUploadFileUUIDTwo() {
		return uploadFileUUIDTwo;
	}
	public void setUploadFileUUIDTwo(String uploadFileUUIDTwo) {
		this.uploadFileUUIDTwo = uploadFileUUIDTwo;
	}
}
