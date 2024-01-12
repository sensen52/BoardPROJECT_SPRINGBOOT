package com.board.app;

import com.board.app.dto.BoardDto;
import com.board.app.mapper.BoardMapper;
import com.board.app.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Slf4j
public class BoardMapperTest {

    @Autowired
    private BoardMapper boardMapper;


//    @Test
//    @Transactional
//    public void createTest() {
//        BoardDto boardDto = new BoardDto();
//        boardDto.setBno(1);
//        boardDto.setTitle("테스트");
//        boardDto.setContent("테스트");
//        boardDto.setWriter("테스트");
//
//        boardMapper.create(boardDto);
//    }

    @Test
    public void select() {
        assertThat(boardMapper.read(4).getTitle()).isEqualTo("안녕하세요");
    }

    @Test
    public void deleteTest() {
        boardMapper.delete(4);
    }


}
