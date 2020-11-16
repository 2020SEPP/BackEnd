package com.pclogo.demo.service;

import com.pclogo.demo.utils.UserUtil;

public interface UserService {
    UserUtil login(String phone, String password);
    Integer register(String name, String phone, String password);
    UserUtil search(String friendPhone);
}
