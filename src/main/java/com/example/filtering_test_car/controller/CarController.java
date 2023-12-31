package com.example.filtering_test_car.controller;


import com.example.filtering_test_car.service.SelectOptionService;
import com.example.filtering_test_car.domain.*;
import com.example.filtering_test_car.service.CarService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static com.example.filtering_test_car.domain.QSelectOption.selectOption;

@Controller
public class CarController {

    private final CarService carService;

    @Autowired
    private SelectOptionService selectOptionService;
    private List<SelectOption> selectOptions;

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
        List<CarOption> carOption = carService.getList();

        System.out.println(carDetails2.get(0).getBtnUrl());

        model.addAttribute("carDetails", carDetails);
        model.addAttribute("carDetails2", carDetails2);
        model.addAttribute("carOption", carOption);

        return "444";

    }

    @PostMapping("/car/select")
    public String getSelect(SelectForm selectForm) {

        System.out.println(selectForm.getOptionId());
        System.out.println(selectForm.getInteriorColor());



        return "redirect:/";
    }

    @GetMapping("/myPage") //
    public String showMyPage(Model model,Integer userId, Integer selectOptionId) {
        //여기에는 이제 userId 를 매개변수로 넣어서 그 userId 의 차 견적 정보만 뜨게 하기
        // 지금은 전체 견적 리스트 뽑음
        //상세페이지에서는 이 리스트가 하나만 나오게 해야됨
        //내 차만들기 하고 바로 견적서 보여주려면 로그인한 유저의 가장 최근에 추가된
        // selectOption db 정보를 보여주면 될것같다.
        List<SelectOption> selectOptions = selectOptionService.getList();

        System.out.println("마이 페이지 실행 시작");
        List<Integer> colorIds = new ArrayList<>();

//         여기에 유저id ,userId 나 그런거 넣으면 optionid 를 리스트 형태로 반환함
        // 지금은 예시용으로 어떤 유저의 첫번쨰 견적 정보 받음
        // 만약 2를 적으면 그 사람의 2번쨰 견적 차량의 optionIds 받는거고
        //여기서 optionIds 는 네비, 폰충전, 등등 내부 옵션등을 말한다.
        List<Integer> optionIds= carService.getSelectOptionIdsById(1);



        for (SelectOption selectOption : selectOptions) {
            // Assuming getColorId() is the method to retrieve the colorId from SelectOption
            int colorId = selectOption.getOutColorId();
            colorIds.add(colorId);
        }

        List<CarOption> carOption =carService.getCarOptionById(optionIds);



        List<CarDetail> carDetail =carService.getCarDetailByColorId(colorIds);
        for(SelectOption selectOption : selectOptions){
            System.out.println(selectOption.getWholePrice());
        }

        for(CarDetail carDetail1: carDetail){
            System.out.println(carDetail1.getImgUrl());
        }

        model.addAttribute("carOption", carOption);


        model.addAttribute("selectOption", selectOptions);
        model.addAttribute("carDetail", carDetail);



        return "myPage";

    }

    @GetMapping("myPageDetail/{selectOptionId}")
    public String showMyPageDetail(Model model, @PathVariable("selectOptionId") Integer selectOptionId) {
        System.out.println("견적 상세페이지 실행됨");
        System.out.println(selectOptionId);

        List<SelectOption> selectOptions= selectOptionService.getListBySelectOptionId(selectOptionId);

        System.out.println(selectOptions);
        System.out.println(selectOptions.get(0).getWholePrice());


        List<Integer> colorIds = new ArrayList<>();
        List<Integer> optionIds = carService.getSelectOptionIdsById(selectOptionId);





        for (SelectOption selectOption : selectOptions) {
            // Assuming getColorId() is the method to retrieve the colorId from SelectOption
            int colorId = selectOption.getOutColorId();
            colorIds.add(colorId);
        }

        List<CarOption> carOption =carService.getCarOptionById(optionIds);
        List<CarDetail> carDetail =carService.getCarDetailByColorId(colorIds);
        List<CarDetail2> carDetail2 =carService.getCarDetail2ByColorId(colorIds);
        System.out.println(carOption);

        System.out.println(carDetail2.get(0).getBtnUrl());

        model.addAttribute("selectOption", selectOptions);
        model.addAttribute("carDetail", carDetail);
        model.addAttribute("carDetail2", carDetail2);

        model.addAttribute("carOption", carOption);


        return "myPageDetail";
    }


    @PostMapping("/doDelete")
    public String result(Model model, @RequestParam("id") List<Integer> id) {
        System.out.println("삭제 기능 시작");
        System.out.println(id.get(0));

        carService.delete(id);


        return "redirect:/myPage";
    }


}
