package com.pclogo.demo.service;

import com.pclogo.demo.utils.UserUtil;

public interface UserService {
    UserUtil login(String phone, String password);
    Boolean register(String phone, String password);
}
