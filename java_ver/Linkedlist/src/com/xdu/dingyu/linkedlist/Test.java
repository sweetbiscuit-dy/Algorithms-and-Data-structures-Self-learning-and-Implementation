package com.xdu.dingyu.linkedlist;

/**
 * testing the Linkedlist class
 * @author Ding Yu
 * @date 2019/5/14 night in the lab
 */

public class Test {
    public static void main(String[] args) {
        Student s0 = new Student("Bob", 20, 1000);
        Student s1 = new Student("Pony", 21, 1001);
        Student s2 = new Student("Robin", 22, 1002);
        Student s3 = new Student("Jack", 23, 1003);
        Student s4 = new Student("Alice", 24, 1004);

        //Student[] stuArray  = new Student[5];
        Student[] stuArray  = {s0, s1, s2, s3, s4};

        /*
        stuArray[0] = s0;
        stuArray[1] = s1;
        stuArray[2] = s2;
        stuArray[3] = s3;
        stuArray[4] = s4;
        */

        Linkedlist<Student> ll = new Linkedlist<>(stuArray);

        System.out.println(ll);

        ll.add(0, new Student("Lowrance", 25, 1005));

        System.out.println(ll);

        System.out.println(ll.isEmpty());

        System.out.println(ll.contains(s1));

        ll.set(0, new Student("Deloris", 26, 1005));
        System.out.println(ll);

        ll.delete(0);
        System.out.println(ll);
        ll.deleteLast();
        System.out.println(ll);
    }
}

