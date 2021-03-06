package com.john.controller;

import com.alibaba.ttl.threadpool.TtlExecutors;
import com.john.model.Message;
import com.john.model.constant.StatusEnum;
import com.john.service.manage.IMessageManageService;
import com.john.vo.MessageParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.enhance.web.util.RestResultUtil;
import org.enhance.web.vo.RestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * com.john.controller-MessageController
 * 消息Controller
 *
 * @classname: MessageController
 * @description: 消息Controller
 * @author: JiangGengchao
 * @date: 2020-08-31
 **/
@Slf4j
@Api("消息Controller")
@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private IMessageManageService messageManageService;

    @ApiOperation("接收消息后调用au3发送qq消息")
    @ApiParam(name="消息参数",value="消息",required=true)
    @PostMapping("/receiveMessage")
    public RestResult receiveMessage(@RequestBody MessageParam param) {
        Message message = messageManageService.saveMessage(param.getDestination(), param.getMessage());

        messageManageService.sendMessage(message);

        return RestResultUtil.success();
    }

}
