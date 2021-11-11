package com.gamesreview.server.dto.user;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class UserDTO {
    private String nickname;
    private String email;
    private String password;
    private LocalDate registerDate;
    private List<UserDTO> following;
}
