package insertionsort;

import org.junit.jupiter.api.Test;
import utility.Utility;

import java.util.Arrays;

class InsertionSortTest {

    @Test
    void sort() {
        Integer[] testSet = {5,3,6,0,10,-3,7,2,4,22,-5};
        System.out.println("----------------------Before Sorting----------------------");
        System.out.println(Utility.print(testSet));

        System.out.println("----------------------After Sorting-----------------------");
        // InsertionSort.sort(testSet);
        InsertionSort.sortX(testSet);
        if(Utility.isSorted(testSet,true)) {
            System.out.println("correctly sorted in ascending order");
        }
        else {
            System.out.println("NOT correctly sorted in ascending order");
        }
        System.out.println(Utility.print(testSet));
    }

    @Test
    void sortX() {

    }

    @Test
    void performanceCompare() {
        Integer[] testSet = Utility.generateTestArray(100000, -100, 100, Integer.class, int.class);
        Integer[] testSetCopy = Arrays.copyOf(testSet, testSet.length);

        System.out.println("----------------------Performance Compare-----------------------");
        long beginTime1 = System.nanoTime();
        InsertionSort.sort(testSet);
        long endTime = System.nanoTime();

        long beginTime2 = System.nanoTime();
        InsertionSort.sortX(testSetCopy);
        long endTime2 = System.nanoTime();
        System.out.println("Sort is :" + Utility.performanceEvaluate(beginTime1, endTime));
        System.out.println("SortX is :" + Utility.performanceEvaluate(beginTime2, endTime2));
        /**
         * the performance compare result
         * ----------------------Performance Compare-----------------------
         * Sort is :----------------------------The Total Time Used is : 30.421853312 S ----------------------------
         * SortX is :----------------------------The Total Time Used is : 17.978310967 S ----------------------------
         */
    }
}