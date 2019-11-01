package ru.test.task.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResultDto {
    private int result;
    private List<ValidationErrorDto> errors;
}
