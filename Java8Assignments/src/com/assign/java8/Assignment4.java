package com.assign.java8;

interface Power {
    int power(int base, int exponent);

    default void showDefault() {
        System.out.println("Default method called");
    }
}

public class Assignment4 implements Power {
    public int power(int base, int exponent) {
        return (int) Math.pow(base, exponent);
    }

    public static void main(String[] args) {
        Assignment4 dp = new Assignment4();
        System.out.println(dp.power(2, 3));  // 8
        dp.showDefault();
    }
}

