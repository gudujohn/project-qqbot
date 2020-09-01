package com.john.service.dao;

import com.john.model.Message;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.enhance.mybatis.support.ModelMapper;
import org.enhance.mybatis.support.SqlProvider;
import org.enhance.mybatis.vo.Model;

public interface MessageAccessService extends ModelMapper<Message> {
    @InsertProvider(type = SqlProvider.class, method = "create")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    int add(Message message);
}