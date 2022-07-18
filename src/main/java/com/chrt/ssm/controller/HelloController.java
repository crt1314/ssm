package com.chrt.ssm.controller;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 用于控制hello页面
 */
@Controller
public class HelloController {
    private final AtomicLong counter = new AtomicLong();
    /**
     * 配置hello页面位置
     * @return hello页面位置
     */
    @RequestMapping("/hello")
    public String toHello(Model model, @Nullable String name) {
        model.addAttribute("id", counter.incrementAndGet());
        if (name == null) {
            model.addAttribute("name", "无名氏");
        } else {
            model.addAttribute("name", name);
        }
        return "hello";
    }
}
