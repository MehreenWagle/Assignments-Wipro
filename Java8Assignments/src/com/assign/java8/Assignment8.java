package com.assign.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Assignment8 {
    public static void main(String[] args) {
        List<String> cities = Arrays.asList("Paris", "London", "Berlin");
        String joined = cities.stream()
                .collect(Collectors.joining(", "));
        System.out.println(joined);  // Paris, London, Berlin
    }
}
