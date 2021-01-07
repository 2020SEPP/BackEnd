package com.pclogo.demo.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
class UserControllerTest {
    @Autowired
    UserController userController;

    @Autowired
    WebApplicationContext context;

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
    void loginByPhone() {
        userController.loginByPhone("15044341612", "111111");
    }

    @Test
    void loginByName() {
        userController.loginByName("xjh", "111111");
    }

    @Test
    void register() {
        userController.register("xjh", "15044341612", "111111");
    }

    @Test
    void searchByPhone() {
        userController.searchByPhone("15044341612");
    }

    @Test
    void searchByName() {
    }

    @Test
    void loadAvatar() {
    }

    @Test
    void getFriend() {
    }

    @Test
    void updateInfo() {
    }

    @Test
    void updateAvatar() {
    }

    @Test
    void sendInvite() {
    }

    @Test
    void checkInvite() {
    }

    @Test
    void acceptInvite() {
    }
}