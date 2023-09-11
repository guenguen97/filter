package com.example.filtering_test_car.service;


import com.example.filtering_test_car.domain.*;

import com.example.filtering_test_car.repository.CarDetailRepository;
import com.example.filtering_test_car.repository.CarOptionRepository;
import com.example.filtering_test_car.repository.CarRepository;
import com.example.filtering_test_car.repository.OptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public class CarService {

    private final CarRepository carRepository;
    private final OptionRepository optionRepository;
    private final CarDetailRepository carDetailRepository;

    private final CarOptionRepository carOptionRepository;

    @Autowired
    public CarService(CarRepository carRepository, OptionRepository optionRepository, CarDetailRepository carDetailRepository, CarOptionRepository carOptionRepository) {
        this.optionRepository = optionRepository;
        this.carRepository = carRepository;
        this.carDetailRepository = carDetailRepository;
        this.carOptionRepository = carOptionRepository;
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

}
