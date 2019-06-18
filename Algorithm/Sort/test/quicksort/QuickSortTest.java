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
}