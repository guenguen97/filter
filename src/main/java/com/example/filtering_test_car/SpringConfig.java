package com.example.filtering_test_car;

import com.example.filtering_test_car.domain.CarOption;
import com.example.filtering_test_car.repository.*;
import com.example.filtering_test_car.service.CarService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    private final EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }



    @Bean
    public CarService carService() {
        return new CarService(carRepository(), optionRepository(), carDetailRepository() ,carOptionRepository() ,selectOptionRepository());
    }

    @Bean
    public CarRepository carRepository() {
        return new JpaCarRepository(em);
    }

    @Bean
    public OptionRepository optionRepository() {
        return new JpaOptionRepository(em);
    }

    @Bean
    public CarDetailRepository carDetailRepository() {
        return new JpaCarDetailRepository(em);
    }


    @Bean
    public CarOptionRepository carOptionRepository() {
        return new JpaCarOptionRepository(em);
    }


    @Bean
    public SelectOptionRepository selectOptionRepository() {
        return new JpaSelectOptionRepository(em);
    }




}
