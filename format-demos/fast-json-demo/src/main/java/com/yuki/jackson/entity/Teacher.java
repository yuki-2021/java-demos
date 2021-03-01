package com.yuki.jackson.entity;


import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Teacher {
    // id
    @JSONField(ordinal = 2)
    private Integer id;
    // name gender age
    @JSONField(ordinal = 1,serialize = false)
    private String name;
    private String gender;
    private Integer age;
    // job salary entryDate
    @JSONField(ordinal = 5,name = "jobname")
    private String job;
    private Double salary;
    @JSONField(format = "yyyy-MM-dd")
    private Date entryDate;
    // 地址
    private com.yuki.jackson.entity.Address Address;
}
