package com.webservice.springboot.config.auth.dto;

import com.webservice.springboot.domain.user.User;
import lombok.Getter;

import java.io.Serializable;

/**
 * 세션에 저장하기 위한 직렬화된 dto
 * 인증된 사용자 정보만 필요
 */

@Getter
public class SessionUser implements Serializable {
    private String name;
    private String email;
    private String picture;

    public SessionUser(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getEmail();
    }
}
