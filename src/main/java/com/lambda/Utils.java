package com.lambda;

import java.util.Collection;

public class Utils {
    public static void println(Collection collections){
        System.out.println();
        for (Object co:collections) {
            System.out.print(co+"|");
        }
    }
    public static void println(Object object){
        System.out.print(object);
    }
}
