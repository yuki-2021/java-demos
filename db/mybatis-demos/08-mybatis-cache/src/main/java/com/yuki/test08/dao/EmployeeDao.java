package com.yuki.test08.dao;

import com.yuki.test08.domain.Employee;

import java.util.List;

public interface EmployeeDao {

    /*
    * 一级缓存
    * */
    List<Employee> getOneLevelCacheById(Integer id);
    List<Employee> getOneLevelCacheByDeptId(Integer deptId);


    /*
    * 二级缓存
    * */
    List<Employee> getTwoCacheLevelById(Integer id);
    int insertFlush(Employee employee);
}
