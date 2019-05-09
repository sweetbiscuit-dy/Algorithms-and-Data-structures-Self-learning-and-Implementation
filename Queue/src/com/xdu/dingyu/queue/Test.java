package com.xdu.dingyu.queue;

/**
 * testing the ArrayQueue
 * @author Ding Yu
 * @date 2019/5/9 night in the lab
 */
public class Test {
    public static void main(String[] args) {
        Student s1 = new Student("Bob", 22, 1000);
        Student s2 = new Student("Pony", 23, 1002);
        Student s3 = new Student("Jack", 24, 1003);
        Student s4 = new Student("Alice", 25, 1004);
        Student s5 = new Student("Robin", 26, 1005);

        ArrayQueue<Student> aq = new ArrayQueue<>();

        aq.enqueue(s1);
        aq.enqueue(s2);
        aq.enqueue(s3);
        aq.enqueue(s4);
        aq.enqueue(s5);

        System.out.println(aq.toString());

        aq.dequeue();
        System.out.println(aq.toString());
    }
}