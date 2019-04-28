package com.lambda.refactoring.observer;

import java.util.ArrayList;
import java.util.List;

public class Moon {
    private final List<LandingObserver> observerList=new ArrayList<LandingObserver>();

    public void land(String name){
        for (LandingObserver observer:observerList){
            observer.observerLading(name);
        }
    }

    public void startSpying(LandingObserver observer){
        observerList.add(observer);
    }
}
