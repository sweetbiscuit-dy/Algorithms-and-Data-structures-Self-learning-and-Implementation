package com.xdu.dingyu.stackandqueue;

/**
 * testing the ArrayStack.
 * @author Ding Yu
 * @date 2019/5/8 Desktop
 */
public class Test {
    public static void main(String[] args) {
        ArrayStack<Student> as = new ArrayStack<>();

        System.out.println(String.format("the capacity is : %d", as.getCapacity()));
        System.out.println(String.format("the size is : %d", as.getSize()));

        Student s1 = new Student("Bob", 22, 1000);
        Student s2 = new Student("Jack", 23, 1001);
        Student s3 = new Student("Pony", 24, 1002);
        Student s4 = new Student("Robin", 25, 1003);
        Student s5 = new Student("Alice", 26, 1004);

        as.push(s1);
        as.push(s2);
        as.push(s3);
        as.push(s4);
        as.push(s5);
        System.out.println(as);
        System.out.println(String.format("the capacity is : %d", as.getCapacity()));
        System.out.println(String.format("the size is : %d", as.getSize()));

        System.out.println("-------------------------------------------------------------------------------");

        LinkedStack<Student> ls = new LinkedStack<>();
        ls.push(s1);
        ls.push(s2);
        ls.push(s3);
        ls.push(s4);
        ls.push(s5);

        System.out.println(ls);
    }
}
