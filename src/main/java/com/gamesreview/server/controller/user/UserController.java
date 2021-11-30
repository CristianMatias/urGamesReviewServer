package com.gamesreview.server.controller.user;

import com.gamesreview.server.dto.custom.UserSingUpCustomDTO;
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
    public ResponseEntity<List<UserDTO>> getAllUsers(){
        return responseHelper.sendCorrect(userService.getAllUsers());
    }

    @PostMapping ("/login")
    public ResponseEntity<?> login(@RequestParam("user") String user, @RequestParam("pwd") String pwd){
        try {
            return responseHelper.sendCorrect(userService.login(user, pwd));
        }catch (CustomException ce){
            return responseHelper.sendError(ce.getMessage());
        }
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody UserSingUpCustomDTO dto){
        try {
            return responseHelper.sendCorrect(userService.signup(dto));
        }catch (CustomException ce){
            return responseHelper.sendError(ce.getMessage());
        }
    }

    @PostMapping("/{user}/follow/{account}")
    public ResponseEntity<?> follow(@PathVariable String user, @PathVariable String account){
        return responseHelper.sendCorrect(userService.follow(user, account));
    }
}
