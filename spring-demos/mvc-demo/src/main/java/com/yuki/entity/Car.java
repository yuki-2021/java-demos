package com.yuki.entity;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

@Data
public class Car {

    @NotNull
    @Max(30)
    private Integer speed;



}
