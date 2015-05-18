package com.ktds.mcjang.bbs.board.vo;

import org.hibernate.validator.constraints.NotEmpty;

public class BoardVO {

	private String boardId;
	@NotEmpty
	private String boardName;
	
	private String boardCreatedDate;
	private String boardModifiedDate;

	@NotEmpty
	private String boardGrade;
	
	private String boardSecondGrade;
	
	@NotEmpty
	private String boardCode;
	
	public String getBoardId() {
		return boardId;
	}
	public void setBoardId(String boardId) {
		this.boardId = boardId;
	}
	public String getBoardName() {
		return boardName;
	}
	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}
	public String getBoardCreatedDate() {
		return boardCreatedDate;
	}
	public void setBoardCreatedDate(String boardCreatedDate) {
		this.boardCreatedDate = boardCreatedDate;
	}
	public String getBoardModifiedDate() {
		return boardModifiedDate;
	}
	public void setBoardModifiedDate(String boardModifiedDate) {
		this.boardModifiedDate = boardModifiedDate;
	}
	public String getBoardGrade() {
		return boardGrade;
	}
	public void setBoardGrade(String boardGrade) {
		this.boardGrade = boardGrade;
	}
	public String getBoardSecondGrade() {
		return boardSecondGrade == null ? "" : this.boardSecondGrade;
	}
	public void setBoardSecondGrade(String boardSecondGrade) {
		this.boardSecondGrade = boardSecondGrade;
	}
	public String getBoardCode() {
		return boardCode;
	}
	public void setBoardCode(String boardCode) {
		this.boardCode = boardCode;
	}
	
}
