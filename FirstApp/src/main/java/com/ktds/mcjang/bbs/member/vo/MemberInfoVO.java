package com.ktds.mcjang.bbs.member.vo;

import org.hibernate.validator.constraints.NotEmpty;

public class MemberInfoVO {

	@NotEmpty(message="ID를 입력하세요.")
	private String usrId;
	@NotEmpty(message="Email ID를 입력하세요.")
	private String emailId;
	@NotEmpty(message="Email Host를 입력하세요.")
	private String emailHost;
	@NotEmpty(message="Password를 입력하세요.")
	private String usrPwd;
	@NotEmpty(message="Password를 입력하세요.")
	private String usrPwd2;
	@NotEmpty(message="Nick Name을 입력하세요.")
	private String usrNickName;
	@NotEmpty(message="공개여부를 선택하세요.")
	private String showMyInfo;
	private String usrGrd;
	private String usrSndGrd;
	
	private int grdPnt; 
	private String rgstDT;
	private String lstDT;
	private String blockYN;
	
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
	public void setUsrNickName(String usrNickName) {
		this.usrNickName = usrNickName;
	}
	public String getShowMyInfo() {
		return showMyInfo;
	}
	public void setShowMyInfo(String showMyInfo) {
		this.showMyInfo = showMyInfo;
	}
	public String getEmailHost() {
		return emailHost;
	}
	public void setEmailHost(String emailHost) {
		this.emailHost = emailHost;
	}
	public String getUsrGrd() {
		return usrGrd;
	}
	public void setUsrGrd(String usrGrd) {
		this.usrGrd = usrGrd;
	}
	public int getGrdPnt() {
		return grdPnt;
	}
	public void setGrdPnt(int grdPnt) {
		this.grdPnt = grdPnt;
	}
	public String getRgstDT() {
		return rgstDT;
	}
	public void setRgstDT(String rgstDT) {
		this.rgstDT = rgstDT;
	}
	public String getUsrSndGrd() {
		return usrSndGrd;
	}
	public void setUsrSndGrd(String usrSndGrd) {
		this.usrSndGrd = usrSndGrd;
	}
	public String getLstDT() {
		return lstDT;
	}
	public void setLstDT(String lstDT) {
		this.lstDT = lstDT;
	}
	public String getBlockYN() {
		return blockYN;
	}
	public void setBlockYN(String blockYN) {
		this.blockYN = blockYN;
	}
}
