package com.example.filtering_test_car.controller;


import com.example.filtering_test_car.domain.Car;
import com.example.filtering_test_car.domain.CarDetail;
import com.example.filtering_test_car.domain.CarDetail2;
import com.example.filtering_test_car.domain.Option;
import com.example.filtering_test_car.service.CarService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CarController {

    private final CarService carService;

    private List<Car> cars;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/")
    public String home(Model model) {

        List<Car> cars = carService.getCarsBySearch(null, null, null, null, null);

        this.cars = cars;
//
//        model.addAttribute("cars",cars);
//
//        for(Car car : cars) {
//            System.out.println(car.getId());
//        }

        return "home";
    }

    @PostMapping("/") // ajax 비동기 데이터 받기
    public String getCarsBySearch(SearchForm form) throws JsonProcessingException {

        List<Car> cars = carService.getCarsBySearch(form.getSize(), form.getEngine(), form.getDisplacement(), form.getDistanceDriven(), form.getMaxPrice());

        this.cars = cars;

        System.out.println(form.getSize());
        System.out.println(form.getEngine());
        System.out.println(form.getDisplacement());
        System.out.println(form.getMaxPrice());

//        model.addAttribute("cars",cars);
//        System.out.println("데이터전송 성공");
//
        for(Car car : cars) {
            System.out.println(car.getId());
        }

        return "home";
    }

    @GetMapping("/getCars") // ajax 비동기 데이터 전송
    @ResponseBody
    public String getCars() throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();

//        model.addAttribute("cars", listCars);

        return objectMapper.writeValueAsString(this.cars);// 이거 String 임

    }

    @GetMapping("/option") // Option 테스트용
    @ResponseBody
    public List<Option> getOption(Long id) {

        return carService.getOptionByCarId(id);

    }

    @GetMapping("/color")
    public String getColor(Model model) {

        List<CarDetail> carDetails =carService.getColor();
        List<CarDetail2> carDetails2 = carService.getColor2();

        System.out.println(carDetails2.get(0).getBtnUrl());

        model.addAttribute("carDetails", carDetails);
        model.addAttribute("carDetails2", carDetails2);


        return "qwer";

    }


}
