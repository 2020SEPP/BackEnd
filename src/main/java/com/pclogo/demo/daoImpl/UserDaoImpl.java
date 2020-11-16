package com.pclogo.demo.daoImpl;

import com.pclogo.demo.dao.UserDao;
import com.pclogo.demo.entity.User;
import com.pclogo.demo.entity.UserMongo;
import com.pclogo.demo.repository.UserMongoRepository;
import com.pclogo.demo.repository.UserRepository;
import com.pclogo.demo.utils.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserMongoRepository userMongoRepository;

    @Override
    public Integer lookup(String phone) {
        return userRepository.lookup(phone);
    }

    @Override
    public Integer lookupname(String name) {
        return userRepository.lookupname(name);
    }

    @Override
    public Boolean register(String name, String phone, String password) {
        User user = new User();
        user.setName(name);
        user.setPhone(phone);
        user.setPassword(password);
        userRepository.save(user);
        UserMongo userMongo = new UserMongo();
        userMongo.setId(user.getId());
        userMongo.setFriends(null);
        userMongoRepository.save(userMongo);
        return true;
    }

    private UserUtil setLoginTool(User user)
    {
        UserUtil userUtil = new UserUtil();
        if(user == null)
        {
            userUtil.setJudge(false);
            return userUtil;
        }
        UserMongo userMongo = userMongoRepository.findById(user.getId()).orElse(null);
        assert userMongo != null;
        userUtil.setJudge(true);
        userUtil.setName(user.getName());
        userUtil.setUid(user.getId());
        userUtil.setPhone(user.getPhone());
        userUtil.setFriends(userMongo.getFriends());
        userUtil.setAvatar(userMongo.getAvatar());
        return userUtil;
    }

    @Override
    public UserUtil loginByPhone(String phone, String password) {
        User user = userRepository.loginByPhone(phone, password);
        return setLoginTool(user);
    }

    @Override
    public UserUtil loginByName(String name, String password) {
        User user = userRepository.loginByName(name, password);
        return setLoginTool(user);
    }

    @Override
    public UserUtil searchByPhone(String phone) {
        User user = userRepository.searchByPhone(phone);
        UserUtil userUtil = new UserUtil();
        if(user == null)
        {
            userUtil.setJudge(false);
        }
        else {
            UserMongo userMongo = userMongoRepository.findById(user.getId()).orElse(null);
            userUtil.setJudge(true);
            userUtil.setUid(user.getId());
            userUtil.setName(user.getName());
            userUtil.setAvatar(userMongo.getAvatar());
        }
        return userUtil;
    }

    @Override
    public List<UserUtil> searchByName(String name) {
        List<User> list = userRepository.searchByName(name);
        if(list == null) return null;
        List<UserUtil> reslist = new ArrayList<>();
        for (User user : list) {
            UserUtil tmp = new UserUtil();
            UserMongo userMongo = userMongoRepository.findById(user.getId()).orElse(null);
            tmp.setJudge(true);
            tmp.setUid(user.getId());
            tmp.setName(user.getName());
            tmp.setAvatar(userMongo.getAvatar());
            reslist.add(tmp);
        }
        return reslist;
    }

    @Override
    public Boolean setAvatar(String avatar, Integer uid) {
        UserMongo userMongo = userMongoRepository.findById(uid).orElse(null);
        assert userMongo != null;
        userMongo.setAvatar(avatar);
        userMongoRepository.deleteById(uid);
        userMongoRepository.save(userMongo);
        return true;
    }

}
