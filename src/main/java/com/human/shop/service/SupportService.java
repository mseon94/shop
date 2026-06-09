package com.human.shop.service;

import java.util.List;

import com.human.shop.vo.SupportVO;

public interface SupportService {
    void insertSupport(SupportVO supportVo);

    List<SupportVO> getSupportList();
}
