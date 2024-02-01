package com.example.mock.service;

import com.example.mock.po.CommonMessagePo;

public interface CommonMessageService {
    //根据id查询
    CommonMessagePo selectById(Long id);
}
