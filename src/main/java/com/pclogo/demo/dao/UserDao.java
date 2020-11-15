package com.pclogo.demo.dao;

import com.pclogo.demo.utils.UserUtil;

public interface UserDao {
    Integer lookup(String phone);
    Boolean register(String phone, String password);
    UserUtil login(String phone, String password);
}
