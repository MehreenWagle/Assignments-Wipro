package com.assign.java8;

@FunctionalInterface
interface MessagePrinter {
    void print(String message);
}

public class Assignment3 {
    public static void greet(String message, MessagePrinter printer) {
        printer.print(message);
    }

    public static void main(String[] args) {
        greet("Hello, World!", msg -> System.out.println(msg));
    }
}
