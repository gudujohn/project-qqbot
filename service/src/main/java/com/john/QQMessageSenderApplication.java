package com.john;

import org.enhance.web.util.SettingsLoadUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

/**
 * QQMessageSenderApplication
 *
 * @author JiangGengchao
 * @date 2020年08月31日
 */
@Slf4j
@MapperScan("com.john.**.dao")
@SpringBootApplication(scanBasePackages = "com.john")
public class QQMessageSenderApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication application = new SpringApplication(QQMessageSenderApplication.class);
		application.addInitializers(SettingsLoadUtil::loadSettings);
		application.run(args);
		log.info("http://127.0.0.1:{}/swagger-ui.html", System.getProperty("server.port"));
	}

}
