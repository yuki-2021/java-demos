package com.yuki.test081.dao;

import com.yuki.test081.domain.Simple;

import java.util.List;

public interface SimpleDao {

    List<Simple> getSimpleById(Integer id);
}
