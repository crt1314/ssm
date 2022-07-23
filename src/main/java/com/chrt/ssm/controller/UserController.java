package com.chrt.ssm.controller;

import com.chrt.ssm.exception.UserException;
import com.chrt.ssm.pojo.User;
import com.chrt.ssm.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 用户相关操作控制类
 */
@Controller
public class UserController {

    /**
     * 注入userService
     */
    @Autowired
    private UserService userService;

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

    /**
     * 检查用户是否存在
     * @param username 用户信息
     * @return 是否存在标志
     */
    @ResponseBody
    @PostMapping("/checkUser")
    public Boolean checkUser(String username) {
        try {
            userService.checkUserIfExists(username);
            return false;
        } catch (UserException e) {
            if ("Username exists".equals(e.getMessage())) {
                return true;
            }
            return null;
        }
    }
}
