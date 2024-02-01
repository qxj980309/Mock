package com.example.mock.service;

import com.example.mock.common.MockResponse;
import com.example.mock.po.CommonMessagePo;
import com.example.mock.po.InterFacePO;

import java.util.Map;

public interface CommonMockService {
    /*
    * 通用Mock方法
    * project 工程id ，txCode 接口编号， headers 请求头， paramsMap 请求参数
    * */
    MockResponse mock (Long projectId, String txCode , String url, Map<String,String> headers,Map<String,Object> paramsMap);

    /*
     * 通用Mock方法
     * project 工程id ，txCode 接口编号， paramsMap 请求参数
     * */
    MockResponse mock (Long projectId, String txCode , Map<String,Object> paramsMap);


    /*
     * 通用Mock方法
     * project 工程id ，txCode 接口编号， headers 请求头， paramsMap 请求参数
     * */
    CommonMessagePo getCommonMessage(InterFacePO interFacePO);



}
