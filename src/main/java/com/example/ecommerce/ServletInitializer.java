package com.example.ecommerce;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer {


    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ECommerceApplication.class);
    }

}
