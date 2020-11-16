package com.pclogo.demo.controller;

import com.pclogo.demo.service.UserService;
import com.pclogo.demo.utils.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/loginByPhone")
    public UserUtil loginByPhone(@RequestParam("phone") String phone, @RequestParam("password") String password)
    {
        return userService.loginByPhone(phone, password);
    }

    @RequestMapping("/loginByName")
    public UserUtil loginByName(@RequestParam("name") String name, @RequestParam("password") String password)
    {
        return userService.loginByName(name, password);
    }

    @RequestMapping("/register")
    public Integer register(@RequestParam("name") String name, @RequestParam("phone") String phone, @RequestParam("password") String password)
    {
        return userService.register(name, phone, password);
    }

    @RequestMapping("/jwttest")
    public String jwttest()
    {
        return "如果你看到这句话，说明你的jwt已经可以用了";
    }

    @RequestMapping("/searchByPhone")
    public UserUtil searchByPhone(@RequestParam("friendPhone") String friendPhone)
    {
        return userService.searchByPhone(friendPhone);
    }

    @RequestMapping("/searchByName")
    public List<UserUtil> searchByName(@RequestParam("friendName") String name)
    {
        return userService.searchByName(name);
    }

    @RequestMapping("/loadAvatar")
    public Boolean loadAvatar(@RequestParam("avatar") String avatar, @RequestParam Integer uid)
    {
        return userService.setAvatar(avatar, uid);
    }
}
