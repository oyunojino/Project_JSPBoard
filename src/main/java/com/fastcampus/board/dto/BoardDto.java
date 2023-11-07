package com.fastcampus.board.dto;

import lombok.*;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BoardDto {
    private int title;
    private String writer;
    private String content;
}
