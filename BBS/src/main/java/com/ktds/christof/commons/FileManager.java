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
	 * ���� ������ ���� ���� ������
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
	 * ���� �̸��� �������� ����Ǳ� ������ ���� �̸��� �����ͺ��̽��� ����� �ʿ伺�� ����
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
