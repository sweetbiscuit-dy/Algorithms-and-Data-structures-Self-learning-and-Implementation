package utility;

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
