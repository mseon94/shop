package com.human.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.human.shop.mapper.SupportMapper;
import com.human.shop.vo.SupportVO;

@Service
public class SupportServiceImpl implements SupportService{

    @Autowired
    private SupportMapper supportMapper;

    @Override
    public void insertSupport(SupportVO supportVo) {
         if(supportVo.getWriter()==null || supportVo.getWriter().trim().isEmpty()){
            supportVo.setWriter("사용자");
        }    
        supportMapper.insertSupport(supportVo);
    }

    @Override
    public List<SupportVO> getSupportList(){
        List<SupportVO> supportList =  supportMapper.selectSupportList();
        return supportList;
    }

    
}
