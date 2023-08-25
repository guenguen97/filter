package com.example.filtering_test_car.controller;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SearchForm {

    private List<String> size;
    private String engine;
    private Long displacement;
    private Long distanceDriven;
    private Long maxPrice;


}
