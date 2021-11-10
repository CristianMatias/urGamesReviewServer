package com.gamesreview.server.service.user.impl;

import com.gamesreview.server.dto.custom.UserLoginCustomDTO;
import com.gamesreview.server.dto.custom.UserSingUpCustomDTO;
import com.gamesreview.server.dto.user.UserDTO;
import com.gamesreview.server.exception.CustomException;
import com.gamesreview.server.model.user.User;
import com.gamesreview.server.repository.user.UserRepository;
import com.gamesreview.server.service.user.UserService;
import com.gamesreview.server.util.UserHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserHelper userHelper;

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream().map(u -> userHelper.pojo2dto(u)).collect(Collectors.toList());
    }

  @Override
    public UserLoginCustomDTO login(String user, String pwd) throws CustomException {
        Optional<User> wantedUser = userRepository.findByNickname(user);
        if(wantedUser.isPresent()){
            User selectedUser = wantedUser.get();
            if(selectedUser.getPassword().equals(pwd)){
                return userHelper.pojo2login(selectedUser);
            }else throw new CustomException("Contraseña incorrecta");
        }else throw new CustomException("No se ha encontrado el usuario");
    }

    @Override
    public UserDTO signup(UserSingUpCustomDTO dto) throws CustomException {
        try {
            User u = userHelper.dto2pojo(dto);
            u.setRegisterDate(LocalDate.now());
            u = userRepository.save(u);
            return userHelper.pojo2dto(u);
        }catch (Exception ex){
            throw new CustomException(ex);
        }

    }
}
