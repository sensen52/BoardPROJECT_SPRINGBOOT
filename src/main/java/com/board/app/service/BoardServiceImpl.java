package com.board.app.service;

import com.board.app.dto.BoardDto;
import com.board.app.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardMapper boardMapper;


    @Override
    public void createBoard(BoardDto boardDto) {

        boardMapper.create(boardDto);

    }

    @Override
    public BoardDto readBoard(int bno) {
        return boardMapper.read(bno);
    }

    @Override
    public void updateBoard(BoardDto boardDto) {
       boardMapper.update(boardDto);
    }

    @Override
    public void deleteBoard(int bno) {
        boardMapper.delete(bno);

    }

    @Override
    public List<BoardDto> getAllBoard() {
        return boardMapper.selectAll();
    }
}
