package com.chrt.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用于控制首页位置以及hello页面
 */
@Controller
public class IndexController {
    /**
     * 配置首页位置
     * @return 首页位置
     */
    @RequestMapping("/")
    public String toIndex() {
        return "index";
    }

    /**
     * 配置hello页面位置
     * @return hello页面位置
     */
    @RequestMapping("/hello")
    public String toHello() {
        return "hello";
    }
}
