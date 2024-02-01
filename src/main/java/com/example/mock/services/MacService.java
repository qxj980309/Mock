package com.example.mock.services;

import com.example.demo.mock.entity.po.MacPO;
import org.springframework.stereotype.Repository;

@Repository
public interface MacService {
    /*
    *
    * */
    MacPO selectById(Long macId);
}
