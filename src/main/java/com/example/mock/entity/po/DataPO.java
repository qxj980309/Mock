package com.example.mock.entity.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@ApiModel(description = "访问数据统计表实体类")
@TableName(value = "td_data_statistic", autoResultMap = true)
public class DataPO {
    private Long id; //主键
    private Long projectId; // 项目编号
    private String sendSysCode; // 请求方系统号
    private String accSysCode; // 接收方系统号
    private String name; // 接口名称
    private String txCode; // 接口编号
    @ApiModelProperty(value = "yyyy-MM-dd")
    private LocalDate date; // 日期
    private Integer count; //访问次数

    @TableField(exist = false)
    private String monthDate;
}
