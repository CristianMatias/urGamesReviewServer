package com.gamesreview.server.util;

import com.gamesreview.server.dto.user.UserDTO;
import com.gamesreview.server.model.user.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
public class UserHelper {

    public UserDTO pojo2dto(User pojo){
        UserDTO dto = new ModelMapper().map(pojo, UserDTO.class);
        dto.setPassword(Base64.getEncoder().encodeToString(pojo.getPassword().getBytes()));
        return dto;
    }

    public User dto2pojo(UserDTO dto){
        return new ModelMapper().map(dto, User.class);
    }

}
