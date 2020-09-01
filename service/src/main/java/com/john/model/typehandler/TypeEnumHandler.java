package com.john.model.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.john.model.constant.TypeEnum;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;

import com.john.model.constant.StatusEnum;

/* 转化后的数据类型 */
@MappedTypes(value = TypeEnum.class)
public class TypeEnumHandler extends BaseTypeHandler<TypeEnum> {

	@Override
	public void setNonNullParameter(PreparedStatement preparedStatement, int i, TypeEnum typeEnum, JdbcType jdbcType) throws SQLException {
		preparedStatement.setShort(i, typeEnum.getValue());
	}

	@Override
	public TypeEnum getNullableResult(ResultSet resultSet, String s) throws SQLException {
		short value = resultSet.getShort(s);
		return TypeEnum.get(value);
	}

	@Override
	public TypeEnum getNullableResult(ResultSet resultSet, int i) throws SQLException {
		short value = resultSet.getShort(i);
		return TypeEnum.get(value);
	}

	@Override
	public TypeEnum getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
		short value = callableStatement.getShort(i);
		return TypeEnum.get(value);
	}
}