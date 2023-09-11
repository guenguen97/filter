package com.example.filtering_test_car.service;


import com.example.filtering_test_car.domain.SelectOption;
import com.example.filtering_test_car.repository.SelectOptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class SelectOptionService {
    private  final SelectOptionRepository selectOptionRepository;


    public SelectOption create(String userName, Integer inColorId,List<Integer> optionId ,Integer outColorId,
                                 Integer wholePrice   ) {
        SelectOption user = new SelectOption();

        user.setUserName(userName);
        user.setInColorId(inColorId);
        user.setOutColorId(outColorId);
        user.setOptionId(optionId);
        user.setWholePrice(wholePrice);
        user.setCreateDate(LocalDateTime.now());

        return selectOptionRepository.save(user);
    }

    public List<SelectOption> getList() {
        return this.selectOptionRepository.findAll();
    }


}
