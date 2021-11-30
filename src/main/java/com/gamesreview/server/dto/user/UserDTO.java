package com.gamesreview.server.dto.user;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserDTO {
    private String nickname;
    private String email;
    private String password;
    private LocalDate registerDate;
}
