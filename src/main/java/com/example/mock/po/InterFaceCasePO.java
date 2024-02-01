package com.example.mock.po;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import java.util.List;

@Getter
@Setter
@ApiModel(description = "接口案例实体类")
@TableName
public class InterFaceCasePO extends CommonPO{

    @ApiModelProperty(value = "期望")
//    @TableField(value = "expectation", typeHandler = ExpectListTypeHandler.class)
    @Valid
    private List<ExpectationPO> expectationPOList;


}
