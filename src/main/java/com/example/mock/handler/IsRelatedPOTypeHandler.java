package com.example.mock.handler;

import com.example.mock.po.IsRelatedPO;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeReference;

import javax.annotation.Resource;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class IsRelatedPOTypeHandler extends ListTypeHandler<IsRelatedPO>{
    @Resource
    private TypeReference<IsRelatedPO> getTypeReference(){
        return new TypeReference<IsRelatedPO>(){
        };
    }

}
