package com.example.mock.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.mock.common.RestResponse;
import com.example.mock.po.CommonMessagePo;
import com.example.mock.po.InterFacePO;
import com.example.mock.po.IsRelatedPO;
import com.example.mock.po.vo.CommonMessageVO;
import com.example.mock.po.vo.ConfirmVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface InterfaceService {
    InterFacePO selectById(Long id);

    //条件查询多条数据
    List<InterFacePO> selectList(InterFacePO interFacePO);

    //通过url和txCode匹配接口
    InterFacePO selectInterface(Long id , String txCode, String url);

    //分页条件查询
    IPage<InterFacePO> selectPage(InterFacePO interFacePO ,Integer pageIndex, Integer pageSize );

    RestResponse<?> updateById(InterFacePO interFacePO);

    RestResponse<?> deleteById(Long id);

    //导入某个接口的数据
    RestResponse<?> uploadOne(InterFacePO interFacePO, MultipartFile multipartFile);

    RestResponse<?> uploadAll(InterFacePO interFacePO , MultipartFile multipartFile , IsRelatedPO isRelatedRequestPO, IsRelatedPO isRelatedResponsePO);

    RestResponse<?> uploadConfirm(ConfirmVO confirmVO);

    //查询公共报文枚举类
    List<CommonMessageVO> selectEnum();

    //接口报文关联公共报文 type ：request 请求报文 ，response 相应报文
    RestResponse<?> relateCommon(IsRelatedPO isRelatedPO,Long id,String type);

    //关闭关联接口， type ：request 请求报文 ，response 相应报文
    RestResponse<?> closeRelateCommon(Long id,String type);
}
