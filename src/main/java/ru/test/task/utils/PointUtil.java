package ru.test.task.utils;

import ru.test.task.models.Point;

import java.util.ArrayList;
import java.util.List;

public class PointUtil {
    public static Point convertCharToInt(String pointString) {
        char[] pointChars = pointString.toCharArray();

        int temp = 'A' - 1;

        StringBuilder tempX = new StringBuilder();
        List<Integer> characterList = new ArrayList<>();

        for (char pointChar : pointChars) {
            if (pointChar >= 'A' && pointChar <= 'Z') {
                characterList.add(pointChar - temp);
            } else
                tempX.append(pointChar);
        }
        int finalY = 0;
        if (characterList.size() == 1){
            finalY = characterList.get(0);
        } else {
            for (int i = 0; i < characterList.size(); i++) {
                if (i == characterList.size() - 1){
                    finalY += characterList.get(i);
                } else {
                    finalY += characterList.get(i) * 26;
                }
            }
        }
        return Point.builder()
                .x(Integer.parseInt(tempX.toString()) - 1)
                .y(finalY - 1)
                .build();


    }
}
