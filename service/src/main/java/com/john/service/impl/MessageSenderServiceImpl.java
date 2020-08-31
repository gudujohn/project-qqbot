package com.john.service.impl;

import com.john.service.IMessageSenderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * com.john.service.impl-MessageSenderServiceImpl
 * 消息发送服务
 *
 * @classname: MessageSenderServiceImpl
 * @description: 消息发送服务
 * @author: JiangGengchao
 * @date: 2020-08-31
 **/
@Slf4j
@Service("messageSenderService")
public class MessageSenderServiceImpl implements IMessageSenderService {

    @Value("${message.command}")
    private String command;

    @Override
    public synchronized boolean send(String destination, String message) {
        String[] qqs = destination.split(",");

        for(int i = 0; i < qqs.length; ++i) {
            Process process = null;

            try {
                ProcessBuilder pb = new ProcessBuilder(new String[]{this.command, qqs[i], message});
                process = pb.start();
                int resultCode = process.waitFor();
                if (resultCode != 0) {
                    return false;
                }
            } catch (Exception e) {
                log.error(e.getMessage(), e);
                return false;
            }
        }

        return true;
    }
}
