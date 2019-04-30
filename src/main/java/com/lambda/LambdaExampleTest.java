package com.lambda;

import com.lambda.util.Utils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LambdaExampleTest {

    public static void main(String[] arg) throws InterruptedException {

        Utils.println("=====用lambda表达式实现Runnable=====");
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Before Java8, too much code for too little to do");
            }
        }).start();

        //Java 8方式：
        new Thread(() -> System.out.println("In Java8, Lambda expression rocks !!")).start();
        Thread.sleep(1000);

        Utils.println("=====使用Java 8 lambda表达式进行事件处理=====");
        // Java 8之前：
        JButton show = new JButton("Show");
        show.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Event handling without lambda expression is boring");
            }
        });

        // Java 8方式：
        show.addActionListener((e) ->
        {
            System.out.println("Light, Camera, Action !! Lambda expressions Rocks");
        });

        Utils.println("=====使用lambda表达式对列表进行迭代======");
        Utils.println(" Java 8之前");
        List<String> features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
        for (String feature : features) {
            System.out.print(feature + "|");
        }

        Utils.println(" Java 8之后");
        features.forEach(n -> System.out.print(n + "|"));

        Utils.println("使用Java 8的方法引用更方便，方法引用由::双冒号操作符标示");
        features.forEach(System.out::print);


        Utils.println("====使用lambda表达式和函数式接口Predicate====");
        List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
        System.out.println("Languages which starts with J :");
        filter(languages, (str) -> ((String) str).startsWith("J"));
        System.out.println("Languages which ends with a ");
        filter(languages, (str) -> str.endsWith("a"));

        System.out.println("Print all languages :");
        filter(languages, (str) -> true);
        System.out.println("Print no language : ");
        filter(languages, (str) -> false);

        System.out.println("Print language whose length greater than 4:");
        filter(languages, (str) -> str.length() > 4);

        Utils.println("====如何在lambda表达式中加入Predicate====");
        /*
        甚至可以用and()、or()和xor()逻辑函数来合并Predicate，
        例如要找到所有以J开始，长度为四个字母的名字，你可以合并两个Predicate并传入
        */
        Predicate<String> startsWithJ = (n) -> n.startsWith("J");
        Predicate<String> fourLetterLong = (n) -> n.length() == 4;
        languages.stream()
                .filter(startsWithJ.and(fourLetterLong))
                .forEach(System.out::print);

        Utils.println("==== Java 8中使用lambda表达式的Map和Reduce示例====");
        // 不使用lambda表达式为每个订单加上12%的税
        List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
        for (Integer cost : costBeforeTax) {
            double price = cost + .12 * cost;
            System.out.println(price);
        }

        // 使用lambda表达式
        List<Integer> costBeforeTax2 = Arrays.asList(100, 200, 300, 400, 500);
        // List<Double>  list= costBeforeTax2.stream().map((cost)->cost+0.12*cost).collect(Collectors.toList());
        costBeforeTax2.stream().map((cost) -> cost + .12 * cost).forEach(System.out::println);


        Utils.println("====Java 8中使用lambda表达式的Map和Reduce示例====");
        // 为每个订单加上12%的税,老方法：
        List<Integer> costBeforeTaxs = Arrays.asList(100, 200, 300, 400, 500);
        double total = 0;
        for (Integer cost : costBeforeTaxs) {
            double price = cost + .12 * cost;
            total = total + price;
        }
        System.out.println("Total : " + total);
        // 新方法：
        List<Integer> costBeforeTaxs2 = Arrays.asList(100, 200, 300, 400, 500);
        double bill = costBeforeTaxs2.stream().map((cost) -> cost + .12 * cost).reduce((sum, cost) -> sum + cost).get();
        System.out.println("Total : " + bill);

        Utils.println("====复制不同的值，创建一个子列表,用流的 distinct() 方法来对集合进行去重====");
        List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
        System.out.printf("Original List : %s", numbers);
        List<Integer> distinct = numbers.stream().map( i -> i*i).distinct().collect(Collectors.toList());
        System.out.printf(" Square Without duplicates : %s", distinct);

        Utils.println("====计算集合元素的最大值、最小值、总和以及平均值====");
        //获取数字的个数、最小值、最大值、总和以及平均值
        List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
        IntSummaryStatistics stats = primes.stream().mapToInt((x) -> x).summaryStatistics();
        System.out.println("Highest prime number in List : " + stats.getMax());
        System.out.println("Lowest prime number in List : " + stats.getMin());
        System.out.println("Sum of all prime numbers : " + stats.getSum());
        System.out.println("Average of all prime numbers : " + stats.getAverage());
    }


    //Java 8也添加了一个包，叫做 java.util.function。它包含了很多类，用来支持Java的函数式编程。其中一个便是Predicate
    public static void filter(List<String> names, Predicate<String> condition) {
        /*
        for (String name : names) {
            if (condition.test(name)) {
                System.out.print(name + " ");
            }
        }
        System.out.println();
        */

        System.out.print("<To Lambda>");
        names.stream().filter(name -> (condition.test(name))).forEach(System.out::print);
        System.out.println();
    }
}


