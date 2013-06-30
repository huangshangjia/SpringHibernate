package com.manage.pub.util;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringUtil {
	private static SpringUtil instance;

	private static AbstractApplicationContext appContext;

	public synchronized static SpringUtil getInstance() {
		if (instance == null) {
			instance = new SpringUtil();
		}
		return instance;
	}

	private SpringUtil() {
		String paths[] = { "/spring.xml",};
		this.appContext = new ClassPathXmlApplicationContext(paths);
	}
	
	public Object getBean(String beanId){
		return appContext.getBean(beanId);
	}

}
