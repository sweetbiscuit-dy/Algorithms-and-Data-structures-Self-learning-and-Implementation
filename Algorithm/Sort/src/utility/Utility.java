package utility;

import java.util.Random;

/**
 * this is an utility class, it contains some functions that would be commonly used by many sorting algorithms.
 * @author Ding Yu
 * @date 2019/6/14
 */
public class Utility {
    public static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    public static void swap(Comparable[] array, int i, int j) {
        Comparable temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /***
     * find the max or min value's index in a given array.
     * flag being true: find the min value's index. false: the max's index.
     * @param array
     * @param start
     * @param end
     * @param flag
     * @return the index of an extreme value.
     */
    public static int findExtremeValueIndex(Comparable[] array, int start, int end, boolean flag) {
        if(array == null) {
            throw new IllegalArgumentException("array is null");
        }
        if(start < 0 || end > array.length || start > end) {
            throw new IllegalArgumentException("index is out of boundary or invalid");
        }

        Comparable max = array[start];
        Comparable min = array[start];
        int extremeIndex = start;

        if(flag) {
            for(int i = start; i < end; i++) {
                if(min.compareTo(array[i]) > 0) {
                    min = array[i];
                    extremeIndex = i;
                }
            }
        }
        else {
            for(int i = start; i < end; i++) {
                if(max.compareTo(array[i]) < 0) {
                    max = array[i];
                    extremeIndex = i;
                }
            }
        }

        return extremeIndex;
    }

    /**
     * generate an array for the performance test of a particular sorting algorithm.
     * @param arrayLength
     * @param lowerRange
     * @param upperRange
     * @return
     */
    public static Integer[] generateTestArray(int arrayLength, int lowerRange, int upperRange) {

        Integer[] result = new Integer[arrayLength];

        Random random = new Random();

        for(int i = 0; i < arrayLength; i++) {
            result[i] = random.nextInt(upperRange - lowerRange + 1) + lowerRange;
        }
        return result;
    }

    /**
     * check if the array is sorted in the expected order.
     * @param array array to be checked.
     * @param ascending the order in which we expect the array to be.
     * @return true: as expected. false: not in the expect order.
     */
    public static boolean isSorted(Comparable[] array, boolean ascending) {
        for(int i = 0; i < array.length - 1; i++) {
            if(ascending) {
                if(array[i].compareTo(array[i + 1]) > 0) {
                    return false;
                }
            }
            else {
                if(array[i].compareTo(array[i + 1]) < 0) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * it shows the running time of a sorting algorithm.
     * @param beginTime
     * @param endTime
     * @return
     */
    public static String performanceEvaluate(Long beginTime, Long endTime) {
        StringBuilder sb = new StringBuilder();
        sb.append("----------------------------The Total Time Used is : ");
        sb.append((endTime - beginTime) / 1000000000.0);
        sb.append(" S ----------------------------");
        return sb.toString();
    }

    public static String print(Object[] objArray) {
        StringBuffer sb = new StringBuffer();

        sb.append("[");

        for (int i = 0; i < objArray.length; i++) {
            sb.append(objArray[i]);
            if (i != objArray.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");

        return sb.toString();
    }
}
