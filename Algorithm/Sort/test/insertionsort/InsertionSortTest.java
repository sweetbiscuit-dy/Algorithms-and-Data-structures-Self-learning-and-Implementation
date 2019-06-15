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
}