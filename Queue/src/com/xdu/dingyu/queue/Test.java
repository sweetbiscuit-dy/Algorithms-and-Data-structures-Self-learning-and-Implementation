package com.xdu.dingyu.queue;

/**
 * testing the ArrayQueue
 * @author Ding Yu
 * @date 2019/5/9 night in the lab
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("--------------------------------------------------------Array Queue Test-------------------------------------------------------------------------");
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

        System.out.println("-----------------------------------------------------Loop Queue Test----------------------------------------------------------------------------");

        LoopQueue<Student> lq = new LoopQueue<>(5);
        lq.enqueue(s1);
        lq.enqueue(s2);
        lq.enqueue(s3);
        lq.enqueue(s4);
        lq.enqueue(s5);
        System.out.println(lq);

        lq.enqueue(new Student("Mark", 27, 1006));
        System.out.println(lq);


        System.out.println("-------------------------------------------------------Linkedlist Queue Test--------------------------------------------------------------------------");
        Student[] stuArray = new Student[5];
        stuArray[0] = s1;
        stuArray[1] = s2;
        stuArray[2] = s3;
        stuArray[3] = s4;
        stuArray[4] = s5;
        LinkedQueue<Student> llq = new LinkedQueue<>(stuArray);
        System.out.println(llq);
    }
}