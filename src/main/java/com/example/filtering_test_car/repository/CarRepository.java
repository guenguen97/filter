package com.example.filtering_test_car.repository;

import com.example.filtering_test_car.domain.Car;

import java.util.List;

public interface CarRepository {

    List<Car> getCarsBySearch(String size, String engine, Long displacement, Long distanceDriven, Long maxPrice);

}
