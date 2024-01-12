package com.board.app.controller;

import com.board.app.dto.BoardDto;
import com.board.app.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
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
    public String readPage(@RequestParam("bno") int bno, Model model) {
        model.addAttribute("board", service.readBoard(bno));
        // read.html 템플릿을 찾아 렌더링
        return "read";
    }

    //삭제
    @PostMapping("/delete")
    public String deletePage(@RequestParam("bno") int bno) {
        service.deleteBoard(bno);
        log.info(String.valueOf(bno));
        return "redirect:/listAll";
    }

    //수정 버튼을 눌렀을때, 해당 bno에 맞는 수정페이지로 이동
    @GetMapping("/modify")
    public String getModifyPage(@RequestParam("bno") int bno, Model model) {
        model.addAttribute("board", service.readBoard(bno));
        return "modify";
    }

    //수정완료 후
    @PostMapping("/modify")
    public String postModifyPage(Model model,BoardDto boardDto){
        service.updateBoard(boardDto);
        return "redirect:/listAll";
    }

    @GetMapping("/regist")
    public String getRegistPage(){
        return "/regist";
    }

    @PostMapping("/regist")
    public String createBoardPage(@ModelAttribute BoardDto boardDto) {
        service.createBoard(boardDto);
        return "redirect:/listAll";
    }
}
