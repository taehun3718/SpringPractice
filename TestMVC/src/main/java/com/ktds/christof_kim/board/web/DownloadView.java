package com.ktds.christof_kim.board.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

public class DownloadView extends AbstractView{

	public DownloadView(){
		setContentType("application/download; charset=utf-8");
	}
	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		File file = (File)model.get("downloadFile");
		response.setContentType(getContentType());
		response.setContentLengthLong((int)file.length());
		
		String userAgent = request.getHeader("User-Agent");//?
		boolean internetExplorer = userAgent.indexOf("MSIE") > -1;
		
		String fileName = null;
		
		if(internetExplorer) {
			fileName = URLEncoder.encode(file.getName(), "UTF-8");
			
		}
		else {
			fileName = new String(file.getName().getBytes("UTF-8"), "ISO-8859-1");
		}
		
		response.setHeader("Content-Disposition", "attachment; fileName=\"" + fileName + "\";");
		response.setHeader("Content-Transfer-Encoding", "binary");
		
		//java.io.OutputStream
		OutputStream out = response.getOutputStream();
		//java.io.FileInputStream
		FileInputStream fis = null;
		
		try{
			fis = new FileInputStream(file);
			FileCopyUtils.copy(fis, out);
			out.flush();
		}
		finally {
			if(fis!=null) {
				fis.close();
			}
			if(out!=null) {
				out.close();
			}
		}
	}
}