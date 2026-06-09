package com.human.shop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.human.shop.vo.SupportVO;

@Mapper
public interface SupportMapper {
    public void insertSupport(SupportVO supportVo);
    List<SupportVO> selectSupportList();
}
