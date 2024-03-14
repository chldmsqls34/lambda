package com.linus.api.enums;

import com.linus.api.account.AccountView;
import com.linus.api.article.ArticleView;
import com.linus.api.board.BoardView;
import com.linus.api.crawler.CrawlerView;
import com.linus.api.user.UserView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Stream;

public enum NavigationOfFunction {
    Exit("exit",i->"x"),
    User("User",i-> {
        try {
            UserView.main(i);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "";
    }),
    Board("Board",i-> {BoardView.main(i);
    return "";}),
    Account("Account",i->{AccountView.main(i);
    return "";}),
    Crawler("Crawler",i-> {
        try {
            CrawlerView.main(i);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "";
    }),
    Article("Article",i-> {
        try {
            ArticleView.main(i);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "";
    }),
    ERROR("error", i-> {
        System.out.println("ERROR 유효하지 않는 문자입니다.");
        return "";
    });


    private final String name;
    private final Function<Scanner,String> function;

    NavigationOfFunction(String name, Function<Scanner, String> function) {
        this.name = name;
        this.function = function;
    }


    public static String select(Scanner sc) {
        System.out.println("\n === x-Exit +" +
                "u-User " +
                "b-Board " +
                "m-Account " +
                "c-Crawler " +
                "a-Articles" +
                "===");
        String Menu = sc.next();
        return Stream.of(values())
                .filter(i->i.name.equals(Menu))
                .findAny()
                .orElseGet(()->Exit)
                .function.apply(sc);

    }
}
