package edu.kh.project.common.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AfterAspect {

	private Logger logger = LoggerFactory.getLogger(AfterAspect.class);
	
	@Order(3)
	@After("CommonPointcut.serviceImplPointcut()")
	public void afterLog() {
		logger.info("---------------------------------------------------------------\n\n");
	}
	
	
	
	
	
	
	
}
