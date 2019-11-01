package ru.test.task.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChessBoard {
    private int height;
    private int width;
}
