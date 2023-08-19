package com.example.filtering_test_car.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Car {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;
    @NonNull
    private String size;
    @NonNull
    private String engine;
    @NonNull
    private Long displacement;
    @NonNull
    private Long distanceDriven;
    @NonNull
    private Long minPrice;
    @NonNull
    private Long maxPrice;
    @NonNull
    private String imgUrl;




}
