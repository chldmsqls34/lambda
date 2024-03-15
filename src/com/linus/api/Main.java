package com.linus.api;

import com.linus.api.enums.*;
import com.linus.api.menu.MenuController;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        MenuController.getInstance().removeMenuTable();
        MenuController.getInstance().makeMenuTable();
        while(Navigation.select(sc));
//        Messenger msg = MenuController.getInstance().retuenMessenger();
////        Menu oneMenu = MenuController.getInstance().returnOneMenu();
////        List<?> allMenu = MenuController.getInstance().returnAllMenus();
//
//        List<?> ls = MenuController.getInstance().makeFoobar();

//        MenuController.getInstance().insertMenus();
//        System.out.println(MenuController.getInstance().getMenusByCategory(sc.next()));


//        MenuController.getInstance().insertMenus();
//        Scanner sc = new Scanner(System.in);
////        NavigationOfConsumer.select(sc);
////        NavigationOfSupplier.select(sc);
//        String stringFlag2 = NavigationOfFunction.select(sc);
//        while(!stringFlag2.equals("x"));
//
//        while(NavigationOfPredicate.select(sc));

    }
}
