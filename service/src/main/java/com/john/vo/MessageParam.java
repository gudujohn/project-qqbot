package com.john.vo;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@ApiModel(value = "MessageParam", description = "消息请求参数")
public class MessageParam implements Serializable {

	private static final long serialVersionUID = 2740825423152633591L;

	@ApiModelProperty(value = "发送消息对象", allowEmptyValue = false, example = "john")
	private String destination;
	@ApiModelProperty(value = "消息", allowEmptyValue = false, example = "Test Message")
	private String message;
}
