package com.john.service.manage.impl;

import com.alibaba.ttl.threadpool.TtlExecutors;
import com.john.controller.MessageController;
import com.john.model.Message;
import com.john.model.constant.StatusEnum;
import com.john.model.constant.TypeEnum;
import com.john.service.dao.MessageAccessService;
import com.john.service.manage.IMessageManageService;
import lombok.extern.slf4j.Slf4j;
import org.enhance.common.util.Assertion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * com.john.service.impl-MessageManageServiceImpl
 * 消息发送服务
 *
 * @classname: MessageManageServiceImpl
 * @description: 消息发送服务
 * @author: JiangGengchao
 * @date: 2020-08-31
 **/
@Slf4j
@Service("messageManageService")
public class MessageManageServiceImpl implements IMessageManageService {

    @Autowired
    private MessageAccessService messageAccessService;

    @Value("${message.command}")
    private String command;

    @Override
    public Message saveMessage(String destination, String message) {
        Message model = new Message();
        model.setDestination(destination);
        model.setMessage(message);
        model.setVersion(1);
        model.setStatus(StatusEnum.NOT_SEND);
        model.setType(TypeEnum.MSG_QQ);
        model.setCreateDate(new Date());
        model.setFinishDate(new Date());

        messageAccessService.add(model);
        return model;
    }

    @Override
    @Async("messageThreadPool")
    public void sendMessage(Message message) {
        String destination = message.getDestination();
        String msg = message.getMessage();

        updateMessage(message, StatusEnum.SENDING);

        boolean result = sendMessageLogic(destination, msg);

        if(result) {
            updateMessage(message, StatusEnum.SEND_SUCCESS);
        } else {
            updateMessage(message, StatusEnum.SEND_FAIL);
        }
    }

    @Override
    @Async("messageThreadPool")
    public void sendMessage(String destination, String msg) {
        sendMessageLogic(destination, msg);
    }

    private boolean sendMessageLogic(String destination, String msg) {
        Assertion.notEmpty(destination, "destination 不能为空");
        Assertion.notEmpty(msg, "msg 不能为空");

        String[] qqs = destination.split(",");

        for(int i = 0; i < qqs.length; ++i) {
            Process process = null;

            try {
                ProcessBuilder pb = new ProcessBuilder(new String[]{this.command, qqs[i], msg});
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

    @Override
    public void updateMessage(Message message, StatusEnum status) {
        message.setVersion(message.getVersion()+1);
        message.setStatus(status);
        message.setFinishDate(new Date());

        messageAccessService.updateSelective(message);
    }
}
