package com.pclogo.demo.service;

import com.pclogo.demo.utils.UserUtil;

import java.util.List;

public interface MatchService {
    Integer createRoom(Integer uid);
    Boolean joinById(Integer uid, Integer rid);
    Integer joinSrand(Integer uid);
    Boolean sendCommand(Integer uid, Integer rid, String command);
    List<String> getCommand(Integer uid, Integer rid);
    UserUtil getOtherPlayer(Integer uid, Integer rid);
}
