package com.human.shop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.human.shop.vo.PdmVO;

@Mapper
public interface PdmMapper {
    
    // 상품등록
    public void insertProduct(PdmVO pdmVo);

    // 목록보기
    List<PdmVO> selectAllProduct();

    public PdmVO selectById(long id);
}
