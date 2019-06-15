package bubblesort;

import utility.Utility;

/**
 * implementation of bubble sort
 * @author Ding Yu
 * @date 2019/6/15
 */
public class BubbleSort {
    private BubbleSort() {}

    public static void sort(Comparable[] array) {
        if(array == null || array.length <= 1) {
            return;
        }
        else {
            for(int i = array.length - 1; i >= 0; i--) {
                for(int j = 0 ; j < i; j++) {
                    if(Utility.less(array[j + 1], array[j])) {
                        Utility.swap(array, j, j + 1);
                    }
                }
            }
        }
    }
}
