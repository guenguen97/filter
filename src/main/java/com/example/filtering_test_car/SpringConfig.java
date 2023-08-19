package com.example.filtering_test_car;

import com.example.filtering_test_car.repository.CarRepository;
import com.example.filtering_test_car.repository.JpaCarRepository;
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
        return new CarService(carRepository());
    }

    @Bean
    public CarRepository carRepository() {
        return new JpaCarRepository(em);
    }
}
