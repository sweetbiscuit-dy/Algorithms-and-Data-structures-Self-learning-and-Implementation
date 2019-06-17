package quicksort;

import utility.Utility;

/**
 * implementation of the quick sort
 * @author Ding Yu
 * @date 2019/6/17
 */
public class QuickSort {
    public static void sort(Comparable[] array) {
        sort(array, 0, array.length);
    }

    private static void sort(Comparable[] array, int left, int right) {
        if(array == null || array.length == 1) {
            return;
        }

        if(left >= right) {
            return;
        }

        int partition = partition(array, left, right);
        sort(array, left, partition - 1);
        sort(array, partition + 1, right);
    }

    private static int partition(Comparable[] array, int left, int right) {
        // we choose the first element as the partition key.
        Comparable key = array[left];

        for(int current = 1; current <= right; current++) {
            if(array[current].compareTo(key) < 0) {
                Utility.swap(array, );
            }
        }
    }
}
