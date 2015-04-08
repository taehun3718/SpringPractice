package com.ktds.christof_kim.board.web;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.christof_kim.intercept.LoginInterceptor;

@Controller
public class DownloadController 
				implements ApplicationContextAware{
	private WebApplicationContext context;	//요거 자체가 MVC 구현체
	private static Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
	
	@RequestMapping("/download/{fileField}")
	public ModelAndView download(@PathVariable("fileField") String file
								, HttpServletResponse response) throws IOException {
		File downloadFile = getFile(file);
		
		logger.info("다운로드!");
		if(downloadFile==null) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);//굉장히 많이 본 404에러
			return null;
		}
		
		logger.info("다운로드!{0}", downloadFile.getAbsoluteFile());
		
		return new ModelAndView("downloadView"
								, "downloadFile"
								, downloadFile);	//뷰도 결국엔 컨트롤러
	}
	
	private File getFile(String fileField) {
		if(fileField.equals("1")) {	//db한테 원래 줘야 되는데 db연동 없이 하드코딩하게 간다.
			return new File("d:\\testRollingFile.log");
		}
		return null;
	}
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.context = (WebApplicationContext) applicationContext;
	}

}
