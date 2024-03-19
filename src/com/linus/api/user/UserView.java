package com.linus.api.user;

import com.linus.api.enums.UserRouter;
import lombok.RequiredArgsConstructor;

import java.sql.SQLException;
import java.util.Scanner;
@RequiredArgsConstructor
public class UserView {
    private static UserRouter router;
    public static void main(Scanner sc) throws SQLException {
       =
        while(router.selectUser(sc));

    }
}
