package com.lambda.util;

import java.util.Collection;

public class Utils {
    public static void println(Collection collections){
        System.out.println("Collection is：");
        for (Object co:collections) {
            System.out.println(co);
        }
    }
    public static void println(Object object){
        System.out.println("Object is：");
        System.out.println(object);
    }
}
