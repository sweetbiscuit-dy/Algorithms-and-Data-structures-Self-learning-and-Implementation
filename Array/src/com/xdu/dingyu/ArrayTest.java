package com.xdu.dingyu;
import java.util.Random;

public class ArrayTest {
    public static void main(String[] args) {
        //************************test of ArrayFirstEdition************************//
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
    }
}
