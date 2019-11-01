package ru.test.task.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.test.task.services.MinPathService;
import ru.test.task.servlet.MinPathServlet;

@Configuration
public class WebConfig {
    @Bean
    @Autowired
    public ServletRegistrationBean servletBean(MinPathService service) {
        return new ServletRegistrationBean<>(new MinPathServlet(service), "/horse/servlet/count");
    }
}