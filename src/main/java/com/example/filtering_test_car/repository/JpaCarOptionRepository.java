package com.example.filtering_test_car.repository;

import com.example.filtering_test_car.domain.CarOption;
import jakarta.persistence.EntityManager;

import java.util.List;

public class JpaCarOptionRepository implements CarOptionRepository {

    private final EntityManager em;

    public JpaCarOptionRepository(EntityManager em) {
        this.em = em;
    }


    @Override
    public List<CarOption> findAll() {
        return em.createQuery("select o from CarOption o", CarOption.class)
                .getResultList();
    }
}
