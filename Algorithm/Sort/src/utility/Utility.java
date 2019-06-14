package utility;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Random;

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

    public static <T> T[] generateIntegerTestArray(int arrayLength, int testLowerRange,
                                                   int testUpperRange, Class<T> tClass, Class<?> parameterTypes) {

        T[] result = (T[])Array.newInstance(tClass, arrayLength);
        try {
            Constructor constructor = tClass.getConstructor(parameterTypes);
            Random random = new Random();

            for(int j = 0; j < arrayLength; j++) {
                try {
                    result[j] = (T)constructor.newInstance(random.nextInt(testUpperRange - testLowerRange + 1) + testLowerRange);
                } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        } catch (NoSuchMethodException e) {
            System.out.println("such constructor does not exist");
            e.printStackTrace();
        }

        return result;
    }

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
