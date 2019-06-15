package selectionsort;

import utility.Utility;

/**
 * implementation of selection sort
 * @author Ding Yu
 * @date 2019/6/12
 */
public class SelectionSort {
    private SelectionSort() {}

    public static void sort(Comparable[] array) {
        if(array == null || array.length <= 1) {
            return;
        }
        else {
            for(int i = 0; i < array.length; i++) {
                Utility.swap(array, i, Utility.findExtremeValueIndex(array,i, array.length,true));
            }
        }
    }
}
