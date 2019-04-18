package com.lambda;

import com.lambda.domain.Product;
import com.lambda.domain.ProductInstance;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LambdaTest {

    public static void main(String[] args) {
        testNewObject();
        //testReduce();
        //testCollect();
        //testMap();
        //testFilter1();
    }

    private static void testNewObject(){
        List<ProductInstance> list=new ArrayList<>();
        ProductInstance a=new ProductInstance();
        a.setProductId(1L);
        list.add(a);

       list.stream().map(productInstance -> {
           Product p=new Product();
           p.setId(productInstance.getProductId());
           return p;
       }).collect(Collectors.toList()).forEach(n->Utils.println("result="+n.getId()));


    }

    private static void testReduce() {
        int count=Stream.of(1,2,3).reduce(0,(acc,element)->acc+element);
        Utils.println(count);
    }


    private static void testFilter1(){
        List<String> list=Stream.of("a","1abc","abc1").collect(Collectors.toList());
        List<String> result=list.stream().filter(str->str.startsWith("a")).collect(Collectors.toList());
        List<String> result2=list.stream().filter(str->str.equals("a")).collect(Collectors.toList());
        Utils.println(result);
        System.out.print("===>");
        Utils.println(result2);
        list.stream().filter(str->str.equals("abc1")).collect(Collectors.toList()).forEach((n)->System.out.print("|"+n+"|"));
    }



    private static void testMap() {
        //使用map做大小写转换
        List<String> list = Stream.of("a", "b", "c").map(String::toUpperCase).collect(Collectors.toList());
        Utils.println(list);
    }

    private static void testCollect() {
        //将Stream 生成一个列表
        List<String> list = Stream.of("a","b","c").collect(Collectors.toList());
        System.out.println(list.size());
        Utils.println(list);
    }
}
