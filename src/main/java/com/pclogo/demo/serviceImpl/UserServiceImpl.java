package com.pclogo.demo.serviceImpl;

import com.alibaba.fastjson.JSON;

import com.pclogo.demo.constant.Constant;
import com.pclogo.demo.dao.UserDao;
import com.pclogo.demo.service.UserService;
import com.pclogo.demo.utils.JwtToken;
import com.pclogo.demo.utils.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public UserUtil login(String phone, String password) {
        UserUtil userUtil;
        if((userUtil = userDao.login(phone, password)) == null)
        {
            userUtil = new UserUtil(false, null, null, null);
        }
        else
        {
            System.out.println(userUtil);
            userUtil.setToken(JwtToken.createJWT(Constant.JWT_ID, JSON.toJSONString(userUtil), Constant.JWT_TTL));
        }
        return userUtil;
    }

    @Override
    public Boolean register(String phone, String password) {
        if(userDao.lookup(phone) > 0) return false;
        return userDao.register(phone, password);
    }

}
