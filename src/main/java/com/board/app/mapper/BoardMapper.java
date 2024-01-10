package com.board.app.mapper;

import com.board.app.dto.BoardDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

// Mapper인터페이스: sql쿼리를 호출하는 자바 메서드를 선언, Mybatis는 이를 통해 특정 쿼리와 연결해 실행한다.
@Mapper
public interface BoardMapper {

   //게시물 생성(Create)
   void create(BoardDto boardDto);
   
   //게시물 조회(Read)
   BoardDto read(int bno);

   //게시물 수정(Update)
   void update(BoardDto boardDto);
   
   //게시물 삭제
   void delete(int bno);
   
   //모든 게시물 조회
   List<BoardDto> selectAll();

}
