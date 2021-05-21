package com.yuki.datasource.jpa;

import org.springframework.data.repository.CrudRepository;

public interface JpaDao extends CrudRepository<Area,Long> {

    // 定义自己的方法 - 根据name进行查询
    Area queryAllByName(String name);
}
