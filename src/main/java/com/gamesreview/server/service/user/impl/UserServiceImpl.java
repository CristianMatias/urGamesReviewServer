package com.gamesreview.server.service.user.impl;

import com.gamesreview.server.dto.user.UserDTO;
import com.gamesreview.server.repository.user.UserRepository;
import com.gamesreview.server.service.user.UserService;
import com.gamesreview.server.util.UserHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
}
