package com.example.filtering_test_car.controller;


import com.example.filtering_test_car.domain.Option;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SelectForm {

    private List<Integer> optionId;

    private Integer exteriorColor;

    private Integer InteriorColor;

    private Integer inColor;

    private Integer outColor;



}
