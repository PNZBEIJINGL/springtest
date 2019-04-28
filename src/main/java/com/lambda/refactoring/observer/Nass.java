package com.lambda.refactoring.observer;

public class Nass implements LandingObserver{

    @Override
    public void observerLading(String name) {
        if(name.contains("Apollo")){
            System.out.println("We made it!");
        }else{
            System.out.println("What is it");
        }
    }
}
