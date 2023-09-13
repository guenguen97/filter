package com.example.filtering_test_car.service;


import com.example.filtering_test_car.domain.SelectOption;
import com.example.filtering_test_car.repository.SelectOptionRepository2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class SelectOptionService {
    private  final SelectOptionRepository2 selectOptionRepository2;
//    private  final SelectOptionRepository selectOptionRepository;

    public List<SelectOption> getLastSelectOption() {
        return this.selectOptionRepository2.getLastSelectOption();
    }


    public SelectOption create(Integer userId, Integer inColorId,List<Integer> optionId ,Integer outColorId,
                                 Integer wholePrice ,String outImgUrl, String inImgUrl  ) {
        SelectOption user = new SelectOption();

        user.setUserId(userId);
        user.setInColorId(inColorId);
        user.setOutColorId(outColorId);
        user.setOptionId(optionId);
        user.setWholePrice(wholePrice);
        user.setCreateDate(LocalDateTime.now());
        user.setOutImgUrl(outImgUrl);
        user.setInImgUrl(inImgUrl);


        return selectOptionRepository2.save(user);
    }

    public List<SelectOption> getList() {
        return this.selectOptionRepository2.findAll();
    }




    public List<SelectOption> getListBySelectOptionId(Integer selectOptionId) {
        return this.selectOptionRepository2.findBySelectOptionId(selectOptionId);
    }
}
