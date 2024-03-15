package com.linus.api.board;

import lombok.Getter;

public class BoardController {
    @Getter
    private static BoardController instance = new BoardController();
    BoardService service;

    public BoardController() {
        this.service = BoardServiceImpl.getInstance();
    }

}
