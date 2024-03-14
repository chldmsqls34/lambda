package com.linus.api.grade;



import com.linus.api.enums.GradeRouter;



import java.util.Scanner;

public class GradeView {
    public static void main(Scanner sc) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("점수를 입력하세요: ");
        int score = scanner.nextInt();
        GradeRouter.gradeCheck(score);

    }
}
