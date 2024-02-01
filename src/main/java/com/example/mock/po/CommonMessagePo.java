package com.example.mock.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@TableName(value = "td_common_message",autoResultMap = true)
public class CommonMessagePo {
    private Long id;
    @NotNull(message = "项目不能为空")
    private Long projectId;
    private String name;
    private ExcelPO commonMessage;

}
