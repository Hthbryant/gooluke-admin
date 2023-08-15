package com.gooluke.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 咕噜科
 * ClassName: LoginController
 * date: 2023-08-15 23:17
 * Description:
 * version 1.0
 */
@RestController
public class LoginController {

    @RequestMapping("/login")
    public String login(){
        return "login success";
    }

    @RequestMapping("/logout")
    public String logout(){
        return "logout success";
    }

}
