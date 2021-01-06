package com.pclogo.demo.controller;

import com.pclogo.demo.service.MatchService;
import com.pclogo.demo.utils.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/match")
public class MatchController {
    @Autowired
    MatchService matchService;

    @RequestMapping("/createRoom")
    Integer createRoom(@RequestParam("uid") Integer uid)
    {
        return matchService.createRoom(uid);
    }

    @RequestMapping("/joinById")
    Boolean joinById(@RequestParam("uid") Integer uid, @RequestParam("rid") Integer rid)
    {
        return matchService.joinById(uid, rid);
    }

    @RequestMapping("/joinSrand")
    Integer joinSrand(@RequestParam("uid") Integer uid)
    {
        return matchService.joinSrand(uid);
    }

    @RequestMapping("/sendCommand")
    Boolean sendCommand(@RequestParam("uid") Integer uid, @RequestParam("rid") Integer rid, @RequestParam("command") String command) {return matchService.sendCommand(uid, rid, command);}

    @RequestMapping("/getCommand")
    List<String> getCommand(@RequestParam("uid") Integer uid, @RequestParam("rid") Integer rid) {return matchService.getCommand(uid, rid);}

    @RequestMapping("/getOthorPlayer")
    UserUtil getOtherPlayer(@RequestParam("uid") Integer uid, @RequestParam("rid") Integer rid)
    {
//        return matchService.getOtherPlayer(uid, rid);
        return null;
    }
}
