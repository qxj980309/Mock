package com.example.mock.po.vo;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(description = "公共报文枚举类VO")
public class CommonMessageVO {
    private Long id; //主键

    private String name; //公共报文名称
}
