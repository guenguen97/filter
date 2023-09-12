package com.example.filtering_test_car.controller;

import com.example.filtering_test_car.service.SelectOptionService;
import com.example.filtering_test_car.domain.SelectOption;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class SelectOptionController {
    private final SelectOptionService selectOptionService;
    private List<SelectOption> selectOptions;
    @PostMapping("/dd")
    @GetMapping
    public String result(Model model, @Valid SelectOption selectOption , @RequestParam("optionId") Integer optionId ,
                         SelectForm selectForm, @RequestParam("inColorId") Integer inColorId ,
                         @RequestParam("outColorId") Integer outColorId ,@RequestParam("wholePrice") Integer wholePrice,
                         @RequestParam("outImgUrl") String outImgUrl,  @RequestParam("inImgUrl") String inImgUrl) {

        selectOptionService.create(selectOption.getUserId(),selectOption.getInColorId(),
                selectOption.getOptionId(),selectOption.getOutColorId(), selectOption.getWholePrice(),selectOption.getOutImgUrl(),selectOption.getInImgUrl());
        System.out.println("차 옵션 만드는거 1차 실행부분");
        System.out.println(selectOption.getOptionId());
        System.out.println(selectOption.getInColorId());
        System.out.println(selectOption.getOutColorId());
        System.out.println(selectOption.getWholePrice());

//       로그인이랑 합치면 변수에 유저id 넣기

        List<SelectOption> selectOptions = selectOptionService.getLastSelectOption();

        System.out.println("바로 견적서 보여주기 파트");
        System.out.println(selectOptions.get(0).getWholePrice());
        model.addAttribute("selectOption",selectOptions);

        return "LastOption";
    }
}
