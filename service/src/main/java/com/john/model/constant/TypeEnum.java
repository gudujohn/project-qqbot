package com.john.model.constant;

import org.enhance.common.enums.OptionedEnum;
import org.enhance.common.util.EnumUtil;

public enum TypeEnum implements OptionedEnum {

	MSG_QQ((short) 1, "qq消息"),

	MSG_SMS((short) 2, "短信");

	private short value;
	private String text;

	TypeEnum(short value, String text) {
		this.value = value;
		this.text = text;
	}

	public static TypeEnum get(short value) {
		return EnumUtil.getByValue(TypeEnum.class, value);
	}

	public static TypeEnum get(String text) {
		return EnumUtil.getByText(TypeEnum.class, text);
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