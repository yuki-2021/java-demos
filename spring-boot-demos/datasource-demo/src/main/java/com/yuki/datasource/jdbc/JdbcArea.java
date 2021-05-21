package com.yuki.datasource.jdbc;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;


@Data
@Table("tb_area")
public class JdbcArea {

    @Id
    private Long id;

    private String name;

    private Integer priority;
    private Date createTime;
    private Date updateTime;
}
