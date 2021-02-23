package com.yuki.demo2a;

public class Dog {

    private String name;
    private int age;
    private String skill;

    public Dog() {
    }

    public Dog(String name, int age, String skill) {
        this.name = name;
        this.age = age;
        this.skill = skill;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Dog{");
        sb.append("name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append(", skill='").append(skill).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
