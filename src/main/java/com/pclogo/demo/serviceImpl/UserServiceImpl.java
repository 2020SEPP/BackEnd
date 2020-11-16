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
//            userUtil = new UserUtil(false, null, null, null);
            userUtil = new UserUtil();
            userUtil.setJudge(false);
        }
        else
        {
            userUtil.setToken(JwtToken.createJWT(Constant.JWT_ID, JSON.toJSONString(userUtil), Constant.JWT_TTL));
        }
        return userUtil;
    }

    @Override
    public Integer register(String name, String phone, String password) {
        if(userDao.lookup(phone) > 0) return 0;
        else if(userDao.lookupname(name) > 0) return -1;
        if(userDao.register(name, phone, password)) return 1;
        else return -2;
    }

    @Override
    public UserUtil search(String friendPhone) {
        return userDao.search(friendPhone);
    }

}
