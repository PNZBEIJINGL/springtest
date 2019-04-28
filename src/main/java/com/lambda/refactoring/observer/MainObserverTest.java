package com.lambda.refactoring.observer;

public class MainObserverTest {

    public static void main(String[] args){
        //test();

        testLambda();
    }

    //只为展示语言特性
    private static void testLambda() {
        Moon moon=new Moon();
        moon.startSpying(name -> {
            if(name.contains("Apollo")){
                System.out.println("They are distracted,Lets invade earth!");
            }
        });
        moon.startSpying(name -> {
            if(name.contains("Apollo")){
                System.out.println("We made it!");
            }else{
                System.out.println("What is it");
            }
        });

        moon.land("An asteroid");
        moon.land("Apollo 11");
    }

    private static void test() {
        Moon moon=new Moon();
        moon.startSpying(new Nass());
        moon.startSpying(new Aliens());

        moon.land("An asteroid");
        moon.land("Apollo 11");
    }

}
