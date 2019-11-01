package ru.test.task.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ServletComponentScan("ru.test.task")
@ComponentScan("ru.test.task")

public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
