package com.gamesreview.server.dto.custom;

import lombok.Data;

@Data
public class UserLoginCustomDTO {
    private String nickname;
    private String email;
    private Integer totalFollowing;
}
