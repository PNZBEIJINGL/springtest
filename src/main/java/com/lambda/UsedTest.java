package com.lambda;

import com.lambda.domain.DiscountDTO;

import java.util.*;
import java.util.stream.Collectors;

public class UsedTest {
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
        List<String> a = unUsedDiscountDTO.stream().map(DiscountDTO::getName).collect(Collectors.toList());
        for (String s: a) {
            System.out.println(s);
        }

        Map<Long, Double> monthFee=new HashMap<>();
        monthFee.put(1L,50d);
        monthFee.put(2L,60d);
        Double all=monthFee.values().stream().reduce(10d,(sum,value)->sum+value);
        System.out.println(all);
    }
}
