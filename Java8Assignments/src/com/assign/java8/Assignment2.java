package com.assign.java8;

import java.util.Optional;

public class Assignment2 {
    public static Optional<Double> divide(double numerator, double denominator) {
        if (denominator == 0) {
            return Optional.empty();
        }
        return Optional.of(numerator / denominator);
    }

    public static void main(String[] args) {
        System.out.println(divide(10, 2).orElse(Double.NaN));    // 5.0
        System.out.println(divide(10, 0).orElseGet(() -> Double.NaN)); // NaN
    }
}
