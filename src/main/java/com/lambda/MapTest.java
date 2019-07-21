package com.lambda;

import com.lambda.domain.DiscountDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MapTest {
    public static void main(String[] args) {
        List<DiscountDTO> unUsedDiscountDTO = new ArrayList<>();
        DiscountDTO d1 = new DiscountDTO();
        d1.setName("1年优惠20");
        DiscountDTO d2 = new DiscountDTO();
        d2.setName("1年优惠21");
        DiscountDTO d3 = new DiscountDTO();
        d3.setName("1年优惠21");
        unUsedDiscountDTO.add(d1);
        unUsedDiscountDTO.add(d2);
        unUsedDiscountDTO.add(d3);

        //TEST.1
        Map<Long, DiscountDTO> map = unUsedDiscountDTO.stream().collect(Collectors.toMap(DiscountDTO::getId, discountDTO -> discountDTO));
        //account -> account是一个返回本身的lambda表达式，其实还可以使用Function接口中的一个默认方法代替，使整个方法更简洁优雅
        Map<Long, DiscountDTO> map2 = unUsedDiscountDTO.stream().collect(Collectors.toMap(DiscountDTO::getId, Function.identity()));
        //TEST2
        Map<Long, String> mapCode = unUsedDiscountDTO.stream().collect(Collectors.toMap(DiscountDTO::getId, DiscountDTO::getCode));

        //如果有重复的key会报错 java.lang.IllegalStateException: Duplicate key
    }
}
