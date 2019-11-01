package testService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.test.task.application.Application;
import ru.test.task.dto.ResultDto;
import ru.test.task.models.ChessBoard;

import ru.test.task.services.MinPathService;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
public class MinPathServiceTest {

    @Autowired
    private MinPathService minPathService;
    @Test
    public void findMinPathFromStartPointToEndPoint() {
        int height1 = 8;
        int width1 = 8;
        int height2 = 2;
        int width2 = 2;
        String startPoint1 = "A3";
        String endPoint1 = "B1";
        String startPoint2 = "A1";
        String endPoint2 = "B2";
        int result1 = 1;
        int result2 = -1;

        ResultDto testResultDto = minPathService.findMinPathFromStartPointToEndPoint(startPoint1,endPoint1,height1,width1);
        ResultDto testResultDto2 = minPathService.findMinPathFromStartPointToEndPoint(startPoint2,endPoint2,height2,width2);

        assertTrue("Result not true", testResultDto.getResult() == result1);
        assertTrue("Result not true",testResultDto2.getResult() == result2);
    }
}