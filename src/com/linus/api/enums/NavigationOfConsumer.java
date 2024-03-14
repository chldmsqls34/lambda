package com.linus.api.enums;

import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

public enum NavigationOfConsumer {
    Exit("exit",i-> System.out.println()),
    User("User",i-> System.out.println()),
    Board("Board",i-> System.out.println()),
    Account("Account",i-> System.out.println()),
    Crawler("Crawler",i-> System.out.println()),
    Article("Article",i-> System.out.println())
    ;
    private final String name;
    private final Consumer<String> consumer;

    NavigationOfConsumer(String name, Consumer<String> consumer) {
        this.name = name;
        this.consumer = consumer;
    }

    public static void select(Scanner sc) {
        System.out.println("\n === x-Exit +" +
                "u-User " +
                "b-Board " +
                "m-Account " +
                "c-Crawler " +
                "a-Articles" +
                "===");

    }
}
