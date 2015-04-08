package com.ktds.christof_kim.board.vo;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

public class UploadVO {

	@NotEmpty(message="파라미터를 입력하세요!")
	private String name;
	
	@NotNull(message="파일을 선택하세요!")
	private MultipartFile file;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}
	
}
