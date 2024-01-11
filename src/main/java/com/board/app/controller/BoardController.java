package com.board.app.controller;

import com.board.app.dto.BoardDto;
import com.board.app.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class BoardController {

    private final BoardService service;

    //홈에서 게시판 들어가는 부분
    @GetMapping("/")
    public String home() {
        return "home";
    }

    //게시판 전체조회
    @GetMapping("/listAll")
    public String listAll(Model model) {
        List<BoardDto> boardList = service.getAllBoard();
        model.addAttribute("list", boardList);
        return "listAll";
    }

  //listAll 페이지의 title을 눌렀을때 이동할 url 지정, read로 넘길 파라미터 지정 그리고 모델에 담은 후 read로 넘김
  @GetMapping("/read")
  public String readPage(@RequestParam("bno")int bno, Model model) {
      model.addAttribute("board", service.readBoard(bno));
      // read.html 템플릿을 찾아 렌더링
      return "read";
  }


}
