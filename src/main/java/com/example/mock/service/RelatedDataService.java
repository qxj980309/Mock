package com.example.mock.service;

import com.example.mock.po.RelatedApiPO;

import java.util.List;

public interface RelatedDataService {
    //根据条件查询，返回list
    List<RelatedApiPO> selectList(RelatedApiPO relatedApiPO);

    //根据caseId
}
