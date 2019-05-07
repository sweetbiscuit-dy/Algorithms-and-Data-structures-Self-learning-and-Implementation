package com.xdu.dingyu.stackandqueue;

public class test {
    public static void main(String[] args) {
        ArrayStack<Student> as = new ArrayStack<>();

        System.out.println(String.format("the capacity is : %d", as.getCapacity()));
        System.out.println(String.format("the size is : %d", as.getSize()));

        Student s1 = new Student("Bob", 22, 1000);
        Student s2 = new Student("Bob", 22, 1000);
    }
}
