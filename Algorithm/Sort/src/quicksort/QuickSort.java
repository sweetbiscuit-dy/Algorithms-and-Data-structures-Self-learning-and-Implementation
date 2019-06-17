package quicksort;

import utility.Utility;

/**
 * implementation of the quick sort
 * @author Ding Yu
 * @date 2019/6/17
 */
public class QuickSort {
    public static void sort(Comparable[] array) {
        sort(array, 0, array.length - 1);
    }

    private static void sort(Comparable[] array, int left, int right) {
        // this statement covers conditions like 'array == null || array.length == 1',
        // so there is no need to specify the above conditions.
        if(left >= right) {
            return;
        }

        int partition = partition(array, left, right);

        // recursive call, quick sort on the left part
        sort(array, left, partition - 1);

        // recursive call, quick sort on the right part
        sort(array, partition + 1, right);
    }

    private static int partition(Comparable[] array, int left, int right) {
        // we choose the first element as the partition key.
        Comparable key = array[left];

        int smallIndex = left;
        for(int current = left + 1; current <= right; current++) {
            if(array[current].compareTo(key) < 0) {
                Utility.swap(array, smallIndex + 1, current);
                smallIndex++;
            }
        }

        Utility.swap(array, left, smallIndex);
        return smallIndex;
    }
}
