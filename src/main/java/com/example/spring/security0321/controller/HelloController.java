package com.example.spring.security0321.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/hello")
public class HelloController {

    @GetMapping("")
    public String hello() {
        return "hello";
    }

    @GetMapping("/{name}")
    public String hello(@PathVariable("name") String name) {
        return "hello " + name;
    }
}
