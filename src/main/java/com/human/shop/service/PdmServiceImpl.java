package com.human.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.human.shop.mapper.PdmMapper;
import com.human.shop.vo.PdmVO;

@Service
public class PdmServiceImpl implements PdmService{

    @Autowired
    private PdmMapper pdmMapper;

    @Override
    public void addProduct(PdmVO pdmVo){
        pdmMapper.insertProduct(pdmVo);
    }

    @Override
    public List<PdmVO> productList() {
        pdmMapper.selectAllProduct();
        return pdmMapper.selectAllProduct();
    }

    @Override
    public PdmVO detailProduct(long id) {
        return pdmMapper.selectById(id);
    }

    
}
