package com.john.service;

/**
 * com.john.service-IMessageSenderService
 * 消息发送服务接口
 *
 * @classname: IMessageSenderService
 * @description: 消息发送服务
 * @author: JiangGengchao
 * @date: 2020-08-31
 **/
public interface IMessageSenderService {
    boolean send(String destination, String message);
}
