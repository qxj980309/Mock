package com.example.mock.po.vo;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@ApiModel(description = "接口批量导入二次确认VO")
public class ConfirmVO {
    @NotNull(message = "工程id不能为空")
    private Long projectId;

    @Valid
    @NotNull(message = "选择接口不能为空")
    private List<InterfaceImportVO> list;
}
