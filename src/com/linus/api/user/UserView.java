package com.linus.api.user;

import com.linus.api.enums.UserRouter;

import java.sql.SQLException;
import java.util.Scanner;

public class UserView {
    public static void main(Scanner sc) throws SQLException {
        UserController.getInstance().deleteUsers();
        UserController.getInstance().createUsers();
        while(UserRouter.selectUser(sc));

    }
}
