package com.example.mock.handler;

import com.alibaba.fastjson.TypeReference;
import com.example.mock.po.ExcelPO;

public class ExcelTypePOHandler extends ListTypeHandler<ExcelPO> {
    @Override
    protected TypeReference<ExcelPO> getTypeReference() {
        return new TypeReference<ExcelPO>(){

        };
    }
}
