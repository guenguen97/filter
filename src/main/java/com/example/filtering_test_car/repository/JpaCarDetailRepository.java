package com.example.filtering_test_car.repository;


import com.example.filtering_test_car.domain.CarDetail;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class JpaCarDetailRepository implements CarDetailRepository{

    private final EntityManager em;

    @Autowired
    public JpaCarDetailRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<CarDetail> getColor() {
        return em.createQuery("select c from CarDetail c", CarDetail.class)
                .getResultList();
    }
}
