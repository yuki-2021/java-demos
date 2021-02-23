package com.yuki.demo2.entity;

public class Employee {

    // id
    private int id;
    // name
    private String name;
    // dept
    private Department dept;
    // Car
    private Car car;


    public Employee() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDept() {
        return dept;
    }

    public void setDept(Department dept) {
        this.dept = dept;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Employee{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", dept=").append(dept);
        sb.append(", car=").append(car);
        sb.append('}');
        return sb.toString();
    }
}
