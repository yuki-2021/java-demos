package com.yuki.test08.dao;

import com.yuki.test08.domain.Employee;
import com.yuki.test08.domain.Simple;
import org.apache.ibatis.annotations.CacheNamespace;

import java.util.List;

@CacheNamespace
public interface SimpleDao {


    List<Simple> getSimpleById(Integer id);

}
