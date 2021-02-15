package com.yuki.app;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class BeanFactory {

    public Map<String,Object> beans = new HashMap<>();

    private Map<String,Map<String,String>> propsMap = new HashMap<>();
    private Map<String,String> classMap = new HashMap<>();

    public BeanFactory(String url) throws Exception {
        loadProps(url);
        initBeans();
        setProps();
    }

    /*
    * propsMap - beanName和beanProps的HashMap
    * */
    private void loadProps(String url) throws IOException {
        Properties props = new Properties();
        props.load(new FileInputStream(url));
        // 1. 初始化 ClassList 和 PropList
        Set<String> allSet = props.stringPropertyNames();
        Set<String> nameSet = new HashSet<>();
        Set<String> propSet = new HashSet<>(allSet);
        Set<String> keySet = new HashSet<>();
        for (String str : allSet) {
            if(str.contains(".class")) {
                // 1.init classMap
                String key = str.substring(0, str.indexOf('.'));
                classMap.put(key,props.getProperty(str));
                // 2. other
                keySet.add(key);
                nameSet.add(str);
            }
        }
        propSet.removeAll(nameSet);
        // 2. 初始化 propMap
        for (String key : keySet) {
            HashMap<String,String> map = new HashMap<>();
            for (String item : propSet) {
                if(item.contains(key)) {
                    String prop = item.substring(item.indexOf('.') + 1);
                    // add to propMap
                    map.put(prop,props.getProperty(item));
                }
            }
            propsMap.put(key,map);
        }
        //
        System.out.println(propsMap);
    }

    private void initBeans() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        for (String key : classMap.keySet()) {
            // 1. init bean
            Object o = Class.forName(classMap.get(key)).getConstructor().newInstance();
            // 2. add
            beans.put(key,o);
        }
    }

    private void setProps() throws NoSuchFieldException, IllegalAccessException {
        for (String key : propsMap.keySet()) {
            Object bean = beans.get(key);
            Class<?> beanClass = beans.get(key).getClass();
            // setProps
            Map<String, String> props = propsMap.get(key);
            for (String name : props.keySet()) {
                Field f = beanClass.getDeclaredField(name);
                f.setAccessible(true);
                f.set(bean,props.get(name));
            }
        }
    }





   

    public static void main(String[] args) throws Exception {
        BeanFactory beanFactory = new BeanFactory("F:\\_eclipse-learn-workspace\\j2se-demos\\reflect-demo\\src\\main\\java\\com\\yuki\\app\\jdbc.properties");
        // 2.
        Object jdbc = beanFactory.beans.get("jdbc");
        System.out.println(jdbc);
    }

}
