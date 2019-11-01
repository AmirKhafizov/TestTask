package ru.test.task.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import ru.test.task.dto.ResultDto;
import ru.test.task.services.MinPathService;

@RestController
@RequestMapping("/horse/rest")
public class MinPathController {

    private static final String FIND_MIN_PAYH_HORSE = "/count";

    @Autowired
    private MinPathService minPathService;


    @GetMapping(FIND_MIN_PAYH_HORSE)
    public ResponseEntity<ResultDto> findMinPath(@RequestParam("start") String startPoint,
                                                 @RequestParam("end") String endPoint,
                                                 @RequestParam("height") int height,
                                                 @RequestParam("width") int width) throws Exception {


        ResultDto resultDto = minPathService.findMinPathFromStartPointToEndPoint(startPoint, endPoint, height, width);
        return new ResponseEntity<>(resultDto, HttpStatus.OK);
    }
}
