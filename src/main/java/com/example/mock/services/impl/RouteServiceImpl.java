package com.example.mock.services.impl;

import com.example.demo.mock.entity.po.RoutePO;
import com.example.demo.mock.service.RouteService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RouteServiceImpl implements RouteService {
    @Override
    public RoutePO selectByUrl(Long projectId, String url) {
        return null;
    }
}
