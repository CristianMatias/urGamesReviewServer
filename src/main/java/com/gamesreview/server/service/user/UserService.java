package com.gamesreview.server.service.user;

import com.gamesreview.server.dto.custom.UserLoginCustomDTO;
import com.gamesreview.server.dto.custom.UserSingUpCustomDTO;
import com.gamesreview.server.dto.user.UserDTO;
import com.gamesreview.server.exception.CustomException;

import java.util.List;

public interface UserService {

    List<UserDTO> getAllUsers();
    UserLoginCustomDTO login(String user, String pwd) throws CustomException;
    UserDTO signup(UserSingUpCustomDTO dto) throws CustomException;
}
