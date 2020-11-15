package com.pclogo.demo.controller;

import com.pclogo.demo.service.UserService;
import com.pclogo.demo.utils.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public UserUtil login(@RequestParam("phone") String phone, @RequestParam("password") String password)
    {
        return userService.login(phone, password);
    }

    @RequestMapping("/register")
    public Boolean register(@RequestParam("phone") String phone, @RequestParam("password") String password)
    {
        return userService.register(phone, password);
    }

    @RequestMapping("/jwttest")
    public String jwttest()
    {
        return "如果你看到这句话，说明你的jwt已经可以用了";
    }
}
