package com.chrt.ssm.controller;

import com.chrt.ssm.exception.UserException;
import com.chrt.ssm.pojo.User;
import com.chrt.ssm.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/register")
    public String toRegister() {
        return "register";
    }

    @RequestMapping("/login")
    public String toLogin() {
        return "login";
    }

    @PostMapping("/realRegister")
    public String register(User user, Model model) {
        try {
            userService.registerUser(user);
            return "redirect:/";
        } catch (UserException e) {
            model.addAttribute("ErrMsg", e.getMessage());
            return "forward:/register";
        }
    }

    @ResponseBody
    @PostMapping("/checkUser")
    public Boolean checkUser(User user) {
        try {
            userService.checkUserIfExists(user);
            return true;
        } catch (UserException e) {
            return false;
        }
    }
}
