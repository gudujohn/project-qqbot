package com.john.util;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component("springBeanUtils")
public class SpringBeanUtils implements ApplicationContextAware {

	private static ApplicationContext applicationContext = null;

	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		log.info(this.getClass().getName() + ".setApplicationContext(), applicationContext = " + applicationContext);
		if (SpringBeanUtils.applicationContext == null) {
			SpringBeanUtils.applicationContext = applicationContext;
		}
	}

	public static boolean containsBean(String name) {
		return getApplicationContext().containsBean(name);
	}

	public static Object getBean(String name) {
		return getApplicationContext().getBean(name);
	}

	public static <T> T getBean(Class<T> clazz) {
		return getApplicationContext().getBean(clazz);
	}

	public static <T> T getBean(String name, Class<T> clazz) {
		return getApplicationContext().getBean(name, clazz);
	}

	@EventListener
	private void onContextClosed(ContextClosedEvent e) {
		applicationContext = null;
	}

}
