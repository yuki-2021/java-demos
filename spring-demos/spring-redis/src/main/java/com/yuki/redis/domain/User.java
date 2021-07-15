package com.yuki.redis.domain;

import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@With
@Builder
public class User implements Serializable {

    private String id;
    private String password;

}
