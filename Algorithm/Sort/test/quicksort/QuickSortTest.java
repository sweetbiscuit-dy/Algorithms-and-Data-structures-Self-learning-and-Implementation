package quicksort;

import org.junit.jupiter.api.Test;
import utility.Utility;

import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {

    @Test
    void sort() {
        Integer[] testSet = {-1,5,2,10,6,3,7,-10};
        QuickSort.sort(testSet);
        System.out.println(Utility.print(testSet));
    }
}