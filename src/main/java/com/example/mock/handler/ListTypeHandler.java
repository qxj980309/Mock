package com.example.mock.handler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.example.mock.po.IsRelatedPO;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.type.*;
import org.postgresql.util.PGobject;

import javax.annotation.Resource;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@MappedTypes({List.class})
public abstract class ListTypeHandler<T> extends BaseTypeHandler<T> {

    private static final PGobject jsonObject = new PGobject();

    @Resource
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, T o, JdbcType jdbcType) throws SQLException {
        if (null != preparedStatement){
            jsonObject.setType("json");
            jsonObject.setValue(JSON.toJSONString(o));
            preparedStatement.setObject(i,jsonObject);
        }
    }

    @Resource
    public T getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return null;
    }

    @Resource
    public T getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return null;
    }

    @Resource
    public T getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return null;
    }

    private T toObject(String content){
        if (!StringUtils.isNotBlank(content)){
            return null;
        }
        return JSON.parseObject(content,getTypeReference());
    }

    protected abstract TypeReference<T> getTypeReference();
}
