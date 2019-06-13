package insertionsort;

import utility.Utility;

/**
 * implementation of insertion sort
 * @author Ding Yu
 * @date 2019/6/12
 */
public class InsertionSort {
    public static void sort(Comparable[] array) {
        if(array == null || array.length <= 1) {
            return;
        }
        else {
            for(int i = 1; i < array.length; i++) {
                int index = i - 1;
                Comparable currentElement = array[i];
                while(index >= 0 && Utility.less(currentElement, array[index])) {
                    Utility.swap(array, index + 1, index);
                    index--;
                }
            }
        }
    }
}
