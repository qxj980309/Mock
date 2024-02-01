package com.example.mock.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Getter
@Setter
@ApiModel(description = "期望实体类")
public class ExpectationPO implements Serializable {

    @ApiModelProperty(value = "发送方系统号")
    @NotBlank(message = "参数位置不能为空")
    private String location;
    @ApiModelProperty(value = "接收放系统号")
    @NotBlank(message = "参数名不能为空")
    private String key;
    @ApiModelProperty(value = "接口url")
    @NotBlank(message = "条件不能为空")
    private String condition;
    @ApiModelProperty(value = "参数值")
    private String value;
}
