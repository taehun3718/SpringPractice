package com.ktds.christof_kim.common.util;

import java.io.File;

import org.springframework.web.multipart.MultipartFile;

public class FileManager {
	
	private String directory;
	private File fileOne;
	private File fileTwo;
	
	public FileManager( String dir
					, File fileOne
					, File fileTwo) {

		this.fileOne = fileOne;
		this.fileTwo = fileTwo;
}
	
	public FileManager(File fileOne
					, File fileTwo) {
		
		this.fileOne = fileOne;
		this.fileTwo = fileTwo;
		
		File mkdir = new File("D://uploadFile");
		//if(mkdir.get)
	}
}
