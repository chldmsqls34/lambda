package com.linus.api.enums;

import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Stream;

public enum GradeRouter {
    A(90, i -> {
        System.out.println("A");
        return true;
    }),
    B(80, i -> {
        System.out.println("B");
        return true;
    }),
    C(70, i -> {
        System.out.println("C");
        return true;
    }),
    D(60, i -> {
        System.out.println("D");
        return true;
    }),
    E(50, i -> {
        System.out.println("E");
        return true;
    }),
    F(0, i -> {
        System.out.println("F");
        return true;
    }),
    ERROR(-1, i -> {
        System.out.println("다시 입력해주세요");
        return false;
    });

    private final int minScore;
    private final Predicate<Integer> predicate;

    GradeRouter(int minScore, Predicate<Integer> predicate) {
        this.minScore = minScore;
        this.predicate = predicate;
    }

    public static boolean gradeCheck(int score) {
        return Stream.of(values())
                .filter(i -> score >= i.minScore)
                .findFirst()
                .orElse(ERROR)
                .predicate.test(score);
    }


}

//    public static String getGrade(int score){
//        return getScore(score/10)+"";
//    }
//    public static com.linus.api.grade.Grade getScore(int num){
//        return Stream.of(values())
//                .filter(o -> o.score== num )
//                .findFirst().orElseThrow(() -> new IllegalArgumentException("올바른 값이 아닙니다."));
//    }
