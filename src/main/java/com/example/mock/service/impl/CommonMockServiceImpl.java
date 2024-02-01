package com.example.mock.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.mock.common.MsgConstants;
import com.example.mock.common.MockResponse;
import com.example.mock.common.ValidatorUtils;
import com.example.mock.po.*;
import com.example.mock.mapper.RelatedApiMapper;
import com.example.mock.service.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.javassist.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class CommonMockServiceImpl implements CommonMockService {
    private final static Logger log = LoggerFactory.getLogger(CommonMockServiceImpl.class);
//    @Resource
//    private final RelatedApiMapper relatedApiMapper;
    @Resource
    private final RelatedDataService relatedDataService;

    @Resource
    private final InterfaceService interfaceService;

    @Resource
    private final InterfaceCaseService interfaceCaseService;

    @Resource
    private final CommonMessageService commonMessageService;

    private final HttpStatus CONFIG_ERROR = HttpStatus.PRECONDITION_FAILED;


    public CommonMockServiceImpl( RelatedDataService relatedDataService, InterfaceService interfaceService,
                                 InterfaceCaseService interfaceCaseService, CommonMessageService commonMessageService) {
        this.relatedDataService = relatedDataService;
        this.interfaceService = interfaceService;
        this.interfaceCaseService = interfaceCaseService;
        this.commonMessageService = commonMessageService;
    }


    @Override
    public MockResponse mock(Long projectId, String txCode, String url, Map<String, String> headers, Map<String, Object> paramsMap) {
        InterFacePO interFacePO =selectInterface(projectId,txCode,url);
        String errMsg = ValidatorUtils.checkParam(paramsMap,interFacePO,getCommonMessage(interFacePO));
        MockResponse mockResponse =getMockResponse(interFacePO,headers,paramsMap);
        mockResponse.setErrMsg(errMsg);
        return mockResponse;
    }


    private InterFacePO selectInterface(Long projectId, String txCode, String url) {
        InterFacePO interFacePO = interfaceService.selectInterface(projectId,txCode,url);
        Assert.notNull(interFacePO,()-> String.valueOf(new NotFoundException(MsgConstants.INTERFACE_NOT_FOUND)));
        return interFacePO;
    }
    private MockResponse getMockResponse(InterFacePO interFacePO, Map<String, String> headers, Map<String, Object> paramsMap) {
        return null;
    }

    @Override
    public MockResponse mock(Long projectId, String txCode, Map<String, Object> paramsMap) {
        return null;
    }

    public void saveRelatedData(Long caseId , Map<String,Object> body){
//       List<RelatedApiPO> list = relatedDataService.
    }

    /*
    *判断当前案例是否匹配
    **/
    public boolean isCaseMatching(Map<String,String> headers, Map<String, Object> bodyMap, InterFaceCasePO interFaceCasePO){
        for(ExpectationPO expectationPO : interFaceCasePO.getExpectationPOList()){
//            String value = CommonUtils.getValue(expectationPO.getCondition(),expectationPO.getKey(),headers,bodyMap);
            String value = getValue(expectationPO.getLocation(),expectationPO.getKey(),headers,bodyMap);

        }
        return true;
    }

    public static String getValue(String location,String key ,Map<String,String> headers,Map<String,Object> bodyMap){
        if (StringUtils.isAnyBlank(location,key)){
            log.error("c参数配置错误：".concat(location).concat(",").concat(key));
            return null;
        }
        if ("01".equals(location)){
            //从header中获取
            return headers.get(key);
        } else if ("02".equals(location)||"03".equals(location)){
            //从body中获取
            return getValues(bodyMap,key);
        } else {
            throw new RuntimeException("不支持的参数位置".concat(location));
        }
    }

    public static String getValues(Map<String ,Object> jsonObject,String keys){
        Assert.hasText(keys,"不能为空");
        Object temp = jsonObject;
        String[] keyList = getKeyList(keys);
        for(String key : keyList){
            if ( null == temp){
                return null;
            }
            if (StringUtils.isBlank(key)){
                throw new RuntimeException("参数配置错误：".concat(keys));
            }
            try {
                temp = getObject(temp,key);
            }catch (Exception e){
                return null;
            }
        }
        return null == temp ? null : String.valueOf(temp);
    }

    private static Object getObject(Object temp, String key) {
        if (StringUtils.isNumeric(key)){
            temp = ((List<?>) temp).get(Integer.parseInt(key));
        }else {
            temp = ((Map<?,?>) temp).get(key);
        }
        return temp;
    }

    private static String getValue(Map<String,Object> jsonObject, String keys) {
        Assert.hasText(keys,"key不能为空");
        Object temp = jsonObject;
        String[] keyList = getKeyList(keys);
        for (String key : keyList){
            if(null == temp){
                return null;
            }
            if (StringUtils.isBlank(key)){
                throw new RuntimeException("参数配置错误：".concat(keys));
            }
            try {

            }catch (Exception e){
                log.warn("c从jsonObject获取值key异常",e);
                return null;
            }
        }
        return null == temp ? null : String.valueOf(temp);
    }

    private static String[] getKeyList(String keys) {
        return keys.split("\\.");
    }




    @Override
    public CommonMessagePo getCommonMessage(InterFacePO interFacePO) {
        IsRelatedPO isRelatedPO = interFacePO.getIsRelatedRequest();
        if (ObjectUtil.isNotEmpty(interFacePO)){
            Long id = isRelatedPO.getId();
            return commonMessageService.selectById(id);
        }
        return null;
    }
}
