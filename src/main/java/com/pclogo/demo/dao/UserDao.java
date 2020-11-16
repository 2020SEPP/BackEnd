package com.pclogo.demo.dao;

import com.pclogo.demo.utils.UserUtil;

public interface UserDao {
    Integer lookup(String phone);
    Integer lookupname(String name);
    Boolean register(String name, String phone, String password);
    UserUtil login(String phone, String password);
    UserUtil search(String phone);
}
