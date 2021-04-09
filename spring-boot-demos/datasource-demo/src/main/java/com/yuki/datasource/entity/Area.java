package com.yuki.datasource.entity;

import lombok.Data;
import org.springframework.data.annotation.Persistent;
import org.springframework.data.relational.core.mapping.Table;

//import javax.persistence.*;
import javax.persistence.*;
import java.util.Date;

@Data
@Entity(name = "tb_area")
public class Area {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private Integer priority;
    @Column
    private Date createTime;
    @Column
    private Date updateTime;
}
