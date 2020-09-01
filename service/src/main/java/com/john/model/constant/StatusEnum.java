package com.john.model.constant;

import org.enhance.common.enums.OptionedEnum;
import org.enhance.common.util.EnumUtil;

public enum StatusEnum implements OptionedEnum {

	//1 未发送；2 发送中；3 发送成功；4 发送失败
	NOT_SEND((short) 1, "未发送"),

	SENDING((short) 2, "发送中"),

	SEND_SUCCESS((short) 3, "发送成功"),

	SEND_FAIL((short) 4, "发送失败");

	private short value;
	private String text;

	StatusEnum(short value, String text) {
		this.value = value;
		this.text = text;
	}

	public static StatusEnum get(short value) {
		return EnumUtil.getByValue(StatusEnum.class, value);
	}

	public static StatusEnum get(String text) {
		return EnumUtil.getByText(StatusEnum.class, text);
	}

	@Override
	public short getValue() {
		return value;
	}

	@Override
	public String getName() {
		return name();
	}

	@Override
	public String getText() {
		return text;
	}
}