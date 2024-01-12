package com.board.app.dto;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/*@NoArgsConstructor //파라미터가 없는 기본 생성자 생성
@AllArgsConstructor //모든 필드값을 파라미터 값으로 받는 생성자 생성*/

@Getter
@Setter
public class BoardDto {

    private int bno;
    private  String title;
    private String content;
    private String writer;
    private Date regdate;
    private int viewcnt;



}
