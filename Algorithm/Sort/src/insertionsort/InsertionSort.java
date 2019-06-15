package insertionsort;

import utility.Utility;

/**
 * implementation of insertion sort
 * @author Ding Yu
 * @date 2019/6/12
 */
public class InsertionSort {
    private InsertionSort() {}

    public static void sort(Comparable[] array) {
        if(array == null || array.length <= 1) {
            return;
        }
        else {
            for(int i = 1; i < array.length; i++) {
                int index = i - 1;
                Comparable currentElement = array[i];
                while(index >= 0 && Utility.less(currentElement, array[index])) {
                    // 1 swap means 3 times of assignments
                    Utility.swap(array, index + 1, index);
                    index--;
                }
            }
        }
    }

    /**
     * optimized insertion sort. this reduces the times of variant assignments from 3 down to 1 in each round.
     * @param array
     */
    public static void sortX(Comparable[] array) {
        if(array == null || array.length <= 1) {
            return;
        }
        else {
            for(int i = 1; i < array.length; i++) {
                Comparable currentCopy = array[i];
                int index = i;

                while(index > 0 && Utility.less(currentCopy, array[index - 1])) {
                    array[index] = array[index - 1];
                    index--;
                }
                array[index] = currentCopy;
            }
        }
    }
}
