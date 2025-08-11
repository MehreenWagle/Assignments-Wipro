package com.assign.java8;
import java.util.Arrays;
import java.util.Scanner;

public class Assignment1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] names = new String[5];

        System.out.println("Enter 5 names:");
        for (int i = 0; i < 5; i++) {
            names[i] = scanner.nextLine();
        }

        // Sort using lambda expression comparator (alphabetical order)
        Arrays.sort(names, (a, b) -> a.compareToIgnoreCase(b));

        System.out.println("\nSorted names:");
        for (String name : names) {
            System.out.println(name);
        }

        scanner.close();
    }
}


