package com.example.mock.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
@MapperScan
public interface RelatedApiMapper {
//        extends BaseMapper<RelatedApiPO> {
}
