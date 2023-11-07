package com.fastcampus.board;

import com.fastcampus.board.dto.BoardDto;
import com.fastcampus.board.entity.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public void save(Board board) {
        boardRepository.save(board);
    }

    public List<Board> list() {
        return (List<Board>) boardRepository.findAll();
    }

    public Board read(long seq) {
        return boardRepository.findById(seq).orElseThrow(() -> new RuntimeException("not found"));
    }

    public void update(Board updateBoard) {
        boardRepository.findById(updateBoard.getSeq())
                    .ifPresent(board -> {
                        board.setContent(updateBoard.getContent());
                        board.setTitle(updateBoard.getTitle());
                        board.setWriter(updateBoard.getWriter());
                        boardRepository.save(board);
                    });
    }

    public void updateCnt(long seq) {
        boardRepository.findById(seq)
                       .ifPresent(board -> {
                           board.setCnt(board.getCnt() + 1);
                           boardRepository.save(board);
                       });
    }

    public void remove(long seq) {
        boardRepository.deleteById(seq);
    }
}
