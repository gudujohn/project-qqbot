package com.john.service.manage;

import com.john.model.Message;
import com.john.model.constant.StatusEnum;

/**
 * com.john.service-IMessageManageService
 * 消息发送服务接口
 *
 * @classname: IMessageManageService
 * @description: 消息发送服务
 * @author: JiangGengchao
 * @date: 2020-08-31
 **/
public interface IMessageManageService {
    Message saveMessage(String destination, String message);
    void sendMessage(Message message);
    void sendMessage(String destination, String msg);
    void updateMessage(Message message, StatusEnum status);
}
