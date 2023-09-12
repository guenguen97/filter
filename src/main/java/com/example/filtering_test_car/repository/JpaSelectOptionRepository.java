package com.example.filtering_test_car.repository;

import com.example.filtering_test_car.domain.CarDetail;
import com.example.filtering_test_car.domain.SelectOption;
import jakarta.persistence.EntityManager;

import java.util.List;

public class JpaSelectOptionRepository implements SelectOptionRepository {


    private final EntityManager em;

    public JpaSelectOptionRepository(EntityManager em) {
        this.em = em;
    }



    @Override
    public List<Integer> findOptionDetailById(Integer id) {
        return em.createNativeQuery(
                        "SELECT option_id FROM selectOption_optionId WHERE SelectOption_id = :id")
                .setParameter("id", id)
                .getResultList();
    }

    @Override
    public List<SelectOption> findBySelectOptionId(Integer id) {
        return em.createNativeQuery(
                        "SELECT * FROM selectOption WHERE id = :id")
                .setParameter("id", id)
                .getResultList();
    }




}
