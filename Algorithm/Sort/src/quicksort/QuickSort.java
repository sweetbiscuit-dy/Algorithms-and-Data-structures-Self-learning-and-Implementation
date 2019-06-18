package quicksort;

import utility.Utility;

import java.util.Random;

/**
 * implementation of the quick sort
 * @author Ding Yu
 * @date 2019/6/17
 */
public class QuickSort {
    /**
     * quick sort prototype. user oriented.
     * @param array array to be sorted
     */
    public static void sort(Comparable[] array) {
        sort(array, 0, array.length - 1);
    }

    /**
     * inner function called by 'sort' above.
     * @param array
     * @param left
     * @param right
     */
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

    /**
     * inner function called by 'partition' above.
     * @param array
     * @param left
     * @param right
     * @return
     */
    private static int partition(Comparable[] array, int left, int right) {
        // we choose the first element as the partition key.
        Comparable key = array[left];

        int smallIndex = left;
        for (int current = left + 1; current <= right; current++) {
            if (array[current].compareTo(key) < 0) {
                Utility.swap(array, smallIndex + 1, current);
                smallIndex++;
            }
        }

        Utility.swap(array, left, smallIndex);
        return smallIndex;
    }

    public static void sortBalanced(Comparable[] array) {
        sortBalanced(array, 0, array.length);
    }

    private static void sortBalanced(Comparable[] array, int left, int right) {
        if(left >= right) {
            return;
        }

        int partition = partitionBalanced(array, left, right);
        sortBalanced(array, left, partition - 1);
        sortBalanced(array, partition + 1, right);
    }

    private static int partitionBalanced(Comparable[] array, int left, int right) {
        Random random  = new Random(System.nanoTime());
        Utility.swap(array, left, random.nextInt(right - left + 1) + left);
        Comparable key = array[left];

        int notSortedHead = left + 1;
        int notSortedTail = right;

        while(notSortedHead != notSortedTail) {
            if(array[notSortedHead].compareTo(key) < 0) {
                notSortedHead++;
            }
            else if(array[notSortedTail].compareTo(key) > 0) {
                notSortedTail++;
            }
            else {
                Utility.swap(array, notSortedHead, notSortedTail);
            }
        }

        return notSortedHead;
    }
}
