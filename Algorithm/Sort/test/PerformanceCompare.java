import bubblesort.BubbleSort;
import insertionsort.InsertionSort;
import org.junit.jupiter.api.Test;
import utility.Utility;

import java.util.Arrays;

public class PerformanceCompare {
    @Test
    void performanceCompare() {
        Integer[] testSet = Utility.generateTestArray(50000, -100, 100);
        Integer[] testSetCopy1 = Arrays.copyOf(testSet, testSet.length);
        Integer[] testSetCopy2 = Arrays.copyOf(testSet, testSet.length);

        System.out.println("----------------------Performance Compare-----------------------");
        long beginTime1 = System.nanoTime();
        InsertionSort.sort(testSet);
        long endTime = System.nanoTime();

        long beginTime2 = System.nanoTime();
        InsertionSort.sortX(testSetCopy1);
        long endTime2 = System.nanoTime();

        long beginTime3 = System.nanoTime();
        BubbleSort.sort(testSetCopy2);
        long endTime3 = System.nanoTime();

        System.out.println("Insertion Sort is :" + Utility.performanceEvaluate(beginTime1, endTime));
        System.out.println("Insertion SortX is :" + Utility.performanceEvaluate(beginTime2, endTime2));
        System.out.println("Bubble Sort is :" + Utility.performanceEvaluate(beginTime2, endTime2));
        /**
         * the performance compare result
         * ----------------------Performance Compare-----------------------
         * Sort is :----------------------------The Total Time Used is : 30.421853312 S ----------------------------
         * SortX is :----------------------------The Total Time Used is : 17.978310967 S ----------------------------
         */
    }
}
