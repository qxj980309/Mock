package com.example.mock.po.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@ApiModel(description = "接口批量导入二次确认VO")
public class InterfaceImportVO {
    @NotNull(message = "接口id不能为空")
    private Long id;

    @ApiModelProperty(value ="接口名称")
    private String name;

    @ApiModelProperty(value ="接口编号")
    private String txCode;

    @ApiModelProperty(value ="sheet页名称")
    private String sheetName;

    @ApiModelProperty(value ="状态")
    @NotNull(message = "接口状态不能为空")
    private String status;

    @ApiModelProperty(value ="说明")
    private String msg;

}
