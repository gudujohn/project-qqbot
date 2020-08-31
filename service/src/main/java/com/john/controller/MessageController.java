package com.john.controller;

import com.john.service.IMessageSenderService;
import com.john.vo.MessageParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.enhance.web.util.RestResultUtil;
import org.enhance.web.vo.RestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

/**
 * com.john.controller-MessageController
 * 消息Controller
 *
 * @classname: MessageController
 * @description: 消息Controller
 * @author: JiangGengchao
 * @date: 2020-08-31
 **/
@Api("消息Controller")
@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private IMessageSenderService messageSenderService;

    @ApiOperation("接收消息后调用au3发送qq消息")
    @ApiParam(name="消息参数",value="消息",required=true)
    @PostMapping("/receiveMessage")
    public RestResult receiveMessage(@RequestBody MessageParam param) {
        boolean result = messageSenderService.send(param.getDestination(), param.getMessage());
        if(result) {
            return RestResultUtil.success();
        } else {
            return RestResultUtil.failure("消息发送失败");
        }
    }
}
