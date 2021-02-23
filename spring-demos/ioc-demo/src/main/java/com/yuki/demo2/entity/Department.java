package com.yuki.demo2.entity;

public class Department {

    private String name;
    private String address;

    public Department() {
    }

    public Department(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
