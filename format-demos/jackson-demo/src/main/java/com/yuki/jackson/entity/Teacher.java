package com.yuki.jackson.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/*
*  4. JSON注解
*     @JsonInclude - 设置包含字段
*     @JsonProperty - 指定str和field对应关系
*     @JsonFormat   - 日期格式化
*     @JsonPropertyOrder - 序列化顺序
* */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"id"})
public class Teacher {
    // id

    private Integer id;
    // name gender age
    @JsonProperty("username")
    private String name;
    private String gender;
    private Integer age;
    // job salary entryDate
    private String job;
    private Double salary;
    @JsonFormat(timezone = "+8:00",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date entryDate;
    // 地址
    private com.yuki.jackson.entity.Address Address;
}
