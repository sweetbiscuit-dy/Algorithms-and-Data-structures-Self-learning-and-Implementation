package selectionsort;

import org.junit.jupiter.api.Test;
import utility.Utility;

class SelectionSortTest {

    @Test
    void selectionSort() {
        Integer[] testSet = {5,3,6,0,10,-3,7,2,4,22,-5};

        System.out.println("----------------------Before Sorting----------------------");
        System.out.println(Utility.print(testSet));

        System.out.println("----------------------After Sorting-----------------------");
        SelectionSort.sort(testSet);
        System.out.println(Utility.print(testSet));

        System.out.println("----------------------Performance Test-----------------------");
        Integer[] testCase = Utility.generateTestArray(1000, -100, 100);

        long beginTime = System.nanoTime();
        SelectionSort.sort(testCase);
        long endTime = System.nanoTime();
        System.out.println(Utility.performanceEvaluate(beginTime, endTime));
    }
}