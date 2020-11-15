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
        Integer res = userRepository.lookup(phone);
        System.out.println(res);
        return res;
    }

    @Override
    public Boolean register(String phone, String password) {
        User user = new User();
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
        UserUtil userUtil;
        User user = userRepository.login(phone, password);
        if(user == null)
        {
            userUtil = new UserUtil(false, null, null, null);
            return userUtil;
        }
        UserMongo userMongo = userMongoRepository.findById(user.getId()).orElse(null);
        assert userMongo != null;
        userUtil = new UserUtil(true, null, user.getId(), userMongo.getFriends());
        return userUtil;
    }
}
