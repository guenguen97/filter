package com.example.filtering_test_car.repository;

import com.example.filtering_test_car.domain.SelectOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface SelectOptionRepository{


    public List<Integer> findOptionDetailById(Integer id);


}
