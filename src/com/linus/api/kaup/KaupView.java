package com.linus.api.kaup;



import com.linus.api.common.UtilService;
import com.linus.api.common.UtilServiceImpl;
import com.linus.api.user.User;

import java.util.Scanner;

public class KaupView {
    public static void main(Scanner sc) {
        UtilService util = UtilServiceImpl.getInstance();
        User person = User.builder()
                .height(util.createRandomDouble(150,50))
                .weight(util.createRandomDouble(30,70))
                .build();

        KaupService kaup = KaupServiceImpl.getInstance();

        double bmi = kaup.createBMI(person);
        String bodyMass =kaup.creatBodyMass(bmi);

        System.out.printf("---계산기---\n " +
                        "BMI는 %s 입니다\n " +
                        "체질량은 %s 입니다\n",
                bmi,bodyMass);

    }

//카우프지수 구하는 프로그램을 객체지향으로 작성해주세요



}
