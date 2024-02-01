package com.example.mock.service;

import com.example.mock.common.MockResponse;
import com.example.mock.entity.UrlEntity;

import java.util.Map;

public interface HttpMockService {
    MockResponse mock(UrlEntity urlEntity, Map<String, String> headers, String body);

    MockResponse mock(UrlEntity urlEntity, Map<String, String> headers, String params, String characterEncoding);
}
