package com.lambda.refactoring.order;

import java.util.ArrayList;
import java.util.List;

public class Macro {
    //包含操作序列的宏，可以按照顺序执行
    private final List<IAction> actions;

    public  Macro(){
        actions=new ArrayList<IAction>();
    }

    public void record(IAction action){
        actions.add(action);
    }

    public void run(){
        actions.forEach(IAction::perform);
    }

}
