package com.gamesreview.server.dto.custom;

import lombok.Data;

import java.util.List;

@Data
public class UserLoginCustomDTO {
    private String nickname;
    private String email;
    private List<UserLoginCustomDTO> following;
}
