package com.assign.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Assignment5 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Alex", "Charlie");
        List<String> filtered = names.stream()
                .filter(name -> name.startsWith("A"))
                .collect(Collectors.toList());
        System.out.println(filtered);  // [Alice, Alex]
    }
}

