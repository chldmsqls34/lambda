package com.linus.api.enums;


import com.linus.api.menu.MenuController;
import com.linus.api.user.UserController;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Stream;
@RequiredArgsConstructor
private final UserController controller;

public enum UserRouter {

    EXIT("exit", sc ->  {
        System.out.println("EXIT");
        return false;
    }),
    JOIN("join", sc -> {
        controller.save(sc);
        return true;
    }),
    LOGIN("login",sc->{
        controller.login(sc);
        return true;
    }),
    IDSEARCH("idsearch",sc->{
        controller.findById(sc);
        return true;
    }),
    PASSWORDCHANGE("passwordchange",sc->{
        controller.updatePassword(sc);
        return true;
    }),
    DELETE("delete",sc->{
        controller.delete(sc);
        return true;
    }

    ),
    USERLIST("userlist",sc->{
        List<?> users = null;
        try {
            users = controller.findUsers();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        users.forEach(i -> System.out.println(i));
        return true;
    }),
    NAMESEARCH("namesearch",sc->{
        controller.findUsersByName(sc);
        return true;
    }),
    JOBSEARCH("jobsearch",sc->{
        controller.findUsersByJob(sc);
        return true;
    }),
    USERCOUNT("count",sc->{
        controller.count();
        return true;
    }),
    TABLECREATE("tablecreate",sc->{
        try {
            controller.createUsers();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }),
    TABLEDELETE("tabledelete",sc->{
        try {
            controller.deleteUsers();
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
        MenuController.getInstance().printMenusByCategory("user");
        String str = sc.next();
        return Stream.of(values()).filter(i -> i.name.equals(str))
                .findAny().orElse(ERROR).predicate.test(sc);
    }

}
