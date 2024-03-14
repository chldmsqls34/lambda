package com.linus.api;

import com.linus.api.account.AccountView;
import com.linus.api.article.ArticleView;
import com.linus.api.board.BoardView;
import com.linus.api.enums.Navigation;
import com.linus.api.user.UserView;
import com.linus.api.crawler.CrawlerView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main{
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws IOException, SQLException {
        while(Navigation.navigate(sc));
    }

}