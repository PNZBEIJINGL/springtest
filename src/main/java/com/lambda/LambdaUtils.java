package com.lambda;

import java.util.Arrays;
import java.util.List;

public class LambdaUtils {

    public static void main(String[] arg){

    }

    //并行求和
    public static int  addIntegers(List<Integer> values){
        return values.parallelStream().mapToInt(i->i).sum();
    }

    //并行初始化数组
    public static double[] imperativeInitilize(int size){
        double[] values=new double[size];
        Arrays.parallelSetAll(values,i->i);
        return values;
    }
}
