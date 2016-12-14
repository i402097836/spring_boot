package com.es.fileservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by LHL on 2016/12/10.
 */
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String   printInfo() {
        System.out.println("hello world");
        return "hello";
    }
}
