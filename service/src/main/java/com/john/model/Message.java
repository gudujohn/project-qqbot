package com.john.model;

import com.john.model.constant.StatusEnum;
import com.john.model.constant.TypeEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.enhance.mybatis.annotation.ModelMapping;
import org.enhance.mybatis.vo.Model;

import java.util.Date;

/**
 * com.john.model-Message
 * 消息记录同时兼任消息队列作用
 *
 * @classname: Message
 * @description: 消息记录同时兼任消息队列作用
 * @author: JiangGengchao
 * @date: 2020-09-01
 **/
@Getter
@Setter
@ToString
@ModelMapping(tableName = "T_MESSAGE")
public class Message extends Model {

    private static final long serialVersionUID = -7445601227501334746L;

    private int version;
    private TypeEnum type;
    private String destination;
    private String message;
    private StatusEnum status;
    private Date createDate;
    private Date finishDate;
}
