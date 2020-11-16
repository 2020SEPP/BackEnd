package com.pclogo.demo.daoImpl;

import com.pclogo.demo.dao.UserDao;
import com.pclogo.demo.entity.User;
import com.pclogo.demo.entity.UserMongo;
import com.pclogo.demo.repository.UserMongoRepository;
import com.pclogo.demo.repository.UserRepository;
import com.pclogo.demo.utils.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserMongoRepository userMongoRepository;
    @Override
    public Integer lookup(String phone) {

//        return userRepository.lookup(phone);
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

    @Override
    public UserUtil login(String phone, String password) {
        UserUtil userUtil = new UserUtil();
        User user = userRepository.login(phone, password);
        if(user == null)
        {
//            userUtil = new UserUtil(false, null, null, null);
            userUtil.setJudge(false);
            return userUtil;
        }
        UserMongo userMongo = userMongoRepository.findById(user.getId()).orElse(null);
        assert userMongo != null;
//        userUtil = new UserUtil(true, null, user.getId(), userMongo.getFriends());
        userUtil.setJudge(true);
        userUtil.setName(user.getName());
        userUtil.setUid(user.getId());
        userUtil.setFriends(userMongo.getFriends());
        return userUtil;
    }

    @Override
    public UserUtil search(String phone) {
        User user = userRepository.search(phone);
        UserUtil userUtil = new UserUtil();
        if(user == null)
        {
//            userUtil = new UserUtil(null,null,null, null);
            userUtil.setJudge(false);
        }
        else {
//            userUtil = new UserUtil(true, null, user.getId(), null);
            userUtil.setJudge(true);
            userUtil.setUid(user.getId());
            userUtil.setName(user.getName());
        }
        return userUtil;
    }

}
