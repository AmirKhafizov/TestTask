package ru.test.task.services;


import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import ru.test.task.application.Patterns;
import ru.test.task.dto.ResultDto;
import ru.test.task.dto.ValidationErrorDto;
import ru.test.task.models.Point;
import ru.test.task.utils.PointUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class MinPathService {

    public ResultDto findMinPathFromStartPointToEndPoint(String startPointStr, String endPointStr, int height, int width){

        List<ValidationErrorDto> errors = new ArrayList<>();
        if(!StringUtils.isBlank(startPointStr)){
            if(!Pattern.matches(Patterns.VALID_MOVE_REGEX, startPointStr)){
                errors.add(new ValidationErrorDto("Bad value of start point"));
            }
        }
        if(!StringUtils.isBlank(endPointStr)){
            if(!Pattern.matches(Patterns.VALID_MOVE_REGEX, endPointStr)){
                errors.add(new ValidationErrorDto("Bad value of end point"));
            }
        }
        if (!errors.isEmpty()) {
            return ResultDto.builder()
                    .errors(errors).build();
        }
        int [][] arrPoints = new int[height][width];
        Point startPoint  = PointUtil.convertCharToInt(startPointStr);
        Point endPoint = PointUtil.convertCharToInt(endPointStr);
        int x0 = startPoint.getX();
        int y0 = startPoint.getY();
        int x1 = endPoint.getX();
        int y1 = endPoint.getY();
        if (height < 2 || width < 2) return ResultDto.builder()
                .result(-1).build();
        if(height == 2 && width == 2) ResultDto.builder()
                .result(-1).build();
        if(x0 > height || y0 > width || x1 > height || y1 > width) return ResultDto.builder()
                .result(-1).build();
        arrPoints[x0][y0] = 1;
        arrPoints[x1][y1] = 0;

        int flag = 0;
        do {
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (flag > height * width) return ResultDto.builder()
                            .result(-1).build();
                    if(arrPoints[i][j] > height && arrPoints[i][j] > width){
                        arrPoints[x1][y1] = - 1;
                        break;
                    }
                    if(arrPoints[i][j] != 0) {
                        if(i + 2 < height & j + 1 < width) {
                            arrPoints[i + 2][j + 1] = arrPoints[i][j] + 1;
                        }
                        if(i - 2 >= 0 & j + 1 < width) {
                            arrPoints[i - 2][j + 1] = arrPoints[i][j] + 1;
                        }
                        if(i + 1 < height & j - 2 >= 0) {
                            arrPoints[i + 1][j - 2] = arrPoints[i][j] + 1;
                        }
                        if(i - 1 >= 0 & j + 2 < width) {
                            arrPoints[i - 1][j + 2] = arrPoints[i][j] + 1;
                        }
                        if(i + 2 < height & j - 1 >= 0) {
                            arrPoints[i + 2][j - 1] = arrPoints[i][j] + 1;
                        }
                        if(i - 2 >= 0 & j - 1 >= 0) {
                            arrPoints[i - 2][j - 1] = arrPoints[i][j] + 1;
                        }
                        if(i + 1 < height & j + 2 < width) {
                            arrPoints[i + 1][j + 2] = arrPoints[i][j] + 1;
                        }
                        if(i - 1 >= 0 & j - 2 >= 0) {
                            arrPoints[i - 1][j - 2] = arrPoints[i][j] + 1;
                        }
                    }
                }
            }
            flag++;
        }while(arrPoints[x1][y1] == 0);
        return ResultDto.builder()
                .result(arrPoints[x1][y1] - 1).build();
    }
}
