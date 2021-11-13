package com.yuki.test081.dao;


import com.yuki.test081.domain.Employee;

import java.util.List;

public interface EmployeeDao {

    /*
    * 查询
    * */
    List<Employee> getEmpById(Integer id);
    List<Employee> getEmpByDeptId(Integer deptId);

    int insertFlush(Employee employee);
}
