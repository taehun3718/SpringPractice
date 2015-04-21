package com.ktds.ahn.bbs.board.vo;

import org.springframework.web.multipart.MultipartFile;

public class ArticleVO {

	private String subject;
	private String content;
	private String memberId;
	private String createdDate;
	private String modifiedDate;
	private String hitCount;
	private String userGrade;
	private String tableId;
	private String realFileName;
	private String randomFileName;
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
	private String deleteFlag;
	private String userSecondGrade;
	private MultipartFile uploadFile;
	
	public MultipartFile getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}
	public String getUserSecondGrade() {
		return userSecondGrade;
	}
	public void setUserSecondGrade(String userSecondGrade) {
		this.userSecondGrade = userSecondGrade;
	}
	public String getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	public String getFileRLName() {
		return realFileName;
	}
	public void setFileRLName(String fileRLName) {
		this.realFileName = fileRLName;
	}
	public String getFileRNDName() {
		return fileRNDName;
	}
	public void setFileRNDName(String fileRNDName) {
		this.fileRNDName = fileRNDName;
	}
	private String fileRNDName;
	
	
	public String getTableId() {
		return tableId;
	}
	public void setTableId(String tableId) {
		this.tableId = tableId;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public String getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public String getHitCount() {
		return hitCount;
	}
	public void setHitCount(String hitCount) {
		this.hitCount = hitCount;
	}
	public String getUserGrade() {
		return userGrade;
	}
	public void setUserGrade(String userGrade) {
		this.userGrade = userGrade;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String userId) {
		this.memberId = userId;
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