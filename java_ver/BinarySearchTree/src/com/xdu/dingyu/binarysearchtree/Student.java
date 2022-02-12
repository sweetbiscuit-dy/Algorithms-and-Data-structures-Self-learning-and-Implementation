package com.xdu.dingyu.binarysearchtree;

/**
 * @author Ding Yu
 * @date 2019/5/18
 */
public class Student implements Comparable<Student>{
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
    public int compareTo(Student anotherStu) {
        return this.stuID - anotherStu.stuID;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name).append("---").append(this.age).append("---").
                append(this.stuID);

        return sb.toString();
    }
}
