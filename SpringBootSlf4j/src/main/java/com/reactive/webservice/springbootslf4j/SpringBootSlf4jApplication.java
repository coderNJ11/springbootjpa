package com.reactive.webservice.springbootslf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringBootSlf4jApplication {

    Logger logger = LoggerFactory.getLogger(SpringBootSlf4jApplication.class);

    @GetMapping("/greeting/{name}")
    public String greeting(@PathVariable String name) {
        logger.info("Hello {}", name);
        return "Hello" + name;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootSlf4jApplication.class, args);
    }

}
