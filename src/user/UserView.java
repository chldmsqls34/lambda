package user;

import java.util.Scanner;

public class UserView {
    public static void main(Scanner sc) {
        UserController userController = new UserController();
        String msg = userController.addUsers();
        System.out.println(" addUsers 결과 : "+msg);
        while(true){
            System.out.println("[사용자메뉴] 0-종료\n " +
                    "1-회원가입\n " +
                    "2-로그인\n " +
                    "3-ID검색\n " +
                    "4-비번변경\n" +
                    "5-탈퇴\n " +
                    "6-회원목록\n " +
                    "7-이름검색\n" +
                    "8-직업검색\n" +
                    "9-회원수");
            switch (sc.next()){
                case "0":
                    System.out.println("종료");return;
                case "1":
                    System.out.println("1-회원가입");
                    System.out.println(userController.save(sc));
                    break;
                case "2":
                    System.out.println("2-로그인");
                    System.out.println(userController.login(sc));
                    break;
                case "3":
                    System.out.println("3-ID검색");
                    System.out.println(userController.findById(sc));
                    break;
                case "4":
                    System.out.println("4-비번변경");
                    System.out.println(userController.updatePassword(sc));
                    break;
                case "5":
                    System.out.println("5-탈퇴");
                    System.out.println(userController.delete(sc));
                    break;
                case "6":
                    System.out.println("6-회원목록");
                    System.out.println(userController.getOne(sc));
                    break;
                case "7":
                    System.out.println("7-이름검색");
                    System.out.println(userController.findUsersByName(sc));
                    break;
                case "8":
                    System.out.println("8-직업검색");
                    System.out.println(userController.findUsersByJob(sc));
                    break;
                case "9":
                    System.out.println("9-회원수");
                    System.out.println(userController.count());

                    break;

            }

        }

    }
}
