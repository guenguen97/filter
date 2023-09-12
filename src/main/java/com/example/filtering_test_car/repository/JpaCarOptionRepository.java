package com.example.filtering_test_car.repository;

import com.example.filtering_test_car.domain.CarDetail;
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

    @Override
    public List<CarOption> findById(List<Integer> id) {
        return em.createNativeQuery(
                        "SELECT * FROM CarOption  WHERE CarOption.id in :id",
                        CarOption.class
                )
                .setParameter("id", id)
                .getResultList();
    }


//    @Override
//    public List<CarOption> findByid(Integer optionIds){
//
//        return em.createQuery("select * from CarOption where SelectOption_optionId.id in :id ", CarOption.class)
//                .setParameter("id", optionIds)
//                .getResultList();
//
//    };

//    @Override
//    public List<Integer> getCarDetailByColorId(List<List<Integer>> id){
//
//        return em.createQuery("select * from CarOption where CarOption.id in :id ", CarOption.class)
//                .setParameter("id", id)
//                .getResultList();
//
//    };
}
