package com.john;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * QQMessageSenderServletInitializer
 *
 * @author JiangGengchao
 * @date 2020年08月31日
 */
public class QQMessageSenderServletInitializer extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(QQMessageSenderApplication.class);
	}
}