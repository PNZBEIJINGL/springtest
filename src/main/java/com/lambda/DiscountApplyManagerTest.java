package com.lambda;

import com.lambda.domain.DiscountDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class DiscountApplyManagerTest {

   // @org.junit.Test
    public void testGetUnUsedDiscount() {
        DiscountDTO d1 = new DiscountDTO();
        d1.setId(1L);
        d1.setName("1年优惠20");
        DiscountDTO d2 = new DiscountDTO();
        d2.setId(2L);
        d2.setName("1年优惠21");
        DiscountDTO d3 = new DiscountDTO();
        d3.setId(3L);
        d3.setName("1年优惠22");
        List<DiscountDTO> allDiscount = new ArrayList<>();
        allDiscount.add(d1);
        allDiscount.add(d2);
        allDiscount.add(d3);
        List<DiscountDTO> useDiscount = new ArrayList<>();
        useDiscount.add(d2);
        useDiscount.add(d3);

        List<DiscountDTO> result = allDiscount.stream().filter(discountDTO -> !useDiscount.contains(discountDTO)).collect(Collectors.toList());

        result.forEach(discountDTO -> {
            System.out.println(discountDTO.getId()+" "+discountDTO.getName());
        });

        /*
        Assert.isTrue(result != null && result.size() == 1, "testGetUnUsedDiscount:size correct");
        Assert.isTrue(result.get(0).getId().equals(1), "testGetUnUsedDiscount:DiscountDTO id correct");
        Assert.isTrue(result.get(0).getName().equals("1年优惠20"), "testGetUnUsedDiscount:DiscountDTO name correct");
        */
    }

    public static void main(String[] args) {
        DiscountApplyManagerTest test = new DiscountApplyManagerTest();
        test.testGetUnUsedDiscount();
    }
}
