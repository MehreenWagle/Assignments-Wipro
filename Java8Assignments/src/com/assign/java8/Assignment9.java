package com.assign.java8;

import java.util.Arrays;
import java.util.List;

public class Assignment9 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        numbers.parallelStream()
                .map(n -> n * n)
                .forEach(System.out::println);
    }
}
