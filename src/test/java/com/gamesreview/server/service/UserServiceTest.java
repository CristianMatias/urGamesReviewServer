package com.gamesreview.server.service;

import com.gamesreview.server.dto.custom.UserSingUpCustomDTO;
import com.gamesreview.server.exception.CustomException;
import com.gamesreview.server.service.user.impl.UserServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserServiceImpl userService;

    @Test
    void shouldGetAllUsers(){
        Assertions.assertNotNull(userService.getAllUsers());
    }

    @Test
    void shouldLogin() {
        try {
            Assertions.assertNotNull(userService.login("alfreiro99","a"));
        } catch (CustomException e) {
            Assertions.fail();
        }
    }

    @Test
    void shouldSignUp() {
        try {
            UserSingUpCustomDTO dto = new UserSingUpCustomDTO();
            dto.setEmail("mock@gmail.com");
            dto.setNickname("mock");
            dto.setPassword("mock");
            Assertions.assertNotNull(userService.signup(dto));
        } catch (CustomException e) {
            Assertions.fail();
        }
    }

}
