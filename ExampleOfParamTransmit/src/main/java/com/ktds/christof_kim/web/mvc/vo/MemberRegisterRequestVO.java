package com.ktds.christof_kim.web.mvc.vo;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class MemberRegisterRequestVO {
	
	@Email(message="email을 입력해주세요.")
	private String email;
	
	@NotEmpty(message="이름을 입력해주세요.")
	private String name;
	
	@NotEmpty(message="패스워드를 입력해주세요.")
	private String password;
	
	@NotEmpty(message="패스워드를 입력해주세요.")
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
}
