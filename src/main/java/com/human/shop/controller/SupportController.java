package com.human.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.human.shop.service.SupportService;
import com.human.shop.vo.SupportVO;


@Controller
public class SupportController {
    
    @Autowired
    private SupportService supportService;

    @GetMapping("/supports")
    public String getSupportList(Model model) {
        List<SupportVO> supportList = supportService.getSupportList();
        model.addAttribute("supportList", supportList);
        return "support/support_list";
    }

    @GetMapping("/supports/write")
    public String getSuppoutWrite() {
        return "support/support_write";
    }
    
    @PostMapping("/supports/write")
    public String postSupport(@ModelAttribute SupportVO SupportVo) {        
        System.out.println(toString());
        supportService.insertSupport(SupportVo);
        System.out.println("db저장 성공");
        return "redirect:/supports";
    }
    
    

}
