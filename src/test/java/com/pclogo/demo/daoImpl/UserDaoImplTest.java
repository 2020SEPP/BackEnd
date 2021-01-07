package com.pclogo.demo.daoImpl;

import com.pclogo.demo.DemoApplicationTests;
import com.pclogo.demo.dao.UserDao;
import com.pclogo.demo.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
class UserDaoImplTest extends DemoApplicationTests
{
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
    void lookup() {
        userDao.lookup("15044341612");
    }

    @Test
    void lookupname() {
        userDao.lookup("xjh");
    }

    @Test
    void register() {
    }

    @Test
    void loginByPhone() {
    }

    @Test
    void loginByName() {
    }

    @Test
    void searchByPhone() {
    }

    @Test
    void searchByName() {
    }

    @Test
    void setAvatar() {
    }

    @Test
    void getFriendList() {
    }

    @Test
    void getFriendByUid() {
    }

    @Test
    void updateInfo() {
    }

    @Test
    void updateAvatar() {
    }

    @Test
    void jiahaoyou() {
    }

    @Test
    void getById() {
    }

    @Test
    void getInvites() {
    }

    @Test
    void setInvites() {
    }

    @Test
    void setFriends() {
    }

    @Test
    void test1() {
    }
}