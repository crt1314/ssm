package com.chrt.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping("/")
    public String toIndex() {
        return "index";
    }

    @RequestMapping("/hello")
    public String toHello() {
        return "hello";
    }
}
