package com.example.filtering_test_car.repository;

import com.example.filtering_test_car.domain.CarDetail;
import com.example.filtering_test_car.domain.SelectOption;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;

import java.util.List;


@Transactional
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






}
