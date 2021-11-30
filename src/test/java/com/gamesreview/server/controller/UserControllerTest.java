package com.gamesreview.server.controller;

import com.gamesreview.server.controller.user.UserController;
import com.gamesreview.server.dto.custom.UserSingUpCustomDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserControllerTest {

    @Autowired
    private UserController userController;

    @Test
    void shouldGetAllUsers(){
        Assertions.assertNotNull(userController.getAllUsers());
    }

    @Test
    void shouldLogin() {
        Assertions.assertNotNull(userController.login("alfreiro99","a"));
    }

    @Test
    void shouldSignUp() {
        UserSingUpCustomDTO dto = new UserSingUpCustomDTO();
        dto.setEmail("mock1@gmail.com");
        dto.setNickname("mock1");
        dto.setPassword("mock");
        Assertions.assertNotNull(userController.signup(dto));
    }
}
