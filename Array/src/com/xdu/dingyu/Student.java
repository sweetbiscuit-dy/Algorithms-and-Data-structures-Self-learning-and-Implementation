package com.xdu.dingyu;

/**
 * demo class
 * @author Ding yu
 * @date 2019/5/3
 */
public class Student implements Comparable<Student>{
    private int age;
    private int stuID;
    private String name;
    private String gender;

    public Student(int age, int stuID, String name, String gender) {
        this.age = age;
        this.stuID = stuID;
        this.name = name;
        this.gender = gender;
    }

    public Student() {
        this.age = 0;
        this.stuID = -1;
        this.name = null;
        this.gender = null;
    }

    @Override
    public int compareTo(Student object) {
        return this.age - object.age;
    }

    /**
     * special attention here. the override of a method must comply with the definition,
     * which means the method name and its return value type and the argument list must be
     * the same with that of its superclass. If the argument type is different, conversion
     * is necessary.
     * @param object
     */
    @Override
    public boolean equals(Object object) {
        Student temp = (Student)object;
        return this.stuID == temp.stuID;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("age : ").append(age).append("---stuID : ").append(stuID).
                append("---name : ").append(name).append("---gender : ").append(gender);

        return sb.toString();
    }
}