package com.example.mock.po;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(description = "是否关联公共报文实体类")
public class IsRelatedPO {
    private Boolean switchType; //是否关联公共报文
    private Long id; //公共报文id
    private String param; //替换参数
}
