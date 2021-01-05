package com.pclogo.demo.controller;

import com.pclogo.demo.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping("/match")
public class MatchController {
    @Autowired
    MatchService matchService;

    @RequestMapping("/createRoom")
    Integer createRoom(Integer uid)
    {
        return matchService.createRoom(uid);
    }

    @RequestMapping("/joinById")
    Boolean joinById(Integer uid, Integer rid)
    {
        return matchService.joinById(uid, rid);
    }

    @RequestMapping("joinSrand")
    Integer joinSrand(Integer uid)
    {
        return matchService.joinSrand(uid);
    }
}
