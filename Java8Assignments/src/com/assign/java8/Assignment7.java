package com.assign.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Assignment7 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> evens = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(evens);  // [2, 4, 6]
    }
}

