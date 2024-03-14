package com.linus.api.strategy;

import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Stream;

public enum WeekendStrategy {
    Monday("1",i->"Monday"),
    Tuesday("1",i->"Monday"),
    Wednesday("1",i->"Monday"),
    Thursday("1",i->"Monday"),
    Friday("1",i->"Monday"),
    Saturday("1",i->"Monday"),
    Sunday("1",i->"Monday"),
    Wrong("x",i->"Wrong");

    private final String name;
    private final Function<String, String> funciton;

    WeekendStrategy(String name, Function<String, String> funciton) {
        this.name = name;
        this.funciton = funciton;
    }


    public static String execute(Scanner sc) {
        System.out.println("1~7 입력: ");
        String s = sc.next();
        return Stream.of(values())
                .filter(i->i.name.equals(s))
                .findAny().orElseGet(()->null)
                .funciton.apply(s);

    }
}
