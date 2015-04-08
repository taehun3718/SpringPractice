package com.ktds.christof_kim.web.mvc.vo;

import java.util.List;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class MemberRegisterRequestVO {

	
	private boolean isCheck;
	
	private List<String >names;
	
	@Email(message="Email을 올바르게 입력하세요!")
	private String email;
	@NotEmpty(message="이름을 입력하세요!")
	private String name;
	
	private String password;
	private String confirmPassword;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	public boolean isCheck() {
		return isCheck;
	}
	public void setIsCheck(boolean isCheck) {
		this.isCheck = isCheck;
	}
	public List<String> getNames() {
		return names;
	}
	public void setNames(List<String> names) {
		this.names = names;
	}


}
