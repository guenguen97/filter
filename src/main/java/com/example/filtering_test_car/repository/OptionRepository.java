package com.example.filtering_test_car.repository;

import com.example.filtering_test_car.domain.Option;

import java.util.List;

public interface OptionRepository {

    List<Option> getOptionByCarId(Long id);

}
