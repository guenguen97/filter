package com.example.filtering_test_car.service;


import com.example.filtering_test_car.domain.Car;
import com.example.filtering_test_car.domain.CarDetail;
import com.example.filtering_test_car.domain.CarDetail2;
import com.example.filtering_test_car.domain.Option;
import com.example.filtering_test_car.repository.CarDetailRepository;
import com.example.filtering_test_car.repository.CarRepository;
import com.example.filtering_test_car.repository.OptionRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CarService {

    private final CarRepository carRepository;
    private final OptionRepository optionRepository;
    private final CarDetailRepository carDetailRepository;

    @Autowired
    public CarService(CarRepository carRepository, OptionRepository optionRepository, CarDetailRepository carDetailRepository) {
        this.optionRepository = optionRepository;
        this.carRepository = carRepository;
        this.carDetailRepository = carDetailRepository;
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

    public List<CarDetail2> getColor2() {
        return carDetailRepository.getColor2();
    }

}
