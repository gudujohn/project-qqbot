package com.john;

import com.john.service.manage.IMessageManageService;
import com.john.util.SpringBeanUtils;
import org.enhance.web.util.SettingsLoadUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * QQMessageSenderApplication
 *
 * @author JiangGengchao
 * @date 2020年08月31日
 */
@Slf4j
@EnableAsync
@MapperScan("com.john.**.dao")
@SpringBootApplication(scanBasePackages = "com.john")
public class QQMessageSenderApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication application = new SpringApplication(QQMessageSenderApplication.class);
		application.addInitializers(SettingsLoadUtil::loadSettings);
		application.run(args);
	}

}
