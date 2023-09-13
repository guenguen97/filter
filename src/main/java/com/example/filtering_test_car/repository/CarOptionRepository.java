package com.example.filtering_test_car.repository;

import com.example.filtering_test_car.domain.CarOption;
import java.util.List;

public interface CarOptionRepository {

    List<CarOption> findAll();

    List<CarOption> findById(List<Integer> id);


    void doDelete(List<Integer> id);

    void doDelete2(List<Integer> id);



//    List<CarOption> findById();

}
