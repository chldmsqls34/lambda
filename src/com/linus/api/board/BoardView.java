package com.linus.api.board;

import com.linus.api.common.UtilService;
import com.linus.api.common.UtilServiceImpl;
import com.linus.api.user.UserController;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BoardView {
    public static void main(Scanner sc) {
        BoardController.getInstance().deleteBoards();
        BoardController.getInstance().createBoards();

//        List<Board> articles = new ArrayList<>();
//        UtilService util = UtilServiceImpl.getInstance();
//
//        for (int i=0;i<5;i++){
//            articles. add(Board.builder()
//                    .boardName(util.createRandomTitle())
//                    .boardType(util.createRandomContent())
//                    .build());
//        }
//        //forEach 사용 예시
//        articles.forEach(i->{
//            System.out.println(i.toString());
//        });

//        //향상된 for문으로 모든 객체를 하나씩 가져오기
//        for(BoardDto b:articles){
//            System.out.println(b.getTitle()+"\t"+b.getContent()+"\t"+b.getWriter());
//        }


    }
}
