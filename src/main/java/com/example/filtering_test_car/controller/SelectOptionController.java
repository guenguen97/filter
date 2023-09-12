package com.example.filtering_test_car.controller;

import com.example.filtering_test_car.service.SelectOptionService;
import com.example.filtering_test_car.domain.SelectOption;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@Controller
public class SelectOptionController {
    private final SelectOptionService selectOptionService;

    @PostMapping("/dd")
    public String result(Model model, @Valid SelectOption selectOption , @RequestParam("optionId") Integer optionId ,
                         SelectForm selectForm, @RequestParam("inColorId") Integer inColorId ,
                         @RequestParam("outColorId") Integer outColorId ,@RequestParam("wholePrice") Integer wholePrice,@RequestParam("imgUrl") String imgUrl) {

        selectOptionService.create(selectOption.getUserId(),selectOption.getInColorId(),
                selectOption.getOptionId(),selectOption.getOutColorId(), selectOption.getWholePrice(),selectOption.getImgUrl());
        System.out.println("차 옵션 만드는거 1차 실행부분");
        System.out.println(selectOption.getOptionId());
        System.out.println(selectOption.getInColorId());
        System.out.println(selectOption.getOutColorId());
        System.out.println(selectOption.getWholePrice());
        return "redirect:/";
    }
}
