package com.example.mock.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@ApiModel(description = "excel实体类")
public class ExcelPO {
    //表头
    private Map<String,String> header;
    //数据
    private List<Map<String,String>> bodyList;
}
