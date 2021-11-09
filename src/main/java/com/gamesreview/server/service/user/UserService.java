package com.gamesreview.server.service.user;

import com.gamesreview.server.dto.user.UserDTO;

import java.util.List;

public interface UserService {

    List<UserDTO> getAllUsers();
}
