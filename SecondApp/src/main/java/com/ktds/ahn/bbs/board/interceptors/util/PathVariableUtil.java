package com.ktds.ahn.bbs.board.interceptors.util;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerMapping;

public class PathVariableUtil {

	
	private static Logger logger= LoggerFactory.getLogger(PathVariableUtil.class);
	private static String value="";
	
	
	
	public static String getFullURI(HttpServletRequest request) {
		String requestURI = request.getRequestURI();
		/*
		 * PathVariable Data를 가져온다.
		 */
		Map<String, Object> pathVariables = 
				(Map<String, Object>)request.getAttribute(
						HandlerMapping
						.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		
		if(pathVariables != null) {
			Set<String> keySet = pathVariables.keySet();
			Iterator<String> keys = pathVariables.keySet().iterator();
			
			String key = "";
			String value = "";
			
			while(keys.hasNext()) {
				key = keys.next();
				value = pathVariables.get(key).toString();
				
				PathVariableUtil.value = value;
				
				requestURI = requestURI.replaceAll( "/" + value, "/{" + key + "}");
				
				logger.info("PathKey:{}", key);
				logger.info("PathValue:{}", value);
				
			}
		
		}
		
		return requestURI;
	}
	
	
	
}
