package com.example.filtering_test_car.repository;

import com.example.filtering_test_car.domain.SelectOption;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SelectOptionRepository {

    List<Integer> findById(Integer i);

}
