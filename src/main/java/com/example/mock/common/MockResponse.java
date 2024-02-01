package com.example.mock.common;

import io.swagger.annotations.Api;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Api(tags = "http响应")
public class MockResponse {
    private Integer status;

    private String body;

    private String errMsg;

    public MockResponse(String body) {
        this.body = body;
    }

    public MockResponse(String body, String errMsg) {
        this.body = body;
        this.errMsg = errMsg;
    }

    public MockResponse(Integer status, String body, String errMsg) {
        this.status = status;
        this.body = body;
        this.errMsg = errMsg;
    }
}
