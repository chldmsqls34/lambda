package com.linus.api.strategy;


import java.util.Scanner;

public class Weekend {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String day = WeekendStrategy.execute(sc);
        System.out.println("전략의겨로가: "+day);
    }
}








