package com.lambda;

import com.lambda.domain.Artist;
import com.lambda.domain.Product;
import com.lambda.domain.ProductInstance;
import com.lambda.util.DataUtils;
import com.lambda.util.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LambdaBookTest {

    public static void main(String[] args) {
        //testNewObject();
        testReduce();
        //testCollect();
        testMap();
        //testFilter1();
        //testString();
    }

    private static void testString() {
        List<Artist> artists = DataUtils.createArtistlist();

        StringBuffer sbf = new StringBuffer("[");
        for (Artist artis : artists) {
            if (sbf.length() > 1) {
                sbf.append(",");
            }
            sbf.append(artis.getName());
        }
        sbf.append("]");
        Utils.println(sbf);

        //Another method
        //map 操作提取姓名，Collectors.joining 收集流中的值，分隔符|前缀|后缀
        String result = artists.stream().map(Artist::getName).collect(Collectors.joining("|", "[", "]"));
        Utils.println(result);

    }


    private static void testNewObject() {
        List<ProductInstance> list = new ArrayList<>();
        ProductInstance a = new ProductInstance();
        a.setProductId(1L);
        list.add(a);

        list.stream().map(productInstance -> {
            Product p = new Product();
            p.setId(productInstance.getProductId());
            return p;
        }).collect(Collectors.toList()).forEach(n -> Utils.println("result=" + n.getId()));


    }

    private static void testReduce() {
        int count = Stream.of(1, 2, 3).reduce(0, (acc, element) -> acc + element);
        Utils.println(count);
    }


    private static void testFilter1() {
        List<String> list = Stream.of("a", "1abc", "abc1").collect(Collectors.toList());
        List<String> result = list.stream().filter(str -> str.startsWith("a")).collect(Collectors.toList());
        List<String> result2 = list.stream().filter(str -> str.equals("a")).collect(Collectors.toList());
        Utils.println(result);
        System.out.print("===>");
        Utils.println(result2);
        list.stream().filter(str -> str.equals("abc1")).collect(Collectors.toList()).forEach((n) -> System.out.print("|" + n + "|"));
    }


    private static void testMap() {
        //使用map做大小写转换
        //map 使用String#toUpperCase 提取，然后使用collect搜集结果组装成
        Set<String> set = Stream.of("a", "b", "c").map(String::toUpperCase).collect(Collectors.toSet());
        Utils.println(set);


        //map 使用Artist#getName 提取  ,然后使用collect收集结果组装成list
        List<Artist> artistlist = DataUtils.createArtistlist();
        List<String> result = artistlist.stream().map(Artist::getName).collect(Collectors.toList());
        Utils.println(result);
    }

    private static void testCollect() {
        //将Stream 生成一个列表
        List<String> list = Stream.of("a", "b", "c").collect(Collectors.toList());
        System.out.println(list.size());
        Utils.println(list);
    }
}
