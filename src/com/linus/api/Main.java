package com.linus.api;

import com.linus.api.enums.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        NavigationOfConsumer.select(sc);
//        NavigationOfSupplier.select(sc);
        String stringFlag2 = NavigationOfFunction.select(sc);
        while(!stringFlag2.equals("x"));
//        NavigationOfPredicate.select(sc);
//        while(Navigation.select(sc));
    }
}
