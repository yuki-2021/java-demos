package com.yuki.jdbc.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;


@Data
public class Area implements Serializable {
    /**
     * 区域id
     */
    private Long id;

    /**
     * 区域名称
     */
    private String name;

    /**
     * 优先级
     */
    private Integer priority;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

}