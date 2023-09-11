package com.example.filtering_test_car.repository;


import com.example.filtering_test_car.domain.CarDetail;
import com.example.filtering_test_car.domain.CarDetail2;
import com.example.filtering_test_car.domain.Option;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class JpaCarDetailRepository implements CarDetailRepository {

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

    @Override
    public List<CarDetail2> getColor2() {
        return em.createQuery("select d from CarDetail2 d", CarDetail2.class)
                .getResultList();
    }

    @Override
    public List<CarDetail> getCarDetailByColorId(List<Integer> id) {
        return em.createNativeQuery(
                        "SELECT * FROM `carDetail` WHERE JSON_ARRAY_CONTAINS(:id, JSON_ARRAYAGG(id)) = 1",
                        CarDetail.class
                )
                .setParameter("id", id)
                .getResultList();
    }

}
