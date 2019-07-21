package com.lambda;

import com.lambda.domain.DiscountDTO;

import java.util.*;
import java.util.stream.Collectors;

public class DiscountDTOTest {
    public static void main(String[] args) {

        //过滤
        testGetSubList();

        //计数
        testSum();
        DiscountDTO d1 = new DiscountDTO();
        d1.setId(1L);
        d1.setName("1年优惠20");
        DiscountDTO d2 = new DiscountDTO();
        d2.setId(2L);
        d2.setName("1年优惠21");
        DiscountDTO d3 = new DiscountDTO();
        d3.setId(2L);
        d3.setName("1年优惠21");
        List<DiscountDTO> allDiscount = new ArrayList<>();
        allDiscount.add(d1);
        allDiscount.add(d2);
        allDiscount.add(d3);
        List<DiscountDTO> useDiscount = new ArrayList<>();
        useDiscount.add(d2);
        useDiscount.add(d3);

        List<DiscountDTO> result=allDiscount.stream().filter(discountDTO -> !useDiscount.contains(discountDTO)).collect(Collectors.toList());
        result.forEach(discountDTO -> {
            System.out.println(discountDTO.getId()+" "+discountDTO.getName());
        });
        allDiscount.forEach(discountDTO -> {
            System.out.println(discountDTO.getId()+" "+discountDTO.getName());
        });
    }

    private static void testSum() {
        Map<Long, Double> monthFee = new HashMap<>();
        monthFee.put(1L, 50d);
        monthFee.put(2L, 60d);
        Double all = monthFee.values().stream().reduce(10d, (sum, value) -> sum + value);
        System.out.println(all);
    }

    private static void testGetSubList() {
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
        for (String s : a) {
            System.out.println(s);
        }
    }
}
