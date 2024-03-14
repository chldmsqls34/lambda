package com.linus.api.enums;


import com.linus.api.user.UserController;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Stream;


public enum UserRouter {
    EXIT("exit", sc ->  {
        System.out.println("EXIT");
        return false;
    }),
    JOIN("join", sc -> {
        UserController.getInstance().save(sc);
        return true;
    }),
    LOGIN("login",sc->{
        UserController.getInstance().login(sc);
        return true;
    }),
    IDSEARCH("idsearch",sc->{
        UserController.getInstance().findById(sc);
        return true;
    }),
    PASSWORDCHANGE("passwordchange",sc->{
        UserController.getInstance().updatePassword(sc);
        return true;
    }),
    DELETE("delete",sc->{
        UserController.getInstance().delete(sc);
        return true;
    }

    ),
    USERLIST("userlist",sc->{
        List<?> users = null;
        try {
            users = UserController.getInstance().findUsers();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        users.forEach(i -> System.out.println(i));
        return true;
    }),
    NAMESEARCH("namesearch",sc->{
        UserController.getInstance().findUsersByName(sc);
        return true;
    }),
    JOBSEARCH("jobsearch",sc->{
        UserController.getInstance().findUsersByJob(sc);
        return true;
    }),
    USERCOUNT("count",sc->{
        UserController.getInstance().count();
        return true;
    }),
    TABLECREATE("tablecreate",sc->{
        try {
            UserController.getInstance().createUsers();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }),
    TABLEDELETE("tabledelete",sc->{
        try {
            UserController.getInstance().deleteUsers();
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


    UserRouter(String name, Predicate<Scanner> predicate) {
        this.name = name;
        this.predicate = predicate;
    }

    public static boolean selectUser(Scanner sc) {
        System.out.println("[사용자메뉴] 0-종료\n " +
                "1-회원가입\n " +
                "2-로그인\n " +
                "3-ID검색\n " +
                "4-비번변경\n" +
                "5-탈퇴\n " +
                "6-회원목록\n " +
                "7-이름검색\n" +
                "8-직업검색\n" +
                "9-회원수" +
                "touch-테이블생성\n" +
                "rm-테이블삭제\n");
        String msg = sc.next();
        return Stream.of(values())
                .filter(i->i.name.equals(msg))
                .findAny()
                .orElseGet(()->ERROR)
                .predicate.test(sc);
    }


}
