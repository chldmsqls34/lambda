package account;

import java.util.Scanner;

public class AccountView {
    public static void main(Scanner sc) {
        AccountController accountController = new AccountController();
        while(true){
            switch (sc.next()){
                case "0" :
                    return;
                case "1" :
                    System.out.println("create account");
                    System.out.println(accountController.createAccount(sc));
                    break;
                case "2" :
                    System.out.println("deposit");
                    System.out.println(accountController.deposit(sc));
                    break;
                case "3" :
                    System.out.println("withdraw");
                    System.out.println(accountController.withdraw(sc));
                    break;
                case "4" :
                    System.out.println("getBalance");
                    System.out.println(accountController.getBalance(sc));
                    break;
                case "5" :
                    System.out.println("cancel account");
                    System.out.println(accountController.deleteAccount(sc));
                case"6" :
                    System.out.println("account list");
                    accountController.getAccounts().forEach((i)->{
                        System.out.println(i);
                    });
            }
        }

    }
}
