package com.linus.api.enums;
import com.linus.api.account.AccountView;
import com.linus.api.board.BoardView;
import com.linus.api.grade.GradeView;
import com.linus.api.kaup.KaupView;
import com.linus.api.user.UserView;


import java.sql.SQLException;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Stream;

public enum Navigation {
    EXIT("e", i -> {
        System.out.println("EXIT");
        return false;
    }),
    USER("u", i -> {
        try {
            UserView.main(i);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }),
    GRADE("g", i -> {
        GradeView.main(i);
        return true;
    }),
    BOARD("b", i -> {
        BoardView.main();
        return true;
    }),
    KAUP("k", i -> {
        KaupView.main(i);
        return true;
    }),
    ACCOUNT("ac", i -> {
        AccountView.main(i);
        return true;
    }),
    NAVIGATION_ERROR("navigation_error", i -> {
        System.out.println("Wrong Input");
        return true;
    });

    private final String name;
    private final Predicate<Scanner> predicate;

    Navigation(String name, Predicate<Scanner> predicate) {
        this.name = name;
        this.predicate = predicate;
    }

    public static Boolean navigate(Scanner sc) {
        System.out.println("x-Exit, user-U, grade-G, board-B, kaup-K, account-Ac");
        return Stream.of(values()).filter(i -> i.name.equals(sc.next()))
                .findAny().orElse(NAVIGATION_ERROR).predicate.test(sc);
    }
}
