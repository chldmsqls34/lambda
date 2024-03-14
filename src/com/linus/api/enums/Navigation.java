package com.linus.api.enums;

import com.linus.api.account.AccountView;
import com.linus.api.article.ArticleView;
import com.linus.api.board.BoardView;
import com.linus.api.crawler.CrawlerView;
import com.linus.api.user.UserView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Stream;

public enum Navigation {

    Exit("x", sc ->  {
        System.out.println("EXIT");
        return false;
    }),
    User("u", sc -> {
        try {
            UserView.main(sc);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }),
    Board("b", sc -> {
        System.out.println("Borad");
        BoardView.main();
        return true;
    }),

    Account("m", sc -> {
        System.out.println("Account");
        AccountView.main(sc);
        return true;
    }),
    Crawler("c", sc-> {
        try {
            CrawlerView.main(sc);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return true;
    }),

    Articles("a", sc -> {
        try {
            ArticleView.main(sc);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }),

    ERROR("error", sc-> {
        System.out.println("ERROR 유효하지 않는 문자입니다.");
        return true;
    });

    private final String name;
    private final Predicate<Scanner> predicate;

    Navigation(String name, Predicate<Scanner> predicate) {
        this.name = name;
        this.predicate = predicate;
    }
    public static boolean select(Scanner sc) {
        System.out.println("\n === x-Exit +" +
                "u-User " +
                "b-Board " +
                "m-Account " +
                "c-Crawler " +
                "a-Articles" +
                "===");
        String str = sc.next();
        return Stream.of(values())
                .filter(i -> i.name.equals(str))
                .findAny().orElse(ERROR).predicate.test(sc);
    }
}

