package com.ktds.christof.commons;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

public class FileManager {
	
	private MultipartFile fileOne;
	private MultipartFile fileTwo;
	private String dir;
	
	/**
	 * 파일 전송을 위한 파일 관리자
	 */
	public FileManager(MultipartFile fileOne
					, MultipartFile fileTwo
					, String dir) {
		this.fileOne = fileOne;
		this.fileTwo = fileTwo;
		this.dir = dir;
		
		makeDirectory(dir);
	}
	
	public void makeDirectory(String dir) {
		File file = new File("D://" + dir);
		
		if(!file.exists()) {
			file.mkdirs();
		}
	}
	/**
	 * 파일 이름은 랜덤으로 저장되기 때문에 원본 이름을 데이터베이스에 저장될 필요성이 있음
	 */
	public void transfer() {
		File uploadfileOne = null;
		File uploadfileTwo = null;
		
		try {
			if(fileOne!=null) {
				uploadfileOne = new File("D://" + dir + "//" + UUID.randomUUID().toString());
				fileOne.transferTo(uploadfileOne);
			}
			if(fileTwo!=null) {
				uploadfileTwo = new File("D://" + dir + "//" + UUID.randomUUID().toString());
				fileTwo.transferTo(uploadfileTwo);
			}
		} 
		catch (IllegalStateException e) {} 
		catch (IOException e) {}
	}
}
