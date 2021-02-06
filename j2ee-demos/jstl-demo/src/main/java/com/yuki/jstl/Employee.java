package com.yuki.jstl;

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
    private Integer id;
    private String name;
    private String gender;
    private String job;
    private Double salary;
    private Date entryDate;

}
