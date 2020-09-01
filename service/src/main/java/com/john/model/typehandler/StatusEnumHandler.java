package com.john.model.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.john.model.constant.StatusEnum;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;

/* 转化后的数据类型 */
@MappedTypes(value = StatusEnum.class)
public class StatusEnumHandler extends BaseTypeHandler<StatusEnum> {

	@Override
	public void setNonNullParameter(PreparedStatement preparedStatement, int i, StatusEnum statusEnum, JdbcType jdbcType) throws SQLException {
		preparedStatement.setShort(i, statusEnum.getValue());
	}

	@Override
	public StatusEnum getNullableResult(ResultSet resultSet, String s) throws SQLException {
		short value = resultSet.getShort(s);
		return StatusEnum.get(value);
	}

	@Override
	public StatusEnum getNullableResult(ResultSet resultSet, int i) throws SQLException {
		short value = resultSet.getShort(i);
		return StatusEnum.get(value);
	}

	@Override
	public StatusEnum getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
		short value = callableStatement.getShort(i);
		return StatusEnum.get(value);
	}
}