package com.pclogo.demo.service;

public interface MatchService {
    Integer createRoom(Integer uid);
    Boolean joinById(Integer uid, Integer rid);
    Integer joinSrand(Integer uid);
}
