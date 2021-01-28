package com.yuki.dao;

import com.yuki.entity.Girl;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface GirlDao {

    // simpleDemo
    List<Girl> queryGirlList();

    // queryParamter - one
    Girl queryById(Integer id);
    // queryParamter - two
    List<Girl> queryByNameAndPhone(String name,String phone);
    // queryParamter - Pojo
    List<Girl> queryByPojo(Girl girl);
    // queryParamter - Map
    List<Girl> queryByMap(Map map);
    // queryParamter - list
    List<Girl> queryByList(List list);
    // queryParamter - set
    List<Girl> queryBySet(Set set);
    // queryparamter - arr
    List<Girl> queryByArr(String[] arr);

    // resultType - map
    Map<String,Object> queryMap(Integer id);
    // resultPojo - pojo
    Girl queryPojo(Integer id);

    // null cast
    List<Girl> queryNullCast(Girl girl);
    // #{} and ${}
    // nameÄ£ºý²éÑ¯
    List<Girl> queryLikeName(String name);
}
