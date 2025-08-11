package com.assign.java8;

import java.util.Arrays;
import java.util.List;

public class Assignment12 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Charlie", "Bob", "Alice");
        names.sort(String::compareToIgnoreCase);
        System.out.println(names);  // [Alice, Bob, Charlie]
    }
}
