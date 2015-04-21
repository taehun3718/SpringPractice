package com.ktds.ahn.bbs.member.vo;

import org.hibernate.validator.constraints.NotEmpty;

public class MemberInfoVO {
	
	@NotEmpty(message="ID를 입력하세요.")
	private String usrId;
	@NotEmpty(message="EmailID를 입력하세요.")
	private String emailId;
	@NotEmpty(message="EmailHost를 입력하세요.")
	private String emailHost;
	@NotEmpty(message="Password를 입력하세요.")
	private String usrPwd;
	@NotEmpty(message="Password를 입력하세요.")
	private String usrPwd2;
	@NotEmpty(message="NickName을 입력하세요.")
	private String usrNickName;
	@NotEmpty(message="공개 여부를 선택하세요.")
	private String showMyInfo;
	
	private String userSecondGrade;
	
	public String getUserSecondGrade() {
		return userSecondGrade;
	}
	public void setUserSecondGrade(String userSecondGrade) {
		this.userSecondGrade = userSecondGrade;
	}
	private int usrPoint;
	
	public int getUsrPoint() {
		return usrPoint;
	}
	public void setUsrPoint(int usrPoint) {
		this.usrPoint = usrPoint;
	}
	private String userGrade;
	private String registDate;
	
	public String getUserGrade() {
		return userGrade;
	}
	public void setUserGrade(String userGrade) {
		this.userGrade = userGrade;
	}
	public String getregistDate() {
		return registDate;
	}
	public void setregistDate(String joinDate) {
		this.registDate = joinDate;
	}
	
	public String getUsrId() {
		return usrId;
	}
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getEmailHost() {
		return emailHost;
	}
	public void setEmailHost(String emialHost) {
		this.emailHost = emialHost;
	}
	public String getUsrPwd() {
		return usrPwd;
	}
	public void setUsrPwd(String usrPwd) {
		this.usrPwd = usrPwd;
	}
	public String getUsrPwd2() {
		return usrPwd2;
	}
	public void setUsrPwd2(String usrPwd2) {
		this.usrPwd2 = usrPwd2;
	}
	public String getUsrNickName() {
		return usrNickName;
	}
	public void setUsrNickName(String nickName) {
		this.usrNickName = nickName;
	}
	public String getShowMyInfo() {
		return showMyInfo;
	}
	public void setShowMyInfo(String showMyInfo) {
		this.showMyInfo = showMyInfo;
	}
}
