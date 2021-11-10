package com.gamesreview.server.controller.user;

import com.gamesreview.server.dto.user.UserDTO;
import com.gamesreview.server.exception.CustomException;
import com.gamesreview.server.service.user.UserService;
import com.gamesreview.server.util.ResponseHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class UserController{

    @Autowired
    private UserService userService;

    @Autowired
    private ResponseHelper responseHelper;

    @GetMapping("/users")
    ResponseEntity<List<UserDTO>> getAllUsers(){
        return responseHelper.sendCorrect(userService.getAllUsers());
    }

    @PostMapping("/login")
    ResponseEntity<?> login(@RequestParam("user") String user, @RequestParam("pwd") String pwd){
        try {
            return responseHelper.sendCorrect(userService.login(user, pwd));
        }catch (CustomException ce){
            return responseHelper.sendError(ce.getMessage());
        }
    }
}
