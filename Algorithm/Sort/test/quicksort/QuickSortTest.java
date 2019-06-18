package quicksort;

import org.junit.jupiter.api.Test;
import utility.Utility;

class QuickSortTest {

    @Test
    void sort() {
        Integer[] testSet = {-1,5,2,10,6,3,7,-10};
        QuickSort.sort(testSet);
        System.out.println(Utility.print(testSet));
    }

    @Test
    void sortBalanced() {
        Integer[] testSet = {-1,5,2,10,6,3,7,-10};
        QuickSort.sort(testSet);
        System.out.println(Utility.print(testSet));
    }

    @Test
    void performanceTest() {
        System.out.println("----------------------------------" +
                "Quick Sort Performance Begin" +
                "----------------------------------");
        Integer[] testSet = Utility.generateTestArray(100000, -1000,10000);
        Integer[] testSet2 = Utility.generateNearlySortedArray(1000000, -1000,1000,10);


        long beginTime2 = System.nanoTime();
        QuickSort.sortBalanced(testSet2);
        assert Utility.isSorted(testSet2,true);
        long endTime2 = System.nanoTime();
        System.out.println(Utility.performanceEvaluate(beginTime2,endTime2));

        long beginTime = System.nanoTime();
        QuickSort.sort(testSet2);
        long endTime = System.nanoTime();
        System.out.println(Utility.performanceEvaluate(beginTime,endTime));



        System.out.println("----------------------------------" +
                "Quick Sort Performance End" +
                "----------------------------------");
    }
}