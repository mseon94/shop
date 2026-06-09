package com.human.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.human.shop.service.PdmService;
import com.human.shop.vo.PdmVO;
import org.springframework.web.bind.annotation.RequestParam;




@Controller
public class PdmController {
    
    @Autowired
    private PdmService pdmService;

    @GetMapping("/pdm")
    public String getPdmList(Model model) {
        List<PdmVO> products = pdmService.productList();
        model.addAttribute("products", products);
        return "pdm/pdm_list";
    }

    @GetMapping("/pdm/write")
    public String getPdmWrite() {
        return "pdm/pdm_write";
    }

    @PostMapping("/pdm")
    public String addPdm(@ModelAttribute PdmVO pdmVo) {
        pdmService.addProduct(pdmVo);
        return "redirect:/pdm";
    }
    
    @GetMapping("/pdm/{id}")
    public String viewProduct(@PathVariable("id") long id, Model model) {
        model.addAttribute("product",pdmService.detailProduct(id));
        return "pdm/pdm_detail";
    }
    
    
}
