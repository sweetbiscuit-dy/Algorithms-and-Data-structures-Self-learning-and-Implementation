package com.xdu.dingyu;
import java.util.Random;

public class ArrayTest {
    public static void main(String[] args) {
        System.out.println("************************test of ArrayFirstEdition************************");

        ArrayFirstEdition array1 = new ArrayFirstEdition(16);
        Random random = new Random();

        //insert 5 elements into the array
        for(int i = 0; i < 5; i++) {
            array1.addLast(random.nextInt(100));
        }
        System.out.println(array1);

        //test add(int index, int e)
        array1.add(2, 100);
        System.out.println(array1);

        //test remove(int index)
        array1.remove(0);
        System.out.println(array1);
        System.out.println("------------------------------------------------------- ");

        System.out.println("************************test of ArraySecondEdition************************");
        ArraySecondEdition<Student> array2 = new ArraySecondEdition<>(5);
        Student s1 = new Student(20, 1000, "Bob", "boy");
        Student s2 = new Student(22, 1001, "Jack", "boy");
        Student s3 = new Student(20, 1000, "Bob", "boy");
        Student s4 = new Student(20, 1000, "Bob", "boy");
        Student s5 = new Student(20, 1000, "Bob", "boy");

        array2.addLast(s1);
        array2.addLast(s2);
        array2.addLast(s3);
        array2.addLast(s4);
        array2.addLast(s5);

        System.out.println(array2.getCapacity());

        array2.addLast(new Student());

        System.out.println(array2.getCapacity());
        //System.out.println(array2);
        array2.removeLast();
        array2.removeLast();
        array2.removeLast();
        array2.removeLast();
        array2.removeLast();
        System.out.println(array2.getCapacity());
        System.out.println("------------------------------------------------------- ");
    }
}
