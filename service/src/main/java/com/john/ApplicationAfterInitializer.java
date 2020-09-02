package com.john;

import com.john.service.manage.IMessageManageService;
import com.john.util.SpringBeanUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ApplicationAfterInitializer implements ApplicationRunner {

    @Autowired
    private IMessageManageService messageManageService;
    @Value("${message.admin:john}")
    private String adminUserName;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("http://127.0.0.1:{}/swagger-ui.html", System.getProperty("server.port"));
        messageManageService.sendMessage(adminUserName, "消息服务启动成功");
    }
}