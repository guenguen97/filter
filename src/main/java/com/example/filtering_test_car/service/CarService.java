package com.example.filtering_test_car.service;


import com.example.filtering_test_car.domain.*;

import com.example.filtering_test_car.repository.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class CarService {

    private final CarRepository carRepository;
    private final OptionRepository optionRepository;
    private final CarDetailRepository carDetailRepository;

    private final SelectOptionRepository selectOptionRepository;
    private final CarOptionRepository carOptionRepository;

    @Autowired
    public CarService(CarRepository carRepository, OptionRepository optionRepository, CarDetailRepository carDetailRepository, CarOptionRepository carOptionRepository, SelectOptionRepository selectOptionRepository) {
        this.optionRepository = optionRepository;
        this.carRepository = carRepository;
        this.carDetailRepository = carDetailRepository;
        this.carOptionRepository = carOptionRepository;
        this.selectOptionRepository =selectOptionRepository;

    }

    public List<Car> getCarsBySearch(List<String> size, String engine, Long displacement, Long distanceDriven, Long maxPrice) {
        return carRepository.getCarsBySearch(size, engine, displacement, distanceDriven, maxPrice);
    }

    public List<Option> getOptionByCarId(Long id) {
        return optionRepository.getOptionByCarId(id);
    }

    public List<CarDetail> getColor() {
        return carDetailRepository.getColor();
    }

    public List<CarDetail> getCarDetailByColorId(List<Integer> id) {
        return carDetailRepository.getCarDetailByColorId(id);
    }

    public List<CarDetail2> getColor2() {
        return carDetailRepository.getColor2();
    }

    public List<CarOption> getList() {
        return carOptionRepository.findAll();
    }

//    public List<CarOption> getCarOptionByOptionId(List<List<Integer>> optionIds) {
//        return carOptionRepository.getCarDetailByColorId(optionIds);
//    }

//    public List<Integer> getCarOptionIdsById(Integer id) {
//        return carOptionRepository.findById(id);
//    }

    public List<Integer> getSelectOptionIdsById(Integer i) {
        return selectOptionRepository.findById(i);
    }
}
