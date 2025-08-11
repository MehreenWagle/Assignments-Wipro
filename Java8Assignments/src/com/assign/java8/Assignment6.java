package com.assign.java8;

import java.util.Arrays;
import java.util.List;

public class Assignment6 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jonathan", "Amy", "Steve", "Alexandra");
        long count = names.stream()
                .filter(name -> name.length() > 5)
                .count();
        System.out.println(count);  // 2
    }
}
