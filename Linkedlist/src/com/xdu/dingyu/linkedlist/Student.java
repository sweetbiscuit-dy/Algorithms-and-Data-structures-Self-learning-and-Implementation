package com.xdu.dingyu.linkedlist;

public class Student {
    private String name;
    private int age;
    private int stuID;

    public Student(String name, int age, int stuID) {
        this.name = name;
        this.age = age;
        this.stuID = stuID;
    }

    public Student() {
        this("", -1, -1111);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name).append("---").append(this.age).append("---").
                append(this.stuID);

        return sb.toString();
    }
}