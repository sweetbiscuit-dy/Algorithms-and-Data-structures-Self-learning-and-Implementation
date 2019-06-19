package quicksort;

import utility.Utility;

import javax.swing.plaf.synth.SynthDesktopIconUI;
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

    /**
     * this is used when the array to be sorted has a large number of identical elements, which means even the 'partition' algorithm is
     * refined by randomly choosing an element in the array as the 'key', the performance of the quick sort is rather intolerable.
     * this is because the elements identical to the key are sorted together thus making one part of the sub-array after partition too 'heavy',
     * it could reduce the method call tree to a linked list, resulting the height of the tree very large.
     * @param array array to sorted.
     */
    public static void sortBalanced(Comparable[] array) {
        sortBalanced(array, 0, array.length - 1);
    }

    private static void sortBalanced(Comparable[] array, int left, int right) {
        if(left >= right) {
            return;
        }

        int partition = partitionBalanced(array, left, right);
        sortBalanced(array, left, partition - 1);
        sortBalanced(array, partition + 1, right);
    }

    /**
     * called by sortBalanced.
     * @param array array to be sorted
     * @param left lower boundary of the array
     * @param right upper boundary of the array
     * @return the the last element's index of the sub-array whose elements are all less than the key after the partition process.
     */
    private static int partitionBalanced(Comparable[] array, int left, int right) {
        Random random  = new Random(System.nanoTime());
        Utility.swap(array, left, random.nextInt(right - left + 1) + left);
        Comparable key = array[left];

        int notSortedHead = left + 1;
        int notSortedTail = right;

        while(notSortedHead <= notSortedTail) {
            if(array[notSortedHead].compareTo(key) < 0) {
                notSortedHead++;
            }
            else if(array[notSortedTail].compareTo(key) > 0) {
                notSortedTail--;
            }
            else {
                Utility.swap(array, notSortedHead, notSortedTail);
                notSortedHead++;
                notSortedTail--;
            }
        }
        Utility.swap(array, left, notSortedTail);
        return notSortedTail;
    }

    public static void sort3Way(Comparable[] array) {
        sort3Way(array, 0, array.length - 1);
    }

    private static void sort3Way(Comparable[] array, int left, int right) {
        if(left >= right) {
            return;
        }

        int lt = left;
        int gt = right + 1;

        Random random = new Random(System.nanoTime());

        Utility.swap(array, left, random.nextInt(right - left + 1) + left);
        Comparable key = array[left];

        int current = left + 1;

        // we cannot use for loop here because the 'gt' is updated inside the loop,
        // if we iterate while changing the terminate condition, there could be error.
        while (current < gt) {
            if(array[current].compareTo(key) < 0) {
                Utility.swap(array, current, lt + 1);
                lt++;
                current++;
            }
            else if(array[current].compareTo(key) > 0) {
                Utility.swap(array, current, gt - 1);
                gt--;
            }
            else {
                current++;
            }
        }
        Utility.swap(array, left, lt);
        // lt--;
        sort3Way(array, left, lt - 1);
        sort3Way(array, gt, right);
    }
}
