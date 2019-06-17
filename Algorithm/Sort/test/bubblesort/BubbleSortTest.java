package bubblesort;

import org.junit.jupiter.api.Test;
import utility.Utility;

import static org.junit.jupiter.api.Assertions.*;

class BubbleSortTest {

    @Test
    void sort() {
        Integer[] testSet = Utility.generateTestArray(100, -100, 100);
        System.out.println("----------------------Before Sorting----------------------");
        System.out.println(Utility.print(testSet));
        System.out.println("----------------------After Sorting-----------------------");
        BubbleSort.sort(testSet);
        System.out.println(Utility.isSorted(testSet,true));
        System.out.println(Utility.print(testSet));
    }
}