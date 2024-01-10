package com.board.app.controller;

import com.board.app.dto.BoardDto;
import com.board.app.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class BoardController {

    private final BoardService service;

    @GetMapping("/listAll")
    public String home(Model model){
        List<BoardDto> boardList = service.getAllBoard();
        model.addAttribute("list",boardList);
        return "listAll";
    }


}
