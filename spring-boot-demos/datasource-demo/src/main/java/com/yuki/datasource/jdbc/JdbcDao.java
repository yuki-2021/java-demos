package com.yuki.datasource.jdbc;

import org.springframework.data.repository.CrudRepository;


public interface JdbcDao extends CrudRepository<JdbcArea, Long> {

}
