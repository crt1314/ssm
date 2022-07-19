package com.chrt.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    @RequestMapping("/register")
    public String toRegister() {
        return "register";
    }

    @RequestMapping("/login")
    public String toLogin() {
        return "login";
    }
}
