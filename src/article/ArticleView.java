package article;

import user.UserController;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ArticleView {
    public static void main(Scanner sc) throws SQLException {
        ArticleController articleController = new ArticleController();

        while(true) {
            System.out.println("[사용자메뉴] 0-종료\n " +
                    "1-\n ");
            switch (sc.next()) {
                case "0":
                    System.out.println("종료");
                    return;
                case "1":
                    articleController.findUsers().forEach(i-> System.out.println(i));

                    break;
            }
        }


    }
}
