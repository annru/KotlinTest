package com.example.kotlintest;

import com.orhanobut.logger.Logger;

import java.math.BigDecimal;

public class Test0418 {

    public static void main(String[] args) {
        System.out.println(generateTempeautre());
        System.out.println(generateTempeautre());
        System.out.println(generateTempeautre());
        System.out.println(generateTempeautre());
        System.out.println(generateTempeautre());
        System.out.println(generateTempeautre());
        System.out.println(generateTempeautre());
        System.out.println(generateTempeautre());
        System.out.println(generateTempeautre());
        System.out.println(generateTempeautre());
        System.out.println(generateTempeautre());
        System.out.println(generateTempeautre());
        System.out.println(generateTempeautre());
        System.out.println(generateTempeautre());
        System.out.println(generateTempeautre());
        System.out.println(generateTempeautre());
        System.out.println(generateTempeautre());
        System.out.println(generateTempeautre());
        System.out.println(generateTempeautre());
    }

    public static double generateTempeautre() {
//        double Max = 36.5, Min = 30;
        double Max = 37, Min = 36.1;
        BigDecimal bd = new BigDecimal(Math.random() * (Max - Min) + Min);
        BigDecimal value = bd.setScale(1, BigDecimal.ROUND_HALF_UP);// 保留1位小数并四舍五入

        Logger.i("value==" + value + "====" + value.doubleValue());
        return value.doubleValue();
    }

}



