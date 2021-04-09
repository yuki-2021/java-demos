package com.yuki.datasource.jdbc;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Date;

//import javax.persistence.*;

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
