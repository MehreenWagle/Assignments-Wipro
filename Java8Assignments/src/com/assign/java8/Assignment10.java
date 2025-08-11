package com.assign.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Assignment10 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Alice", "Bob", "Charlie");
        Map<String, Long> freqMap = names.stream()
                .collect(Collectors.groupingBy(name -> name, Collectors.counting()));
        System.out.println(freqMap);  
        }
}
