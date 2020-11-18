package com.pclogo.demo.serviceImpl;

import com.alibaba.fastjson.JSON;

import com.pclogo.demo.constant.Constant;
import com.pclogo.demo.dao.UserDao;
import com.pclogo.demo.service.UserService;
import com.pclogo.demo.utils.JwtToken;
import com.pclogo.demo.utils.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    private UserUtil setToken(UserUtil userUtil)
    {
        if(userUtil == null)
        {
            userUtil = new UserUtil();
            userUtil.setJudge(false);
        }
        else
        {
            String tmp = userUtil.getAvatar();
            userUtil.setAvatar("");
            userUtil.setToken(JwtToken.createJWT(Constant.JWT_ID, JSON.toJSONString(userUtil), Constant.JWT_TTL));
            userUtil.setAvatar(tmp);
        }
        return userUtil;
    }

    @Override
    public UserUtil loginByPhone(String phone, String password) {
        return setToken(userDao.loginByPhone(phone, password));
    }

    @Override
    public UserUtil loginByName(String name, String password) {
        return setToken(userDao.loginByName(name, password));
    }

    @Override
    public Integer register(String name, String phone, String password) {
        if(userDao.lookup(phone) > 0) return 0;
        else if(userDao.lookupname(name) > 0) return -1;
        if(userDao.register(name, phone, password)) return 1;
        else return -2;
    }

    @Override
    public List<UserUtil> searchByName(String name) {
        return userDao.searchByName(name);
    }

    @Override
    public Boolean setAvatar(String avatar, Integer uid) {
        return userDao.setAvatar(avatar, uid);
    }

    @Override
    public List<UserUtil> getFriend(Integer uid) {
        List<Integer> list = userDao.getFriendList(uid);
        List<UserUtil> res = new ArrayList<>();
        for(Integer i:list)
        {
            UserUtil userUtil = userDao.getFriendByUid(i);
            res.add(userUtil);
        }
        return res;
    }

    @Override
    public Boolean updateInfo(Integer id, String name, String password) {
        return userDao.updateInfo(id, name, password);
    }

    @Override
    public Boolean updateAvatar(Integer id, String avatar) {
        return userDao.updateAvatar(id, avatar);
    }

    @Override
    public Boolean jiahaoyou(Integer uid, Integer touid) {
        return userDao.jiahaoyou(uid, touid);
    }

    @Override
    public UserUtil searchByPhone(String friendPhone) {
        return userDao.searchByPhone(friendPhone);
    }

}
