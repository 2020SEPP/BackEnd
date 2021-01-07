package com.pclogo.demo.repository;

import com.pclogo.demo.entity.UserMongo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class UserMongoRepositoryTest {

    @Autowired
    UserMongoRepository userMongoRepository;

    @BeforeEach
    void setUp() {
        System.out.println("start");
    }

    @AfterEach
    void tearDown() {
        System.out.println("end");
    }

    @Test
    void delete()
    {
//        UserMongo userMongo = new UserMongo();
//        userMongo.setAvatar("handsome");
//        userMongo.setId(4);
//        userMongoRepository.save(userMongo);
        userMongoRepository.deleteById(4);
    }
}