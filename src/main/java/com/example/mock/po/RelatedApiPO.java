package com.example.mock.po;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@Api(tags = "url实体类")
@TableName(value = "td_related_api")
public class RelatedApiPO {
    @ApiModelProperty(value = "发送方系统号")
    private Long id;
    @ApiModelProperty(value = "发送方系统号")
    private Long caseId;
    @ApiModelProperty(value = "发送方系统号")
    @NotNull(message = "不能为空")
    private String key;
    @ApiModelProperty(value = "发送方系统号")
    @NotNull(message = "不能为空")
    private String name;
    @ApiModelProperty(value = "发送方系统号")
    @NotNull(message = "不能为空")
    private String value;
}
