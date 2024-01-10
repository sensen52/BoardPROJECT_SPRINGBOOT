package com.board.app.service;

//mapper
import com.board.app.dto.BoardDto;

import java.util.List;

//비즈니스 로직에 집중하기 위해 인터페이스 정의
//mapper가 CRUD라면 service 인터페이스는 거기서 비즈니스 로직을 수행 할수 있다는 것.
public interface BoardService {

     //게시물생성(create)
    void createBoard(BoardDto boardDto);

     //게시물조회(read)
    BoardDto readBoard(int bno);

     //게시물수정(update)
    void updateBoard(BoardDto boardDto);

     //게시물삭제(delete)
    void deleteBoard(int bno);

     //모든 게시물 조회(selectAll)
    List<BoardDto> getAllBoard();

}
