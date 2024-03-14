package com.linus.api.enums;

import java.util.Scanner;
import java.util.function.Supplier;
import java.util.stream.Stream;

public enum NavigationOfSupplier {;
//    Exit("exit", System.out.println(i)->{
//        return i;
//    }),
//    User("User",->),
//    Board("Board",i->""),
//    Account("Account",i->""),
//    Crawler("Crawler",i->""),
//    Article("Article",i->""),
//    ERROR("error", i-> {
//        System.out.println("ERROR 유효하지 않는 문자입니다.");
//        return "";
//    });

    private final String name;
    private final Supplier<String> supplier;


    NavigationOfSupplier(String name, Supplier<String> supplier) {
        this.name = name;
        this.supplier = supplier;
    }

    public static void select(Scanner sc) {
        System.out.println("\n === x-Exit +" +
                "u-User " +
                "b-Board " +
                "m-Account " +
                "c-Crawler " +
                "a-Articles" +
                "===");
        String str = sc.next();
        Stream.of(values())
                .filter(i->i.name.equals(str))
                .findAny()
                .orElseGet(()->null)
                .supplier.get();
    }
}
