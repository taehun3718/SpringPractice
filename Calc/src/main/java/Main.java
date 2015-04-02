import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.ktds.hifive.calc.service.CalcService;

public class Main {

	public static void main(String[] args){
		
		String configLocation = "classpath:spring/applicationContext.xml";
		AbstractApplicationContext ctx 
					= new GenericXmlApplicationContext(configLocation);
		
		CalcService calcService = ctx.getBean("calcService", CalcService.class);
		
		int result = calcService.calc(20,20);
		System.out.println(result);
		
		ctx.close();
	}
}
