package com.yuki.demo2.entity;

import java.util.*;

public class CollectBean {

    List<String> list;
    Map<String,Integer> map;
    Set<String> set;
    String[] arr;
    Properties props;

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public Map<String, Integer> getMap() {
        return map;
    }

    public void setMap(Map<String, Integer> map) {
        this.map = map;
    }

    public Set<String> getSet() {
        return set;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public String[] getArr() {
        return arr;
    }

    public void setArr(String[] arr) {
        this.arr = arr;
    }

    public Properties getProps() {
        return props;
    }

    public void setProps(Properties props) {
        this.props = props;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("CollectBean{");
        sb.append("list=").append(list);
        sb.append(", map=").append(map);
        sb.append(", set=").append(set);
        sb.append(", arr=").append(arr == null ? "null" : Arrays.asList(arr).toString());
        sb.append(", props=").append(props);
        sb.append('}');
        return sb.toString();
    }
}
