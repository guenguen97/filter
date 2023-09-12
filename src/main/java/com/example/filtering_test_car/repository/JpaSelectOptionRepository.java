package com.example.filtering_test_car.repository;

import jakarta.persistence.EntityManager;

public class JpaSelectOptionRepository implements SelectOptionRepository {


    private final EntityManager em;

    public JpaSelectOptionRepository(EntityManager em) {
        this.em = em;
    }




}
