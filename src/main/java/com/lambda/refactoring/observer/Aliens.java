package com.lambda.refactoring.observer;

public class Aliens implements LandingObserver {

    @Override
    public void observerLading(String name) {
        if(name.contains("Apollo")){
            System.out.println("They are distracted,Lets invade earth!");
        }
    }
}
