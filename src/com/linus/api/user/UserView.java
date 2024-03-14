package com.linus.api.user;

import com.linus.api.enums.UserRouter;

import java.sql.SQLException;
import java.util.Scanner;

public class UserView {
    public static void main(Scanner sc) throws SQLException {
        while(UserRouter.selectUser(sc));

    }
}
