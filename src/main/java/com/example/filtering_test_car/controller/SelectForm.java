package com.example.filtering_test_car.controller;


import com.example.filtering_test_car.domain.Option;
import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.List;

@Getter
@Setter
public class SelectForm {

    private List<Integer> optionId;

    private Integer exteriorColor;

    private Integer InteriorColor;

    private Integer inColor;

    private Integer outColor;

    private Integer userId;

    private Integer inColorId;

    private Integer outColorId;


    private Integer wholePrice;


    private String createDate;



    private String outImgUrl;


    private String inImgUrl;





}
