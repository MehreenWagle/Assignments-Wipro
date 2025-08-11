package com.assign.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Assignment11 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Anna", "Amanda", "Olivia", "Alma", "Sofia");

        Predicate<String> startsWithA = s -> s.startsWith("A");
        Predicate<String> endsWithA = s -> s.endsWith("a");

        List<String> filtered = names.stream()
                .filter(startsWithA.and(endsWithA))
                .collect(Collectors.toList());

        System.out.println(filtered);  // [Anna, Amanda, Alma]
    }
}
