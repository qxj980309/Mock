package com.example.mock.entity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Api(tags = "url实体类")
@AllArgsConstructor
@NoArgsConstructor
public class UrlEntity {
    @ApiModelProperty(value = "发送方系统号")
    private String sendSysCode;
    @ApiModelProperty(value = "接收放系统号")
    private String receiveSysCode;
    @ApiModelProperty(value = "接口url")
    private String url;
}
