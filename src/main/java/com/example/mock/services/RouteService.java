package com.example.mock.services;

import com.example.demo.mock.entity.po.RoutePO;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteService {
    RoutePO selectByUrl(Long projectId, String url);
}
