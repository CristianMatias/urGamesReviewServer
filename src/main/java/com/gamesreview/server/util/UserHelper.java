package com.gamesreview.server.util;

import com.gamesreview.server.dto.custom.UserLoginCustomDTO;
import com.gamesreview.server.dto.custom.UserSingUpCustomDTO;
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

    public UserLoginCustomDTO pojo2login(User wantedUser) {
        return new ModelMapper().map(wantedUser, UserLoginCustomDTO.class);
    }

    /**
     * @param dto must be UserSignUpCustomDTO or UserDTO
     */
    public <E> User dto2pojo(E dto){
        if(dto instanceof UserSingUpCustomDTO || dto instanceof UserDTO)
            return new ModelMapper().map(dto, User.class);
        return null;
    }
}
