package com.example.mock.controller;

import cn.hutool.core.lang.Assert;
import com.example.mock.common.entity.UrlEntity;
import io.swagger.annotations.Api;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/mock/*")
@Api(tags = "Mock控制层")
public class MockController {
    @Resource
    private  MockService mockService;

    private static final Logger log = LoggerFactory.getLogger(MockController.class);

    public String mock(HttpServletRequest request, HttpServletResponse response, @RequestBody String body){
        UrlEntity urlEntity = parseUrl(request.getRequestURI());
        Map<String,String> headers = getHeaders(request);
        HttpResponse mockRes = mockService.mock(urlEntity,headers,body);
        addStatus(response,mockRes.getStatus());
        addErrMsg(response,mockRes.getErrMsg());
        return mockRes.getBody();
    }


    public String mock(HttpServletRequest request, HttpServletResponse response){
        String params =request.getQueryString();
        UrlEntity urlEntity = parseUrl(request.getRequestURI());
        Map<String,String> headers = getHeaders(request);
        String characterEncoding = request.getCharacterEncoding();
        HttpResponse mockRes = mockService.mock(urlEntity,headers,params,characterEncoding);
        addStatus(response,mockRes.getStatus());
        addErrMsg(response,mockRes.getErrMsg());
        return mockRes.getBody();
    }

    private UrlEntity parseUrl(String urls) {
        String[] url = StringUtils.split(urls,"/",4);
        Assert.isTrue(url.length ==4 ,() -> new RuntimeException("url格式错误"));
        return new UrlEntity(url[1],url[2],"/"+url[3]);
    }


    private Map<String, String> getHeaders(HttpServletRequest request) {
        HashMap<String,String> map = new HashMap<>();
        Enumeration<String> enumeration = request.getHeaderNames();
        while(enumeration.hasMoreElements()){
            String name = enumeration.nextElement();
            String value = request.getHeader(name);
            map.put(name,value);
        }
        return map;
    }


    private void addStatus(HttpServletResponse response, Integer status) {
        if ((null == status)){
            return;
        }
        response.setStatus(status);
    }

    private void addErrMsg(HttpServletResponse response, String errMsg) {
        if (StringUtils.isBlank(errMsg)){
            return;
        }
        try {
            response.setCharacterEncoding("UTF-8");
            response.setHeader("errMsg",errMsg);
            response.setStatus(400);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
