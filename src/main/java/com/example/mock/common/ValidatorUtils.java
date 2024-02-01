package com.example.mock.common;

import com.example.mock.po.CommonMessagePo;
import com.example.mock.po.ExcelPO;
import com.example.mock.po.InterFacePO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class ValidatorUtils {
    private final static Logger log = LoggerFactory.getLogger(ValidatorUtils.class);

    public static final Pattern PATTERN = Pattern.compile("D\\((d+),\\s*(\\d+)\\)");

    public static String checkParam(Map<String,Object> bodyMap, InterFacePO interFacePO, CommonMessagePo commonMessagePo){
        ExcelPO requestBody = interFacePO.getRequestBody();
        StringBuilder errMsg = new StringBuilder();
        if (requestBody != null){
            List<Map<String,String>> bodyList = requestBody.getBodyList();
            if (CollectionUtils.isEmpty(bodyList)|| bodyList.size() ==0){
                log.info("没有校验规则");
                return "";
            }
            ExcelPO checkALl =requestBody;

            if(commonMessagePo != null){
                checkALl = MergeCommonMessageUtil.mergeCommon(interFacePO,commonMessagePo);
            }
        }
        return errMsg.toString();
    }
}
