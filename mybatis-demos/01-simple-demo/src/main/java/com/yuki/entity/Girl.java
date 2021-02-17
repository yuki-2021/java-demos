package com.yuki.entity;

import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Girl {
    private Integer id;
    private String name;
    private String sex;
    private Date birth;
    private String phone;
    private String  photo;
    private Integer boyfriendId;
}
