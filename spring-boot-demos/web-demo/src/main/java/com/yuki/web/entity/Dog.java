package com.yuki.web.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dog {

    // 不为空 长度大于6
    @NotEmpty
    @Length(min = 6)
    private String name;

    // 不为空 长度大于6
    @NotEmpty
    @Length(min = 6)
    private String age;
}
