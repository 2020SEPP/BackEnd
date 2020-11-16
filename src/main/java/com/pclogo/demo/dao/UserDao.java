package com.pclogo.demo.dao;

import com.pclogo.demo.utils.UserUtil;

import java.util.List;

public interface UserDao {
    Integer lookup(String phone);
    Integer lookupname(String name);
    Boolean register(String name, String phone, String password);
    UserUtil loginByPhone(String phone, String password);
    UserUtil loginByName(String phone, String password);
    UserUtil searchByPhone(String phone);
    List<UserUtil> searchByName(String name);
    Boolean setAvatar(String avatar, Integer uid);
}
