package com.fastcampus.board;

import com.fastcampus.board.dto.BoardDto;
import com.fastcampus.board.dto.PostDto;
import com.fastcampus.board.entity.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @RequestMapping(value="/save",method = RequestMethod.POST)
    public String createPost(Board board){
        System.out.println("board " + board);
        checkBoard(board);
        boardService.save(board);
        return "redirect:/"; // 추가 후 홈 화면으로
    }

    @RequestMapping("/")
    public String ReadAllPost(Model model){
        List<Board> boardList = boardService.list();
        System.out.println("boardList : " + boardList);
        model.addAttribute("boardList", boardList);
        return "index";
    }

    @RequestMapping(value="/update",method = RequestMethod.POST)
    public String updatePost(@ModelAttribute("board") Board board){
        System.out.println("board " + board);
        checkBoard(board);
        boardService.update(board);
        return "redirect:/";
    }

    @RequestMapping(value="/delete/{id}",method = RequestMethod.GET)
    public String deletePost(@PathVariable int id){
        System.out.println("삭제 ID :  " + id);
        boardService.remove(id);
        return "redirect:/";
    }

    private void checkBoard(Board board){
        if(board.getTitle().isEmpty() || board.getContent().isEmpty() || board.getWriter().isEmpty()) {
            throw new RuntimeException("값을 입력해주세요.");
        }
    }

    @RequestMapping(value="/createView")
    public String ViewCreate(Model model){
        model.addAttribute("command", new Board());
        return "create";
    }

    @RequestMapping(value="/readView/{seq}")
    public String ViewRead(@PathVariable long seq, Model model){
        boardService.updateCnt(seq);
        model.addAttribute("board", boardService.read(seq));
        return "read";
    }

    @RequestMapping(value="/updateView/{seq}")
    public String ViewUpdate(@PathVariable long seq, Model model){
        model.addAttribute("command", boardService.read(seq));
        return "update";
    }
}

