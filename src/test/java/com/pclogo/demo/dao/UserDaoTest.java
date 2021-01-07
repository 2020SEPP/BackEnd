package com.pclogo.demo.dao;

import com.pclogo.demo.DemoApplicationTests;
import com.pclogo.demo.daoImpl.UserDaoImpl;
import com.pclogo.demo.repository.UserRepository;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest extends DemoApplicationTests {
    @Autowired
    UserDao userDao;

    @Autowired
    WebApplicationContext context;

    @MockBean
    private UserRepository userRepository;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        System.out.println("set up");
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @AfterEach
    void tearDown() {
        System.out.println("tear down");
    }

    @Test
    @Transactional
    public void lookupTest()
    {
//        System.out.println(userDao.lookup("15044341612"));
//        System.out.println("??");
//        userDao.test();
    }

}
