package com.example.filtering_test_car.service;


import com.example.filtering_test_car.domain.Car;
import com.example.filtering_test_car.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CarService {

    private final CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getCarsBySearch(String size, String engine, Long displacement, Long distanceDriven, Long maxPrice) {
        return carRepository.getCarsBySearch(size, engine, displacement, distanceDriven, maxPrice);
    }
}
