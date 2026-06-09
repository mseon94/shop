package com.human.shop.service;

import java.util.List;

import com.human.shop.vo.PdmVO;

public interface PdmService {
    
    // 상품 추가 서비스
    void addProduct(PdmVO pdmVo);

    List<PdmVO> productList();

    PdmVO detailProduct(long id);
}
