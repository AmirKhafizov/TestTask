package ru.test.task.servlet;

import ru.test.task.dto.ResultDto;
import ru.test.task.services.MinPathService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class MinPathServlet extends HttpServlet {

    private MinPathService minPathService;

    public MinPathServlet(MinPathService minPathService){
        this.minPathService = minPathService;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String startPoint = request.getParameter("start");
        String endPoint = request.getParameter("end");
        int height = Integer.valueOf(request.getParameter("height"));
        int width = Integer.valueOf(request.getParameter("width"));
        ResultDto resultDto = minPathService.findMinPathFromStartPointToEndPoint(startPoint, endPoint, height, width);
        PrintWriter printWriter = response.getWriter();
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        printWriter.write(resultDto + "");

    }
}
