package com.yuki.jackson.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Employee {
    // id
    private Integer id;
    // name gender age
    private String name;
    private String gender;
    private Integer age;
    // job salary entryDate
    private String job;
    private Double salary;
    private Date entryDate;
    // 地址
    private com.yuki.jackson.entity.Address Address;
}
