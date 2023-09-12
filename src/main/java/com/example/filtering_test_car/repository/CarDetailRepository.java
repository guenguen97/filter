package com.example.filtering_test_car.repository;

import com.example.filtering_test_car.domain.CarDetail;
import com.example.filtering_test_car.domain.CarDetail2;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarDetailRepository {

    List<CarDetail> getColor();
    List<CarDetail2> getColor2();

    List<CarDetail> getCarDetailByColorId(List<Integer> id);


}
